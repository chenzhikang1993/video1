package com.qf.service.impl;

import com.qf.mapper.VideoMapper;
import com.qf.pojo.QueryVo;
import com.qf.pojo.Video;
import com.qf.service.VideoService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Video selectVideoById(String id) {
        return videoMapper.selectVideoById(id);
    }

    @Override
    public void updateVideo(Video video) {
        if (null != video.getId() && !video.getId().equals("")) {
            videoMapper.updateVideo(video);
        } else {
            videoMapper.insertVideo1(video);
        }
    }

    @Override
    public Page<Video> selectVideoByQueryVo(QueryVo queryVo) {
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getSize());

        List<Video> videoList = videoMapper.selectVideoByQueryVo(queryVo);
        Integer total = videoMapper.selectCountByQueryVo(queryVo);

        Page<Video> videoPage = new Page<>();
        videoPage.setRows(videoList);
        videoPage.setTotal(total);
        videoPage.setPage(queryVo.getPage());
        videoPage.setSize(queryVo.getSize());

        return videoPage;
    }

    @Override
    public Boolean deleteById(String[] ids) {
        Boolean flag = true;
        for (String id : ids) {
            if (!videoMapper.deleteById(id)) {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public Video findById(String id) {
        return videoMapper.findById(id);
    }
}
