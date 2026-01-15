package com.dream.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students {
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
    // 角色类型（1代表学生）
    private Integer roleType;
    // 岗位 学习委员
    private String position;
    // 创建时间
    private LocalDateTime createTime;
    // 更新时间
    private LocalDateTime updateTime;

}
