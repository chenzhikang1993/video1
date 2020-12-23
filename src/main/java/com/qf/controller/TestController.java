package com.qf.controller;

import com.qf.pojo.Test;
import com.qf.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("findAll")
    public List<Test> findAll(){
        return testService.findAll();
    }

}
