package com.dream.pojo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 登录日志实体类
 */
@Data
public class LoginLogEntity {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 人员ID（关联person表）
     */
    private Long personId;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 登录IP地址
     */
    private String loginIp;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 登录状态：1-成功，0-失败
     */
    private Integer loginStatus;

    /**
     * 失败原因（如：密码错误、账号不存在）
     */
    private String failReason;
}
