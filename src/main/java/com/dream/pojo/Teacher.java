package com.dream.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 教师实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    // 主键id
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
    private String account;
    // 密码
    private String password;
    // 盐值
    private String salt;
    // 角色类型（2代表教师）
    private Integer role_type;
    // 岗位（如语文老师/六年级1班）
    private String position;
    // 创建时间
    private LocalDateTime createTime;
    // 更新时间
    private LocalDateTime updateTime;
}