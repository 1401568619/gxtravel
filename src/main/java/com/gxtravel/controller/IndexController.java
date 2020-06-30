package com.gxtravel.controller;

import com.gxtravel.entity.Scenic;
import com.gxtravel.entity.TastyFood;
import com.gxtravel.service.FoodService;
import com.gxtravel.service.ScenicService;
import com.gxtravel.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ScenicService scenicService;
    @Autowired
    FoodService foodService;
    @Autowired
    TicketService ticketService;

    /**
     * 管理员登陆界面
     * @return
     */
    @RequestMapping(value = "/managerLoginPage")
    public String toManagerLoginPage(){
        return "manager/login";
    }

    /**
     * 加载管理员首页
     * @return
     */
    @RequestMapping(value = "/manager")
    public String testManagerIndex(){
        return "manager/index";
    }

    /**
     * 用户登录界面
     * @return
     */
    @RequestMapping(value = "/loginPage")
    public String toLoginPage(){
        return "user/login";
    }

    /**
     * 用户注册界面
     * @return
     */
    @RequestMapping(value = "/registerPage")
    public String toRegisterPage(){
        return "user/register";
    }

    @RequestMapping(value = "/userInfoPage")
    public String toInformationPage(){
        return "user/userInfo";
    }

//    /**
//     * 加载用户主界面
//     * @return
//     */
//    @RequestMapping(value = "/userIndex")
//    public ModelAndView testUserIndex(HttpServletRequest request){
//        System.out.println("来了");
//        ModelAndView mv = new ModelAndView("user/index.jsp");
//        List<Scenic> list =  scenicService.selectScenicList();
//        //List<TastyFood> listFood =  foodService.selectFoodList();
//        list = list.subList(0, 3);
//        //listFood = listFood.subList(0, 3);
//        mv.addObject("list",list);
//        request.getSession().setAttribute("flag", 1);
//       // model.addAttribute("listFood",listFood);
//        return mv;
//    }

    /**
     * 加载用户主界面
     * @return
     */
    @RequestMapping(value = "/userIndex")
    @ResponseBody
    public String  testUserIndex(HttpServletRequest request){
        //System.out.println("来了");
        List<Scenic> list =  scenicService.selectScenicList();
        List<TastyFood> listFood =  foodService.selectFoodList();
        list = list.subList(0, 3);
        listFood = listFood.subList(0, 3);
        request.getSession().setAttribute("list",list);
        request.getSession().setAttribute("listFood",listFood);
        return "ok";
    }
}