package com.dream.mapper;

import com.dream.pojo.Course;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    // 分页查询课程（简单版，page为页码，每页10条）
    @Select("select * from course limit #{page}, 10")
    List<Course> getCourseList(Integer page);
}