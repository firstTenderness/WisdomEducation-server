package com.dream.pojo;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 爱心人士实体类
 * 对应数据库表：person（role_type=3）+ donor_class
 */
@Data
public class DonorEntity {
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
     * 具体身份（如：资金资助人、物资捐赠者、志愿者）
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
     * 帮扶的班级信息
     */
    private List<DonorClassRelation> donorClassRelations;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 爱心人士-班级关联内部类
     */
    @Data
    public static class DonorClassRelation {
        /**
         * 班级ID
         */
        private Long classId;

        /**
         * 班级名称
         */
        private String className;

        /**
         * 帮扶类型（如：资金资助、物资捐赠、学业辅导）
         */
        private String helpType;

        /**
         * 帮扶金额
         */
        private BigDecimal helpAmount;

        /**
         * 金额单位（如：元）
         */
        private String amountUnit;

        /**
         * 支付状态：0-未支付，1-已支付
         */
        private Integer payStatus;
    }
}