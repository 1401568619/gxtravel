package com.gxtravel.controller;

import com.gxtravel.entity.*;
import com.gxtravel.service.OrderService;
import com.gxtravel.service.RecommendService;
import com.gxtravel.service.ScenicService;
import com.gxtravel.service.TicketService;
import com.gxtravel.utils.Page;
import com.gxtravel.utils.PaymentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    TicketService ticketService;
    @Autowired
    ScenicService scenicService;
    @Autowired
    RecommendService recommendService;

    /**
     *管理员查看所有订单
     * @param model
     * @param vo
     * @return
     */
    @RequestMapping(value = "/manageOrder")
    public String getOrderPage(Model model,QueryVo vo){
        Page<Order> page = orderService.selectOrderPageByQueryVo(vo);
        model.addAttribute("page", page);
        model.addAttribute("name",vo.getName());
        return "manager/order";
    }

    /**
     * 用户点击购买后获得的订单信息
     * @return
     */
    @RequestMapping(value = "/getOrderInfo")
    public String toFillOrderPage(Integer id,Model model){
        Ticket ticket = ticketService.getTicketById(id);
        model.addAttribute("ticket",ticket);
        return "user/order";
    }

    /**
     * 用户查看自己的订单列表
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/listOrder")
    public String listOrderToUser(Model model, QueryVo vo,HttpSession session){
        User user = (User) session.getAttribute("user");
        //下面是不分页的获取该登陆用户下的所有订单
        //List<Order> listOrder =  orderService.selectOrderListByFid(user.getUserid());
        vo.setUserid(user.getUserid());
        Page<Order> page = orderService.selectOrderPageByQueryVo(vo);
        model.addAttribute("page", page);
        return "user/orderList";
    }

    //取票
    @RequestMapping(value = "/updateOrderState")
    public @ResponseBody
    String updateState(Integer id){
        orderService.updateStateById(id);
        return "OK";
    }

//    @RequestMapping(value = "/submitOrderInfo")
//    public String submitOrder(HttpServletRequest request,Order order,String name,Double price,Model model){
//       order.setPaid(price*order.getNum());
//       order.setNo(UUID.randomUUID().toString());
//       order.setCode(UUID.randomUUID().toString());
//       User user = (User)request.getSession().getAttribute("user");
//       order.setUid(user.getUserid());
//       orderService.insertOrder(order);
//       model.addAttribute("order",order);
//        model.addAttribute("mprice",price);
//        model.addAttribute("name",name);
//       return "user/orderInfo";
//    }

    @RequestMapping(value = "/submitOrderInfo")
    public String submitOrder(HttpServletRequest request,Order order,String name,Double price,Model model){
        order.setPaid(price*order.getNum());
        order.setNo(UUID.randomUUID().toString());
        order.setCode(UUID.randomUUID().toString());
        User user = (User)request.getSession().getAttribute("user");
        order.setUser(user);
        order.setUid(user.getUserid());
        System.out.println("tid是：" + order.getTid());
        Ticket ticket = ticketService.getTicketById(order.getTid());
        order.setTicket(ticket);
        System.out.println("fid是：" + order.getTicket().getFid());
        request.getSession().setAttribute("order",order );
        orderService.insertOrder(order);

        //System.out.println("id是：" + order.getId());
        model.addAttribute("order",order);
        model.addAttribute("ordertime",new Date().toLocaleString());
        return "pay/index";
    }
    @RequestMapping(value = "/updatePayState")
    public String updatePayState(HttpServletRequest request, Model model){
        Order order = (Order)request.getSession().getAttribute("order");
        request.getSession().removeAttribute("order");
        //改状态
        orderService.updateStateToPayById(order.getId());
        //改销量
        scenicService.updateScenicSales(order.getTicket().getFid());
        //改评分
        Scenic scenic = scenicService.getScenicById(order.getTicket().getFid());//先获取当前景点
        ScenicScore scenicScore = new ScenicScore(order.getUid(), scenic.getId(), 5.0, new Date());
        recommendService.changeScenicScore(scenicScore);

        model.addAttribute("order", order);
        return "user/paySuccess";
    }


    @RequestMapping(value = "/paySuccessPage")
    public String paySuccessPage(String code,String no,Model model){
        model.addAttribute("code",code);
        model.addAttribute("no",no);
        return "user/paySuccess";
    }
}