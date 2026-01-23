package com.dream.controller;

import com.dream.pojo.Course;
import com.dream.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    // 前端请求地址：http://localhost:8080/courses?page=1
    @GetMapping("/courses")
    public Map<String, Object> getCourseList(@RequestParam(defaultValue = "1") Integer page) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Course> courseList = courseService.getCourseList(page);
            result.put("code", 200);
            result.put("msg", "success");
            result.put("data", courseList); // 返回课程列表
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "获取课程失败：" + e.getMessage());
        }
        return result;
    }
}