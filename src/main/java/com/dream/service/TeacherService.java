package com.dream.service;


import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.PageResult;
import com.dream.pojo.Teacher;

public interface TeacherService {


    PageResult<Teacher> list(EmpQueryParam empQueryParam);
}
