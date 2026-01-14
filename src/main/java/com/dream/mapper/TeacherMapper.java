package com.dream.mapper;

import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface TeacherMapper {


    List<Teacher> list(EmpQueryParam empQueryParam);

}
