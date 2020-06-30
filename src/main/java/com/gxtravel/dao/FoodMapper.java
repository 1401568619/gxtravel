package com.gxtravel.dao;

import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.TastyFood;

import java.util.List;

public interface FoodMapper {
    List<TastyFood> selectFoodList();
    //总条数
    Integer postCountByQueryVo(QueryVo vo);
    //结果集
    List<TastyFood> selectPostListByQueryVo(QueryVo vo);
    //新增
    void addFood(TastyFood tastyFood);
    void deleteById(Integer id);
    int updateFood(TastyFood tastyFood);

    TastyFood getFoodById(Integer id);
}
