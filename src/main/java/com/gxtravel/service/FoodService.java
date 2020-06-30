package com.gxtravel.service;

import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.TastyFood;
import com.gxtravel.utils.Page;

import java.util.List;

public interface FoodService {
    List<TastyFood> selectFoodList();
    Page<TastyFood> selectFoodPageByQueryVo(QueryVo vo);
    //新增
    void addFood(TastyFood tastyFood);
    void deleteById(Integer id);
    int updateFood(TastyFood tastyFood);
    TastyFood getFoodById(Integer id);
}
