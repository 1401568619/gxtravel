package com.gxtravel.controller;

import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.Scenic;
import com.gxtravel.entity.ScenicScore;
import com.gxtravel.entity.User;
import com.gxtravel.service.RecommendService;
import com.gxtravel.service.ScenicService;
import com.gxtravel.utils.ExportUtil;
import com.gxtravel.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RecommendController {
    @Autowired
    RecommendService recommendService;

    @Autowired
    ScenicService scenicService;

    /**
     * 查询当前用户的景点评分
     * @return
     */
    @RequestMapping(value = "/getMyScore")
    public String getMyScore(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Scenic> myScenicScore = recommendService.getMyScore(user.getUserid());
        model.addAttribute("myScenicScore", myScenicScore);
        return "user/myScore";
    }

    /**
     * 查询相似用户喜欢的景点
     * @return
     */
    @RequestMapping(value = "/selectScenicByUser")
    @ResponseBody
    public List<Scenic> selectScenicByUser(Integer userid){

        return scenicService.selectScenicByUser(userid);
    }

    /**
     * 推荐相似用户
     * @return
     */
    @RequestMapping(value = "/findSimilarUser")
    public String findSimilarUser(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        List<User> similarUser = recommendService.findSimilarUser(user.getUserid());
        model.addAttribute("similarUserList", similarUser);
        return "user/similarUser";
    }

    /**
     * 推荐相似景点
     * @return
     */
    @RequestMapping(value = "/findSimilarItem")
    public String findSimilarItem(Model model, QueryVo vo, Integer scenicid){
        Page<Scenic> similarItem = recommendService.findSimilarItem(scenicid, vo);
        model.addAttribute("page", similarItem);
        return "user/scenicList";
    }

    /**
     * 删除过期评分
     * @return
     */
    @RequestMapping(value = "/cleanScenicScore")
    @ResponseBody
    public String cleanScenicScore(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //获取一年前的时间
        long t = System.currentTimeMillis() - 31536000000l;
        String time = sdf.format(new Date(t));
        System.out.println(time);
        recommendService.deleteOld(time);
        return "ok";
    }
    /**
     * 修改或增加评分
     * @return
     */
    @RequestMapping(value = "/submitScenicScore")
    @ResponseBody
    public String changeScenicScore(HttpSession session, ScenicScore scenicScore){
        User user = (User)session.getAttribute("user");
        scenicScore.setUserid(user.getUserid());
        scenicScore.setTime(new Date());
        recommendService.changeScenicScore(scenicScore);
        //System.out.println(scenicScore.getUserid()+" "+scenicScore.getScenicid()+" "+scenicScore.getScore());
        return "ok";
    }

    /**
     * 将数据库的数据导出到scenicscore.txt
     * @return
     */
    @RequestMapping(value = "/exportScore")
    @ResponseBody
    public String exportScore(){
        List<ScenicScore> scenicScoreList = new ArrayList<>();
        scenicScoreList = recommendService.selectScenicScoreList();
        try {
            ExportUtil.exportScenicScore(scenicScoreList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * 推荐景点
     * @return
     */
    @RequestMapping(value = "/getRecommend")
    public String getRecommend(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Scenic> recommendScenic = recommendService.recommendScenicForUser(user.getUserid().longValue(), 10);
        //如果用户第一次登陆，则推荐好评较多的景点
        if(recommendScenic == null){
            recommendScenic = recommendService.selectPopScenicForUser();
        }
        model.addAttribute("recommendScenic", recommendScenic);
        return "user/recommendInfo";
    }

    /**
     * 查询所有评分
     * @return
     */
    @RequestMapping(value = "/managerScore")
    public String managerScore(QueryVo vo, Model model){
        Page<ScenicScore> page = new Page<>();
        page = recommendService.selectPageByQueryVo(vo);
        model.addAttribute("page", page);
        return "manager/score";
    }
}
