package com.dream.service.impl;

import com.dream.mapper.StudentsMapper;
import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.PageResult;
import com.dream.pojo.Students;
import com.dream.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public PageResult<Students> list(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Students> list = studentsMapper.list(empQueryParam);
        Page<Students> p = (Page<Students>) list;
        return new PageResult<>(p.getTotal(), p.getResult(), empQueryParam.getPage(), empQueryParam.getPageSize());
    }

    @Override
    public void delete(Integer[] ids) {
        studentsMapper.delete(ids);
    }

    @Override
    public void add(Students students) {
        if (students.getAccount() != null) {
            Students existingStudents = studentsMapper.getByAccount(students.getAccount());
            if (existingStudents != null) {
                throw new RuntimeException("账号已存在");
            }
            if (students.getRole_type() == null) {
                students.setRole_type(1);
            }
            students.setUpdateTime(LocalDateTime.now());
            students.setCreateTime(LocalDateTime.now());
            studentsMapper.add(students);
        }

    }

    @Override
    public Students get(Integer id) {
        return studentsMapper.get(id);
    }

    @Override
    public void update(Students students) {
        students.setUpdateTime(LocalDateTime.now());
        studentsMapper.update(students);
    }
}
