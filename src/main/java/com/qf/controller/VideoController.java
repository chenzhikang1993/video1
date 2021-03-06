package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.*;
import com.qf.service.CourseService;
import com.qf.service.SpeakerService;
import com.qf.service.SubjectService;
import com.qf.service.VideoService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/*
    张乐乐
*/
@Controller
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SpeakerService speakerService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/showVideo")
    public String showVideo(HttpServletRequest request,String videoId, String subjectName, Model model) {
        List<Subject> subjectList = subjectService.findAllSubject();
        request.setAttribute("subjectList",subjectList);

        model.addAttribute("subjectName", subjectName);
        Video video = videoService.selectVideoById(videoId);
        model.addAttribute("video", video);
        Course course = courseService.selectCourseById(video.getCourseId().toString());
        model.addAttribute(course);
        return "/before/section";
    }

    @RequestMapping("/updatePlayNum")
    @ResponseBody
    public String updatePlayNum(Video video) {
        video.setPlayNum(video.getPlayNum() + 1);
        videoService.updateVideo(video);
        return "success";
    }

    @RequestMapping("/list")
    public String list(QueryVo queryVo, Model model) {
        model.addAttribute("queryVo", queryVo);
        Page<Video> page = videoService.selectVideoByQueryVo(queryVo);
        model.addAttribute("page", page);
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);
        return "/behind/videoList";
    }

    @RequestMapping("/delBatchVideos")
    public String delBatchVideos(String[] ids) {
        videoService.deleteById(ids);
        return "redirect:list";
    }

    @RequestMapping("/videoDel")
    @ResponseBody
    public String videoDel(String id) {
        String[] ids = new String[1];
        ids[0] = id;
        if (videoService.deleteById(ids)) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping("/edit")
    public String edit(String id, Model model) {
        Video video = videoService.selectVideoById(id);
        model.addAttribute("video", video);
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);
        return "/behind/addVideo";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Video video) {
        videoService.updateVideo(video);
        return "redirect:list";
    }

      @RequestMapping("/addVideo")
    public String addVideo(Model model) {
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);
        return "behind/addVideo";
    }

    @RequestMapping("showVideo1")
    public String showVideo1(HttpServletRequest request,String videoId, String subjectName, Model model) {

        List<Subject> subjectList = subjectService.findAllSubject();
        request.setAttribute("subjectList",subjectList);
        model.addAttribute("subjectName",subjectName);
        //查询视频
        Video video = videoService.findById(videoId);
        //课程
        Course course = courseService.findByvideoId(video.getCourseId() +"");


        model.addAttribute("video",video);
        model.addAttribute("course", course);
        return "before/section";
    }


}
