package com.dream.service;

import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.PageResult;
import com.dream.pojo.TeacherEntity;

public interface TeacherService {
    PageResult<TeacherEntity> list(EmpQueryParam empQueryParam);
}
