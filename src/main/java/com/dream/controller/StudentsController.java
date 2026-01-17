package com.dream.controller;

import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.PageResult;
import com.dream.pojo.Result;
import com.dream.pojo.Students;
import com.dream.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public Result page(@RequestBody EmpQueryParam empQueryParam) {
        log.info("查询学生列表，参数：{}", empQueryParam);
        PageResult<Students> result = studentService.list(empQueryParam);
        return Result.success(result);
    }
   @DeleteMapping()
    public Result delete(@RequestParam("ids") Integer[] ids) {
        log.info("批量删除学生，id：{}", ids);
        studentService.delete(ids);
        return Result.success();
    }
}
