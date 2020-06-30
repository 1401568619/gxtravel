package com.gxtravel.dao;

import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.Scenic;

import java.util.List;

public interface ScenicMapper {
    //按照销量排序
    List<Scenic> selectScenicList();
    //直接查
    List<Scenic> selectScenicList2();
    //总条数
    Integer postCountByQueryVo(QueryVo vo);
    //结果集
    List<Scenic> selectPostListByQueryVo(QueryVo vo);
    //新增
    void addScenic(Scenic scenic);

    public void deleteById(Integer id);

    int updateScenic(Scenic scenic);

    Scenic getScenicById(Integer id);

    int updateScenicSales(Integer id);

    void batchScenic(List<Scenic> list);

    List<Scenic> selectScenicByUser(Integer userid);
}
