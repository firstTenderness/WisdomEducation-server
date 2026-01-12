package com.dream.pojo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 教师-科目关联实体类
 * 对应数据库表：teacher_subject
 */
@Data
public class TeacherSubjectEntity {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 教师ID（关联person表）
     */
    private Long teacherId;

    /**
     * 科目ID（关联subject表）
     */
    private Long subjectId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
