package com.dream.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students {
    /**
     * 学生ID（核心标识）
     */
    private String studentId;

    /**
     * 姓名（核心身份）
     */
    private String studentName;

    /**
     * 身份证号（核心身份）
     */
    private String idCard;

    /**
     * 性别：1-男，2-女，0-未知
     */
    private Long gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 年级（如：一年级、初二、高三）
     */
    private String grade;

    /**
     * 班级名称（如：一年级1班、初三2班）
     */
    private String className;

    /**
     * 角色类型：1-学生，2-教师，3-爱心人士
     */
    private Integer role_type;  // 修正：驼峰命名（原role_type）

    /**
     * 具体职位/身份：如语文老师、班主任、志愿者、资助人等
     */
    private String position;

    /**
     * 班主任ID（关联person表）
     */
    private Long headTeacherId;

    /**
     * 账户名（登录用）
     */
    private String account;

    /**
     * 密码（登录用）
     */
    private String password;

    /**
     * 加密盐值（安全用）
     */
    private String salt;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

 /*   // 主键id
    private Integer id;
    // 姓名
    private String name;
    // 性别（1-男；2-女）
    private Integer gender;
    // 年龄
    private Integer age;
    // 手机号
    private String phone;
    // 身份证号
    private String idCard;
    // 账号
    // 密码
    // 盐值
    // 角色类型（1代表学生）
    private Integer role_type;
    // 岗位 学习委员
    private String position;
    */
}
