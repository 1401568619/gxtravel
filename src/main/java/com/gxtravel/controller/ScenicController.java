package com.gxtravel.controller;

import com.gxtravel.entity.*;
import com.gxtravel.service.RecommendService;
import com.gxtravel.service.ScenicService;
import com.gxtravel.service.TicketService;
import com.gxtravel.utils.Page;
import com.gxtravel.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ScenicController {
    @Autowired
    ScenicService scenicService;
    @Autowired
    TicketService ticketService;
    @Autowired
    RecommendService recommendService;

    /**
     * 管理员管理所有景点
     * @param model
     * @param vo
     * @return
     */
    @RequestMapping(value = "/manageScenic")
    public String getScenicPage(Model model,QueryVo vo){
        Page<Scenic> page = scenicService.selectPageByQueryVo(vo);
        model.addAttribute("page", page);
        model.addAttribute("name",vo.getName());
        model.addAttribute("addr", vo.getAddr());
        model.addAttribute("theme", vo.getTheme());
        return "manager/scenic";
    }

    /**
     * 查询到景点详情页
     * @return
     */
    @RequestMapping(value = "/getScenicAndTicket")
    public String getScenicAndTicket(Model model, Integer id, HttpSession session){
        Scenic scenic = scenicService.getScenicById(id);
        List<Ticket> ticketList =  ticketService.selectTicketListByFid(scenic.getId());
        if(ticketList.size()>0){
                double cheapestPrice = ticketService.selectPriceByFid(scenic.getId());
                scenic.setTicketList(ticketList);
                scenic.setCheapestPrice(cheapestPrice);
        }
        //浏览一次评分+1，回显评分
        User user = (User)session.getAttribute("user");
        if(user != null){
            ScenicScore scenicScore = recommendService.findScenicScore(user.getUserid(), id);
            if(scenicScore != null){
                //最多五分
                if(scenicScore.getScore() < 5.0){
                    scenicScore.setScore(scenicScore.getScore() + 1.0);
                    recommendService.changeScenicScore(scenicScore);
                }
                model.addAttribute("score", scenicScore.getScore().intValue());
            }else{
                //第一次浏览该景点，默认3分
                ScenicScore scenicScore2 = new ScenicScore(user.getUserid(), id, 3.0, new Date());
                recommendService.changeScenicScore(scenicScore2);
                model.addAttribute("score", scenicScore2.getScore().intValue());
            }
        }
        model.addAttribute("scenic", scenic);
        return "user/ticketList";
    }

    /**
     * 为用户展示所有的景点信息getScenicPageForUser
     * @param model
     * @param vo
     * @return
     */
    @RequestMapping(value = "/getScenicPageForUser")
    public String getScenicPageForUser(Model model, QueryVo vo, HttpServletRequest request){
        String searchParameter = request.getParameter("search");
        System.out.println(searchParameter);
        if(searchParameter !=null){
            vo.setName(searchParameter);
            model.addAttribute("searchParameter",searchParameter);
        }
        Page<Scenic> page = scenicService.selectPageByQueryVo(vo);
//        for (Scenic scenic :page.getRows()) {
//            List<Ticket> ticketList =  ticketService.selectTicketListByFid(scenic.getId());
//            if(ticketList.size()>0){
//                double cheapestPrice = ticketService.selectPriceByFid(scenic.getId());
//                scenic.setTicketList(ticketList);
//                scenic.setCheapestPrice(cheapestPrice);
//            }
//        }
        //根据参数判断目前是不是根据地址获得景点信息
        String addrParameter = request.getParameter("addr");
        if (addrParameter!=null){
            model.addAttribute("addrParameter",addrParameter);
        }
        model.addAttribute("page", page);
        return "user/scenicList";
    }

    /**
     * 管理员新增景点信息
     * @param scenic
     * @return
     */
    @RequestMapping(value = "/addScenic")
    public String insert(Scenic scenic,MultipartFile scenicImage){
        //当上传的图片不为空的时候才去存储路径,否则不存
        if (scenicImage.getSize() != 0) {
            //将上传的文件保存到磁盘中
            String path = "F:\\dev\\ideaspace\\gxtravel\\src\\main\\webapp\\image\\scenic\\pic";
            String imageName = UploadUtil.upload(scenicImage,path);
            //将图片路径封装到Scenic中
            scenic.setPic("image/scenic/pic/"+imageName);
        }
        //插入
        scenicService.addScenic(scenic);
        return "redirect:/manageScenic";
    }

    //删除
    @RequestMapping(value = "/deleteScenic")
    public @ResponseBody
    String deleteScenic(Integer id){
        //删除
        scenicService.deleteById(id);
        return "OK";
    }

    /**
     * 管理员修改景点信息
     * @param scenic
     * @return
     */
    @RequestMapping(value = "/updateScenic")
    public String update(Scenic scenic,MultipartFile scenicImage){
        //当上传的图片不为空的时候才去存储路径,否则不存
        if (scenicImage.getSize() != 0) {
            //将上传的文件保存到磁盘中
            String path = "F:\\dev\\ideaspace\\gxtravel\\src\\main\\webapp\\image\\scenic\\pic";
            String imageName = UploadUtil.upload(scenicImage,path);
            //将图片路径封装到Scenic中
            scenic.setPic("image/scenic/pic/"+imageName);
        }
        //插入
        scenicService.updateScenic(scenic);
        return "redirect:/manageScenic";
    }

    /**
     * 根据id获得景点信息
     * @param
     * @return
     */
    @RequestMapping(value = "/getScenicById")
    public @ResponseBody Scenic getScenicById(Integer id){
        Scenic scenic = scenicService.getScenicById(id);
        return scenic;
    }

    @RequestMapping(value="/getScenicList")
    public @ResponseBody Map<String,Object> getScenicList(){
        List<Scenic> list =  scenicService.selectScenicList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data",list);
        return map;
    }
}