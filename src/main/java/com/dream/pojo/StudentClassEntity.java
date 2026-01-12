package com.dream.pojo;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 学生-班级关联实体类
 * 对应数据库表：student_class
 */
@Data
public class StudentClassEntity {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 学生ID（关联person表）
     */
    private Long studentId;

    /**
     * 班级ID（关联class表）
     */
    private Long classId;

    /**
     * 是否主班级：1-是，0-否
     */
    private Integer isMain;

    /**
     * 加入时间
     */
    private LocalDate joinTime;

    /**
     * 离开时间（如调班/毕业）
     */
    private LocalDate leaveTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}