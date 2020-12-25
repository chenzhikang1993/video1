package com.qf.mapper;

import com.qf.pojo.QueryVo;
import com.qf.pojo.Speaker;
import org.springframework.stereotype.Repository;

import java.util.List;
//茹东杰
@Repository
public interface SpeakerMapper {
    Integer selectCountByQueryVo(QueryVo queryVo);

    List<Speaker> selectSpeakerByQueryVo(QueryVo queryVo);
    List <Speaker> findAll();

    Boolean updateSpeaker(Speaker speake);

    void insertSpeaker(Speaker speaker);

    Speaker selectById(String id);

    int delById(String id);


}
