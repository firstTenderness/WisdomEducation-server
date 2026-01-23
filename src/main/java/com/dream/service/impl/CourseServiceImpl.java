package com.dream.service.impl;

import com.dream.pojo.Course;
import com.dream.mapper.CourseMapper;
import com.dream.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getCourseList(Integer page) {
        // 分页计算：page=1 → 0, page=2 → 10（适配前端分页）
        Integer start = (page - 1) * 10;
        return courseMapper.getCourseList(start);
    }


}