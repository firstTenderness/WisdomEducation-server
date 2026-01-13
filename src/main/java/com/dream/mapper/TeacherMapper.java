package com.dream.mapper;
import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    List<TeacherEntity> list(EmpQueryParam empQueryParam);
}
