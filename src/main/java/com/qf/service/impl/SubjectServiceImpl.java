package com.qf.service.impl;

import com.qf.mapper.SubjectMapper;
import com.qf.pojo.Subject;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> findAllSubject() {
        return subjectMapper.findAll();
    }

    @Override
    public Subject findSubjectById(String id) {
        return subjectMapper.selectSubjectById(id);
    }
}
