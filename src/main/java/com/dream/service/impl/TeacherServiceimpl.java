package com.dream.service.impl;


import com.dream.mapper.TeacherMapper;
import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.PageResult;
import com.dream.pojo.Teacher;
import com.dream.service.TeacherService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TeacherServiceimpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public PageResult<Teacher> list(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
       List<Teacher>  list = teacherMapper.list(empQueryParam);
        Page<Teacher> p= (Page<Teacher>) list;
        return new PageResult<>(p.getTotal(), p.getResult(), empQueryParam.getPage(), empQueryParam.getPageSize());
    }

    @Override
    public void delete(Integer[] ids) {
        teacherMapper.delete(ids);
    }
    @Override
    public void update(Teacher teacher) {
        teacher.setUpdateTime(LocalDateTime.now());
        teacherMapper.update(teacher);
    }

    @Override
    public Teacher get(Integer id) {
        return teacherMapper.get(id);
    }
    @Override
    public void add(Teacher teacher) {
        teacher.setUpdateTime(LocalDateTime.now());
        teacher.setCreateTime(LocalDateTime.now());
        teacherMapper.add(teacher);
    }

}
