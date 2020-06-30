package com.gxtravel.service.impl;

import com.gxtravel.dao.ScenicMapper;
import com.gxtravel.dao.ScenicScoreMapper;
import com.gxtravel.dao.UserMapper;
import com.gxtravel.entity.*;
import com.gxtravel.service.RecommendService;
import com.gxtravel.utils.GetSimilarItem;
import com.gxtravel.utils.MyItemBasedRecommender;
import com.gxtravel.utils.MyUserBasedRecommender;
import com.gxtravel.utils.Page;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    ScenicScoreMapper scenicScoreMapper;

    @Autowired
    ScenicMapper scenicMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public void batchInsert(List<ScenicScore> list) {
        scenicScoreMapper.batchInsert(list);
    }

    @Override
    public List<Scenic> recommendScenicForUser(long userid, int size) {
        //推荐景点的list
        List<RecommendedItem> recommendation = null;
        MyItemBasedRecommender mibr = new MyItemBasedRecommender();

        //拿到推荐的景点--基于物品的协同过滤推荐算法
        recommendation = mibr.myItemBasedRecommender(userid,size);
        if(recommendation == null){
            return null;
        }
        //景点信息list
        List<Scenic> scenicList = new ArrayList<>();
        for (RecommendedItem recommendedItem : recommendation) {
            Long itemID = recommendedItem.getItemID();
            //获取景点id
            Scenic scenic = scenicMapper.getScenicById(itemID.intValue());
            //获取景点预测评分，保留一位小数
            double prediction = new BigDecimal(recommendedItem.getValue()).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
            scenic.setPrediction(prediction);
            scenicList.add(scenic);
        }

        return scenicList;
    }

    @Override
    public List<ScenicScore> selectScenicScoreList() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //获取一个月前的时间
        long t = System.currentTimeMillis() - 2592000000l;
        String time = sdf.format(new Date(t));
        return scenicScoreMapper.selectScenicScoreList(time);
    }

    public Page<ScenicScore> selectPageByQueryVo(QueryVo vo){
        Page<ScenicScore> page = new Page<>();
        //每页数
        page.setSize(10);
        vo.setSize(10);
        if (null != vo) {
            // 判断当前页
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() -1)*vo.getSize());
            }
            //总条数
            page.setTotal(scenicScoreMapper.getScoreCount());
            page.setRows(scenicScoreMapper.selectScorerListByQueryVo(vo));
        }
        return page;
    }

    @Override
    public int changeScenicScore(ScenicScore scenicScore) {
        int row = scenicScoreMapper.updateScenicScore(scenicScore);
        if(row == 0) {
            row = scenicScoreMapper.addScenicScore(scenicScore);
        }
        return row;
    }

    @Override
    public int deleteOld(String time) {
        int i = scenicScoreMapper.deleteOld(time);
        return i;
    }

    @Override
    public List<Scenic> selectPopScenicForUser() {
        List<Integer> scenicIdList = scenicScoreMapper.selectPopScenicid();
        List<Scenic> scenicList = new ArrayList<>();
        for (Integer scenicid : scenicIdList) {
            Scenic scenic = scenicMapper.getScenicById(scenicid);
            scenic.setPrediction(4.5);
            scenicList.add(scenic);
        }
        return scenicList;
    }

    @Override
    public ScenicScore findScenicScore(Integer userid, Integer scenicid) {
        ScenicScore scenicScore = scenicScoreMapper.findScenicScore(userid, scenicid);
        return scenicScore;
    }

    @Override
    public List<Statistic> selectCountByTheme(String atime, String btime) {
        return scenicScoreMapper.selectCountByTheme(atime, btime);
    }

    @Override
    public Page<Scenic> findSimilarItem(Integer scenicid, QueryVo vo) {
        Page<Scenic> page = new Page<Scenic>();
        //每页数

        Scenic scenic = scenicMapper.getScenicById(scenicid);
        //得到所有scenicList
        List<Scenic> scenicList = scenicMapper.selectScenicList();
        //得到scenicid的相似集合
        GetSimilarItem SimilarItem = new GetSimilarItem();
        List<Scenic> similarItem = SimilarItem.getSimilarItem(scenicid.longValue(), scenicList);
        if(similarItem.size() == 0){
            //如果没有近似的景点，查询相同类型的
            vo.setTheme(scenic.getTheme());
            vo.setSize(5);
            page.setSize(5);
            page.setPage(vo.getPage());
            page.setTotal(scenicMapper.postCountByQueryVo(vo));
            page.setRows(scenicMapper.selectPostListByQueryVo(vo));
        }else{
            page.setPage(1);
            page.setSize(similarItem.size());
            page.setTotal(similarItem.size());
            page.setRows(similarItem);
        }

        return page;
    }

    @Override
    public List<User> findSimilarUser(Integer userid) {
        MyUserBasedRecommender mybr = new MyUserBasedRecommender();
        List<User> similarUserA = mybr.getSimilarUser(userid.longValue());
        if(similarUserA.size() == 0){
          return null;
        }
        List<User> similarUserB = new ArrayList<>();
        for (User usera : similarUserA) {
            User userb = userMapper.selectUserById(usera.getUserid());
            userb.setSimilarity(usera.getSimilarity());
            similarUserB.add(userb);
        }
        return similarUserB;
    }

    @Override
    public List<Scenic> getMyScore(Integer userid) {
        List<Scenic> scenicList = new ArrayList<>();
        List<ScenicScore> scenicScoreList = scenicScoreMapper.selectScenicScoreByUser(userid);
        for (ScenicScore scenicScore : scenicScoreList) {
            Scenic scenic = scenicMapper.getScenicById(scenicScore.getScenicid());
            scenic.setPrediction(scenicScore.getScore());
            scenicList.add(scenic);
        }
        return scenicList;
    }
}
