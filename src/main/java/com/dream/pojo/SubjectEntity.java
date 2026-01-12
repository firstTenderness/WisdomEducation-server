package com.dream.pojo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 科目实体类
 * 对应数据库表：subject
 */
@Data
public class SubjectEntity {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 科目名称（如：语文、数学、英语）
     */
    private String subjectName;

    /**
     * 科目编码（如：YW、SX、YY）
     */
    private String subjectCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
