package com.gxtravel.dao;

import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> selectOrderList(String id);
    //总条数
    Integer postCountByQueryVo(QueryVo vo);
    //结果集
    List<Order> selectPostListByQueryVo(QueryVo vo);

    int updateStateById(Integer id);

    void updateStateToPayById(Integer id);

    void insertOrder(Order order);

    Order getOrderByNo(String no);
}
