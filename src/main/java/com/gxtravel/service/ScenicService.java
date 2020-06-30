package com.gxtravel.service;

import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.Scenic;
import com.gxtravel.utils.Page;

import java.util.List;

public interface ScenicService {
    //按销量排序
    List<Scenic> selectScenicList();

    List<Scenic> selectScenicList2();
    Page<Scenic> selectPageByQueryVo(QueryVo vo);
    //新增
    void addScenic(Scenic scenic);
    public void deleteById(Integer id);
    int updateScenic(Scenic scenic);
    Scenic getScenicById(Integer id);
    int updateScenicSales(Integer id);

    void batchScenic(List<Scenic> list);

    List<Scenic> selectScenicByUser(Integer userid);
}
