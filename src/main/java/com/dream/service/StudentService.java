package com.dream.service;

import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.PageResult;
import com.dream.pojo.Students;

public interface StudentService {
    PageResult<Students> list(EmpQueryParam empQueryParam);

    void delete(Integer[] ids);

    void add(Students students);

    Students get(Integer id);

    void update(Students students);
}
