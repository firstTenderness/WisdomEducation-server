package com.dream.pojo;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 学生实体类
 * 对应数据库表：person（role_type=1）+ student_class + student_study_record
 */
@Data
public class StudentEntity {
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
     * 具体职位（如：班长、学习委员、普通学生）
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
     * 所属班级ID（主班级）
     */
    private Long classId;

    /**
     * 班级名称（冗余字段，方便前端展示）
     */
    private String className;

    /**
     * 加入班级时间
     */
    private LocalDate joinTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}