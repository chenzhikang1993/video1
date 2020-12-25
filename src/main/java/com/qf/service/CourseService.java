package com.qf.service;

import com.qf.pojo.Course;

import java.util.List;

public interface CourseService {
    Course selectCourseById(String id);

    List<Course> selectAll();
    Course findByvideoId(String id);

}
