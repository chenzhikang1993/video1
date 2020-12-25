package com.qf.controller;

import com.qf.pojo.Subject;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 陈志康
 */

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 课程列表下拉框
     * 视频列表展示
     * 陈志康
     * @param subjectId
     * @param request
     * @return
     */
    @RequestMapping("/course/{subjectId}")
    public String find(@PathVariable String subjectId, HttpServletRequest request){

        List<Subject> subjectList = subjectService.findAllSubject();
        request.setAttribute("subjectList",subjectList);

        Subject subject = subjectService.findSubjectById(subjectId);
        request.setAttribute("subject",subject);
        return "before/course";
    }

}
