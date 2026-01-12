package com.dream.pojo;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 学生学习时长记录实体类
 * 对应数据库表：student_study_record
 */
@Data
public class StudentStudyRecordEntity {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 学生ID
     */
    private Long studentId;

    /**
     * 学生姓名（冗余字段）
     */
    private String studentName;

    /**
     * 科目ID
     */
    private Long subjectId;

    /**
     * 科目名称（冗余字段）
     */
    private String subjectName;

    /**
     * 学习日期
     */
    private LocalDate studyDate;

    /**
     * 学习时长（分钟）
     */
    private Integer studyDuration;

    /**
     * 备注（如：课堂学习、课后复习）
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
