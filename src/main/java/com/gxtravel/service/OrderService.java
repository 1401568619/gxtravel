package com.gxtravel.service;

import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.Order;
import com.gxtravel.utils.Page;

import java.util.List;

public interface OrderService {
    Page<Order> selectOrderPageByQueryVo(QueryVo vo);
    List<Order> selectOrderListByFid(String fid);
    void updateStateById(Integer id);
    void updateStateToPayById(Integer id);
    void insertOrder(Order order);
    Order getOrderByNo(String no);
}
