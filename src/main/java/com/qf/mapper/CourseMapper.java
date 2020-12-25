package com.qf.mapper;

import com.qf.pojo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    Course selectCourseById(String id);

    List<Course> selectAll();
    public void ss();

    Course findByvideoId(String id);
}
