/*
 Navicat Premium Data Transfer

 Source Server         : dream
 Source Server Type    : MySQL
 Source Server Version : 80041 (8.0.41)
 Source Host           : localhost:3306
 Source Schema         : wisdomeducation

 Target Server Type    : MySQL
 Target Server Version : 80041 (8.0.41)
 File Encoding         : 65001

 Date: 14/01/2026 17:55:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `class_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班级名称（如：一年级1班、初三2班）',
  `grade` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '年级（如：一年级、初二、高三）',
  `head_teacher_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '班主任ID（关联person表）',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_class_name`(`class_name` ASC) USING BTREE,
  INDEX `idx_head_teacher`(`head_teacher_id` ASC) USING BTREE,
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`head_teacher_id`) REFERENCES `person` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '班级信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '六年级1班', '六年级', 1, '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `class` VALUES (2, '六年级2班', '六年级', NULL, '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `class` VALUES (3, '五年级1班', '五年级', NULL, '2026-01-12 17:11:23', '2026-01-12 17:11:23');

-- ----------------------------
-- Table structure for donor_class
-- ----------------------------
DROP TABLE IF EXISTS `donor_class`;
CREATE TABLE `donor_class`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `donor_id` bigint UNSIGNED NOT NULL COMMENT '爱心人士ID（关联person表）',
  `class_id` bigint UNSIGNED NOT NULL COMMENT '班级ID（关联class表）',
  `help_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '帮扶类型（如：物资捐赠、学业辅导、资金资助）',
  `help_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '帮扶金额（元）',
  `amount_unit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '元' COMMENT '金额单位',
  `pay_status` tinyint NULL DEFAULT 0 COMMENT '支付状态：0-未支付，1-已支付',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_donor_class`(`donor_id` ASC, `class_id` ASC) USING BTREE,
  INDEX `class_id`(`class_id` ASC) USING BTREE,
  CONSTRAINT `donor_class_ibfk_1` FOREIGN KEY (`donor_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `donor_class_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '爱心人士-班级关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of donor_class
-- ----------------------------
INSERT INTO `donor_class` VALUES (1, 7, 1, '资金资助', 8000.00, '元', 1, '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `donor_class` VALUES (2, 8, 1, '物资捐赠', 2500.50, '元', 1, '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `donor_class` VALUES (3, 8, 2, '学业辅导', 0.00, '元', 0, '2026-01-12 17:11:23', '2026-01-12 17:11:23');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `gender` tinyint NULL DEFAULT NULL COMMENT '性别：1-男，2-女，0-未知',
  `age` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '登录账号（唯一）',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'MD5加密后的登录密码',
  `salt` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码盐（用于MD5加盐加密）',
  `role_type` tinyint NOT NULL COMMENT '角色类型：1-学生，2-教师，3-爱心人士',
  `position` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '具体职位/身份：如语文老师、班主任、志愿者、资助人等',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_card`(`id_card` ASC) USING BTREE,
  UNIQUE INDEX `idx_account`(`account` ASC) USING BTREE,
  INDEX `idx_role_type`(`role_type` ASC) USING BTREE,
  INDEX `idx_phone`(`phone` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '人员基础信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (1, '张三', 1, 35, '13800138000', '110101198901011234', 'zhangsan', 'bf5c105e7f1d68d42811a29c46d8c362', 'test_salt_123', 2, '语文老师/六年级1班班主任', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `person` VALUES (2, '李四', 1, 40, '13900139000', '110101198402021234', 'lisi', 'bf5c105e7f1d68d42811a29c46d8c362', 'test_salt_123', 2, '数学老师', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `person` VALUES (3, '王五', 2, 32, '13700137000', '110101199203031234', 'wangwu', 'bf5c105e7f1d68d42811a29c46d8c362', 'test_salt_123', 2, '英语老师', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `person` VALUES (4, '赵六', 1, 12, '13600136000', '110101201204041234', 'zhaoliu', '2fad59bb79a4ad776cdb0b89e80a0aa9', 'test_salt_123', 1, '班长', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `person` VALUES (5, '孙七', 2, 12, '13500135000', '110101201205051234', 'sunqi', '2fad59bb79a4ad776cdb0b89e80a0aa9', 'test_salt_123', 1, '学习委员', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `person` VALUES (6, '周八', 1, 11, '13400134000', '110101201306061234', 'zhouba', '2fad59bb79a4ad776cdb0b89e80a0aa9', 'test_salt_123', 1, '普通学生', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `person` VALUES (7, '吴九', 2, 45, '13300133000', '110101197907071234', 'wujiu', 'bf5c105e7f1d68d42811a29c46d8c362', 'test_salt_123', 3, '资金资助人', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `person` VALUES (8, '郑十', 1, 50, '13200132000', '110101197408081234', 'zhengshi', 'bf5c105e7f1d68d42811a29c46d8c362', 'test_salt_123', 3, '物资捐赠者/志愿者', '2026-01-12 17:11:23', '2026-01-12 17:11:23');

-- ----------------------------
-- Table structure for student_class
-- ----------------------------
DROP TABLE IF EXISTS `student_class`;
CREATE TABLE `student_class`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `student_id` bigint UNSIGNED NOT NULL COMMENT '学生ID（关联person表）',
  `class_id` bigint UNSIGNED NOT NULL COMMENT '班级ID（关联class表）',
  `is_main` tinyint NULL DEFAULT 1 COMMENT '是否主班级：1-是，0-否',
  `join_time` date NULL DEFAULT NULL COMMENT '加入时间',
  `leave_time` date NULL DEFAULT NULL COMMENT '离开时间',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_student_class`(`student_id` ASC, `class_id` ASC) USING BTREE,
  INDEX `class_id`(`class_id` ASC) USING BTREE,
  CONSTRAINT `student_class_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `student_class_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生-班级关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_class
-- ----------------------------
INSERT INTO `student_class` VALUES (1, 4, 1, 1, '2025-09-01', NULL, '2026-01-12 17:11:23');
INSERT INTO `student_class` VALUES (2, 5, 1, 1, '2025-09-01', NULL, '2026-01-12 17:11:23');
INSERT INTO `student_class` VALUES (3, 6, 2, 1, '2025-09-01', NULL, '2026-01-12 17:11:23');

-- ----------------------------
-- Table structure for student_study_record
-- ----------------------------
DROP TABLE IF EXISTS `student_study_record`;
CREATE TABLE `student_study_record`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `student_id` bigint UNSIGNED NOT NULL COMMENT '学生ID（关联person表）',
  `subject_id` bigint UNSIGNED NOT NULL COMMENT '科目ID（关联subject表）',
  `study_date` date NOT NULL COMMENT '学习日期',
  `study_duration` int NOT NULL COMMENT '学习时长（分钟）',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注（如：课堂学习、课后复习）',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_student_subject_date`(`student_id` ASC, `subject_id` ASC, `study_date` ASC) USING BTREE,
  INDEX `idx_student_id`(`student_id` ASC) USING BTREE,
  INDEX `idx_subject_id`(`subject_id` ASC) USING BTREE,
  CONSTRAINT `student_study_record_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `student_study_record_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生学习时长记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_study_record
-- ----------------------------
INSERT INTO `student_study_record` VALUES (1, 4, 1, '2025-10-10', 90, '语文课堂学习+作文练习', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `student_study_record` VALUES (2, 4, 2, '2025-10-10', 80, '数学错题整理', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `student_study_record` VALUES (3, 4, 3, '2025-10-11', 60, '英语单词背诵', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `student_study_record` VALUES (4, 5, 1, '2025-10-10', 75, '语文阅读理解', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `student_study_record` VALUES (5, 5, 3, '2025-10-10', 90, '英语听力练习', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `student_study_record` VALUES (6, 5, 4, '2025-10-11', 45, '科学实验预习', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `student_study_record` VALUES (7, 6, 2, '2025-10-10', 60, '数学课后作业', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `student_study_record` VALUES (8, 6, 5, '2025-10-11', 120, '体育训练', '2026-01-12 17:11:23', '2026-01-12 17:11:23');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `subject_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '科目名称（如：语文、数学、英语）',
  `subject_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '科目编码（如：YW、SX、YY）',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_subject_name`(`subject_name` ASC) USING BTREE,
  UNIQUE INDEX `subject_code`(`subject_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '科目信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES (1, '语文', 'YW', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `subject` VALUES (2, '数学', 'SX', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `subject` VALUES (3, '英语', 'YY', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `subject` VALUES (4, '科学', 'KX', '2026-01-12 17:11:23', '2026-01-12 17:11:23');
INSERT INTO `subject` VALUES (5, '体育', 'TY', '2026-01-12 17:11:23', '2026-01-12 17:11:23');

-- ----------------------------
-- Table structure for teacher_subject
-- ----------------------------
DROP TABLE IF EXISTS `teacher_subject`;
CREATE TABLE `teacher_subject`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `teacher_id` bigint UNSIGNED NOT NULL COMMENT '教师ID（关联person表）',
  `subject_id` bigint UNSIGNED NOT NULL COMMENT '科目ID（关联subject表）',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_teacher_subject`(`teacher_id` ASC, `subject_id` ASC) USING BTREE,
  INDEX `subject_id`(`subject_id` ASC) USING BTREE,
  CONSTRAINT `teacher_subject_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `teacher_subject_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '教师-科目关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_subject
-- ----------------------------
INSERT INTO `teacher_subject` VALUES (1, 1, 1, '2026-01-12 17:11:23');
INSERT INTO `teacher_subject` VALUES (2, 2, 2, '2026-01-12 17:11:23');
INSERT INTO `teacher_subject` VALUES (3, 3, 3, '2026-01-12 17:11:23');
INSERT INTO `teacher_subject` VALUES (4, 1, 4, '2026-01-12 17:11:23');

SET FOREIGN_KEY_CHECKS = 1;
