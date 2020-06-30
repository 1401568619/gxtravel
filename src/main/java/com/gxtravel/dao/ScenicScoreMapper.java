package com.gxtravel.dao;

import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.ScenicScore;
import com.gxtravel.entity.Statistic;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ScenicScoreMapper {


    void batchInsert(List<ScenicScore> list);

    List<ScenicScore> selectScenicScoreList(String time);

    int getScoreCount();

    List<ScenicScore> selectScorerListByQueryVo(QueryVo vo);

    ScenicScore findScenicScore(@Param("userid")Integer userid, @Param("scenicid")Integer scenicid);

    int addScenicScore(ScenicScore scenicScore);

    int updateScenicScore(ScenicScore scenicScore);

    int deleteOld(String time);

    List<Integer> selectPopScenicid();

    List<Statistic> selectCountByTheme(@Param("atime")String atime, @Param("btime") String btime);

    List<ScenicScore> selectScenicScoreByUser(Integer userid);
}
