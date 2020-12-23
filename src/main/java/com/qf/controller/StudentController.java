package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("student")
public class StudentController {

    @RequestMapping("index")
    public String index(){
        return "behind/login";
    }
}
