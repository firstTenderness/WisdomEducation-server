package com.dream.pojo;

import lombok.Data;

@Data
public class LoginRequest {
    private String account;
    /**
     * 登录密码（明文，后端需加盐MD5加密后与数据库对比）
     */
    private String password;
}
