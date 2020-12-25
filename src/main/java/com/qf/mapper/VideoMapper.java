package com.qf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.pojo.QueryVo;
import com.qf.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper extends BaseMapper<Video> {
    Video selectVideoById(String id);

    void updateVideo(Video video);

    List<Video> selectVideoByQueryVo(QueryVo queryVo);

    Integer selectCountByQueryVo(QueryVo queryVo);

    Boolean deleteById(String id);

    void insertVideo1(Video video);
}
