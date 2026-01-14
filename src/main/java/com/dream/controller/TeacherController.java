package com.dream.controller;

import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.PageResult;
import com.dream.pojo.Result;
import com.dream.pojo.Teacher;
import com.dream.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping()
    public Result list(@RequestBody EmpQueryParam empQueryParam) {
        log.info("查询教师列表，参数：{}", empQueryParam);
    PageResult<Teacher> result = teacherService.list(empQueryParam);
    return Result.success(result);
}


}
