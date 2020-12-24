package com.qf.controller;


import com.qf.pojo.Subject;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/selectAll")
    public String selectAll(HttpServletRequest request) {
        System.out.println("selectAll");

        List<Subject> subjectList = subjectService.findAllSubject();
        request.setAttribute("subjectList",subjectList);

        return "before/index";
    }
}
