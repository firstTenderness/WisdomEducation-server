package com.dream.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    private Integer id; //员工ID
    private String  account;; //账号
    private String name; //姓名
    private Integer role_type; //角色类型
    private String token; //令牌
}