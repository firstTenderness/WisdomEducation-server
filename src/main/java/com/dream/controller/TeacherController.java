package com.dream.controller;

import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.PageResult;
import com.dream.pojo.Result;
import com.dream.pojo.Teacher;
import com.dream.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping()
    public Result delete(@RequestParam Integer[] ids) {
        log.info("批量删除教师，id：{}", ids);
        teacherService.delete(ids);
        return Result.success();
    }

    @PutMapping()
    public Result update(@RequestBody Teacher teacher) {
        log.info("更新教师信息，参数：{}", teacher);
        teacherService.update(teacher);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("查询教师信息，id：{}", id);
        Teacher teacher = teacherService.get(id);
        return Result.success(teacher);
    }
    @PostMapping
    public Result add(@RequestBody Teacher teacher) {
        log.info("添加教师信息，参数：{}", teacher);
        teacherService.add(teacher);
        return Result.success();
    }
}
