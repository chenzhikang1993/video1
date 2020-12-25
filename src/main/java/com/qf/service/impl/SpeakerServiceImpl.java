package com.qf.service.impl;

import com.qf.mapper.SpeakerMapper;
import com.qf.pojo.QueryVo;
import com.qf.pojo.Speaker;
import com.qf.service.SpeakerService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//茹东杰

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerMapper speakerMapper;

//    @Override
//    public List<Speaker> findAll() {
//        return speakerMapper.findAll();
//    }

    @Override
    public Boolean UpdateSpeaker(Speaker speaker) {

        return speakerMapper.updateSpeaker(speaker);


    }


    @Override
    public Speaker selectById(String id) {
        return speakerMapper.selectSpeakerById(id);
    }

    @Override
    public boolean delById(String id) {
        if (speakerMapper.deleteById(id) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addSeaker(Speaker speaker) {
        speakerMapper.insertSpeaker(speaker);

    }

    @Override
    public Page<Speaker> selectSpeakerByQueryVo(QueryVo queryVo) {
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getSize());

        List<Speaker> speakerList = speakerMapper.selectSpeakerByQueryVo(queryVo);
        Integer total = speakerMapper.selectCountByQueryVo(queryVo);

        Page<Speaker> speakerPage = new Page<>();
        speakerPage.setRows(speakerList);//行
        speakerPage.setTotal(total);//7
        speakerPage.setPage(queryVo.getPage());
        speakerPage.setSize(queryVo.getSize());

        return speakerPage;


    }

    public List<Speaker> selectAll() {
        return speakerMapper.selectAll();
    }
}
