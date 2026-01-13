package com.dream.service.impl;


import com.dream.mapper.TeacherMapper;
import com.dream.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceimpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


}
