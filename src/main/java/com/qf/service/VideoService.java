package com.qf.service;


import com.qf.pojo.QueryVo;
import com.qf.pojo.Video;
import com.qf.utils.Page;

import java.util.List;

public interface VideoService {
    Video selectVideoById(String id);

    void updateVideo(Video video);

    Page<Video> selectVideoByQueryVo(QueryVo queryVo);

    Boolean deleteById(String[] ids);
}
