package com.dream.pojo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 班级实体类
 * 对应数据库表：class
 */
@Data
public class ClassEntity {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 班级名称（如：六年级1班）
     */
    private String className;

    /**
     * 年级（如：六年级、初三）
     */
    private String grade;

    /**
     * 班主任ID（关联person表）
     */
    private Long headTeacherId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}