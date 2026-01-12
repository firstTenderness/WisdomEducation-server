package com.dream.pojo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 通用人员实体类（统一存储学生/教师/爱心人士基础信息）
 * 对应数据库表：person
 */
@Data
public class PersonEntity {
    /**
     * 主键ID
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
     * 角色类型：1-学生，2-教师，3-爱心人士
     */
    private Integer roleType;

    /**
     * 具体职位/身份（如：语文老师、班长、资助人）
     */
    private String position;

    /**
     * 登录账号
     */
    private String account;

    /**
     * MD5加密后的密码
     */
    private String password;

    /**
     * 密码盐
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
}
