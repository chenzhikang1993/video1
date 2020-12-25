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



    Boolean updateSpeaker(Speaker speake);

    void insertSpeaker(Speaker speaker);

    Speaker selectSpeakerById(String id);

    int deleteById(String id);

    List<Speaker> selectAll();


//=======
//@Repository
//public interface SpeakerMapper {
//
//
//    List<Speaker> selectSpeakerByQueryVo(QueryVo queryVo);
//
//    Integer selectCountByQueryVo(QueryVo queryVo);
//
//    Boolean deleteById(String id);
//
//    Speaker selectSpeakerById(String id);
//
//    Boolean insertSpeaker(Speaker speaker);
//
//    Boolean updateSpeaker(Speaker speaker);
//>>>>>>> 16cde2030cf2931dca83518c1ec9084902a3020d
}
