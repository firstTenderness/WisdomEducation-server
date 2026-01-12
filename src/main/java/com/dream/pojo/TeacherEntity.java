package com.dream.pojo;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 教师实体类
 * 对应数据库表：person（role_type=2）+ teacher_subject
 */
@Data
public class TeacherEntity {
    /**
     * 人员主键ID（关联person表）
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别：1-男，2-女，0-未知
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 具体职位（如：语文老师、班主任、教导主任）
     */
    private String position;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 加密后的密码（MD5）
     */
    private String password;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 教授的科目ID列表（关联subject表）
     */
    private List<Long> subjectIds;

    /**
     * 教授的科目名称列表（冗余字段，方便前端展示）
     */
    private List<String> subjectNames;

    /**
     * 所带班级ID（班主任）
     */
    private Long classId;

    /**
     * 所带班级名称
     */
    private String className;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}