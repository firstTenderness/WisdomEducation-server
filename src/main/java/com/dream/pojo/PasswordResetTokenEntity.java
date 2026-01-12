package com.dream.pojo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 密码重置令牌实体类
 */
@Data
public class PasswordResetTokenEntity {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 人员ID（关联person表）
     */
    private Long personId;

    /**
     * 重置令牌（随机生成的唯一字符串）
     */
    private String resetToken;

    /**
     * 令牌过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
