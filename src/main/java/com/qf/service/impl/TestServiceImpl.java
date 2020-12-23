package com.qf.service.impl;

import com.qf.mapper.TestMapper;
import com.qf.pojo.Test;
import com.qf.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAll() {
        return testMapper.selectList(null);
    }
}
