package com.gxtravel.service.impl;

import com.gxtravel.dao.ScenicMapper;
import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.Scenic;
import com.gxtravel.service.ScenicService;
import com.gxtravel.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenicServiceImpl implements ScenicService {
    @Autowired
    ScenicMapper scenicMapper;

    /**
     *按销量查询所有景点
     *
     * @return
     */
    @Override
    public List<Scenic> selectScenicList() {
        return scenicMapper.selectScenicList();
    }

    @Override
    public List<Scenic> selectScenicList2() {
        return scenicMapper.selectScenicList2();
    }

    /**
     *后台获得分页数据
     *
     * @param vo
     * @return
     */
    public Page<Scenic> selectPageByQueryVo(QueryVo vo) {
        Page<Scenic> page = new Page<Scenic>();
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
            if(null != vo.getTheme() && !"".equals(vo.getTheme().trim())){
                vo.setTheme(vo.getTheme().trim());
            }
            if(null != vo.getAddr() && !"".equals(vo.getAddr().trim())){
                vo.setAddr(vo.getAddr().trim());
            }
            //总条数
            page.setTotal(scenicMapper.postCountByQueryVo(vo));
            page.setRows(scenicMapper.selectPostListByQueryVo(vo));
        }
        return page;
    }

    public void addScenic(Scenic scenic){
        scenicMapper.addScenic(scenic);
    }

    public void deleteById(Integer id){
        scenicMapper.deleteById(id);
    }

    public int updateScenic(Scenic scenic){
        return scenicMapper.updateScenic(scenic);
    }
    public Scenic getScenicById(Integer id){
        return scenicMapper.getScenicById(id);
    }

    public int updateScenicSales(Integer id){
        return scenicMapper.updateScenicSales(id);
    }

    @Override
    public void batchScenic(List<Scenic> list) {
        scenicMapper.batchScenic(list);
    }

    @Override
    public List<Scenic> selectScenicByUser(Integer userid) {
        return scenicMapper.selectScenicByUser(userid);
    }
}