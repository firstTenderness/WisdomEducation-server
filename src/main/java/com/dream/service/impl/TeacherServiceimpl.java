package com.dream.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dream.mapper.TeacherMapper;
import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.PageResult;
import com.dream.pojo.TeacherEntity;
import com.dream.service.TeacherService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceimpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public PageResult<TeacherEntity> list(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<TeacherEntity> list = teacherMapper.list(empQueryParam);
        Page<TeacherEntity> page = new Page<>(empQueryParam.getPage(), empQueryParam.getPageSize());
        return new PageResult<>(page.getTotal(), list);
    }
}
