package com.qf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {


    @RequestMapping("/selectAll")
    public String selectAll(HttpServletRequest request) {
        System.out.println("selectAll");
        return "before/index";
    }
}
