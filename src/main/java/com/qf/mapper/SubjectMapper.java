package com.qf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.pojo.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectMapper extends BaseMapper<Subject> {

    List<Subject> findAll();

    Subject selectSubjectById(String id);

}
