package com.qf.service;

import com.qf.pojo.QueryVo;
import com.qf.pojo.Speaker;
import com.qf.utils.Page;

import java.util.List;
//茹东杰
public interface SpeakerService {

    Page<Speaker> selectSpeakerByQueryVo(QueryVo queryVo);

    List <Speaker> findAll();

    Boolean UpdateSpeaker(Speaker speaker);

    Speaker selectById(String id);

    boolean delById(String id);

    void addSeaker(Speaker speaker);
}
