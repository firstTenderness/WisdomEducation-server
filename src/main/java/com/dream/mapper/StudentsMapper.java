package com.dream.mapper;

import com.dream.pojo.EmpQueryParam;
import com.dream.pojo.Students;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface StudentsMapper {

    List<Students> list(EmpQueryParam empQueryParam);
}
