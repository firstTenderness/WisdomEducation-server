package com.dream.service;

import com.dream.pojo.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourseList(Integer page);
}
