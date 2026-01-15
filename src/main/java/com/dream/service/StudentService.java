package com.dream.service;

import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.PageResult;
import com.dream.pojo.Students;

public interface StudentService {
    PageResult<Students> list(EmpQueryParam empQueryParam);
}
