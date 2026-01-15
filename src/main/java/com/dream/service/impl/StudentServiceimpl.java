package com.dream.service.impl;

import com.dream.mapper.StudentsMapper;
import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.PageResult;
import com.dream.pojo.Students;
import com.dream.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
   @Autowired
   private StudentsMapper studentsMapper;

    @Override
    public PageResult<Students> list(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Students> list = studentsMapper.list(empQueryParam);
        Page<Students> p= (Page<Students>) list;
        return new PageResult<>(p.getTotal(), p.getResult(), empQueryParam.getPage(), empQueryParam.getPageSize());
    }
}
