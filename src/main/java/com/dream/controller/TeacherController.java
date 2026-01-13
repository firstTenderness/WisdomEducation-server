package com.dream.controller;

import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.PageResult;
import com.dream.pojo.Result;
import com.dream.pojo.TeacherEntity;
import com.dream.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @RequestMapping()
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询，参数：{}", empQueryParam);
PageResult<TeacherEntity> pageResult =teacherService.list(empQueryParam);
        return Result.success(pageResult);
}
}
