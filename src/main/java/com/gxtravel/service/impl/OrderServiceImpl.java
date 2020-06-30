package com.gxtravel.service.impl;

import com.gxtravel.entity.Order;
import com.gxtravel.dao.OrderMapper;
import com.gxtravel.entity.QueryVo;
import com.gxtravel.service.OrderService;
import com.gxtravel.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    public List<Order> selectOrderListByFid(String tid) {
        return orderMapper.selectOrderList(tid);
    }

    /**
     *后台获得分页数据
     *
     * @param vo
     * @return
     */
    public Page<Order> selectOrderPageByQueryVo(QueryVo vo) {
        Page<Order> page = new Page<Order>();
        //每页数
        page.setSize(5);
        vo.setSize(5);
        if (null != vo) {
            // 判断当前页
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() - 1) * vo.getSize());
            }
            if(null != vo.getName() && !"".equals(vo.getName().trim())){
                vo.setName(vo.getName().trim());
            }
            if(null !=vo.getUserid()/*&&!"".equals(vo.getUserid().trim())*/){
                vo.setUserid(vo.getUserid());
            }
            //总条数
            page.setTotal(orderMapper.postCountByQueryVo(vo));
            page.setRows(orderMapper.selectPostListByQueryVo(vo));
        }
        return page;
    }

    public void updateStateById(Integer id){
        orderMapper.updateStateById(id);
    }

    public void updateStateToPayById(Integer id){
        orderMapper.updateStateToPayById(id);
    }

    public void insertOrder(Order order){
        orderMapper.insertOrder(order);
    }

    public Order getOrderByNo(String no){
        return orderMapper.getOrderByNo(no);
    }
}