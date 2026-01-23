package com.dream.pojo;

import lombok.Data;

// 课程实体类（和数据库course表对应）
@Data // 简化get/set，需引入lombok依赖
public class Course {
    private Long id;         // 课程ID
    private String name;     // 课程名称
    private String teacher;  // 授课老师
    private Integer progress;// 学习进度（可选）
    private String desc;     // 课程描述（可选）
}