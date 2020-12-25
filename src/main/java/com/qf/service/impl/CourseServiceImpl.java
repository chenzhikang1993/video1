package com.qf.service.impl;

import com.qf.mapper.CourseMapper;
import com.qf.pojo.Course;
import com.qf.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public Course selectCourseById(String id) {
        return courseMapper.selectCourseById(id);
    }

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public Course findByvideoId(String id) {
        return courseMapper.findByvideoId(id);
    }
}
