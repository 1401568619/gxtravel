package com.gxtravel.service;

import com.gxtravel.entity.*;
import com.gxtravel.utils.Page;

import java.util.List;
import java.util.Map;

public interface RecommendService {
    public void batchInsert(List<ScenicScore> list);

    public List<Scenic> recommendScenicForUser(long userid, int size);

    public  List<ScenicScore> selectScenicScoreList();

    public Page<ScenicScore> selectPageByQueryVo(QueryVo vo);

    public int changeScenicScore(ScenicScore scenicScore);

    int deleteOld(String time);

    List<Scenic> selectPopScenicForUser();

    ScenicScore findScenicScore(Integer userid, Integer scenicid);

    public List<Statistic> selectCountByTheme(String atime, String btime);

    public Page<Scenic> findSimilarItem(Integer scenicid, QueryVo vo);

    List<User> findSimilarUser(Integer userid);

    List<Scenic> getMyScore(Integer userid);
}
