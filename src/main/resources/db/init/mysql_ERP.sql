-- ----------------------------
-- ERP System Database Initialization Script
-- ----------------------------

-- ----------------------------
-- Table structure for base_customer
-- ----------------------------
DROP TABLE IF EXISTS `base_customer`;
CREATE TABLE `base_customer` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `customer_code` varchar(50) DEFAULT NULL COMMENT '客户编码',
  `customer_name` varchar(100) NOT NULL COMMENT '客户名称',
  `short_name` varchar(50) DEFAULT NULL COMMENT '简称',
  `customer_type` int DEFAULT NULL COMMENT '客户类型',
  `contact_person` varchar(50) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `website` varchar(100) DEFAULT NULL COMMENT '网址',
  `country` varchar(50) DEFAULT NULL COMMENT '国家',
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  `city` varchar(50) DEFAULT NULL COMMENT '城市',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `credit_limit` decimal(18,2) DEFAULT NULL COMMENT '信用额度',
  `payment_days` int DEFAULT NULL COMMENT '付款天数',
  `settlement_type` int DEFAULT NULL COMMENT '结算方式',
  `tax_rate` decimal(5,2) DEFAULT NULL COMMENT '税率',
  `bank_name` varchar(100) DEFAULT NULL COMMENT '开户银行',
  `bank_account` varchar(50) DEFAULT NULL COMMENT '银行账号',
  `tax_number` varchar(50) DEFAULT NULL COMMENT '税号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` bit(1) DEFAULT b'1' COMMENT '状态：0-禁用，1-正常',
  `created_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除标记：0-未删除，1-已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_customer_code` (`customer_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客户表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `gender` tinyint DEFAULT 0 COMMENT '性别：0-未知，1-男，2-女',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `post_id` bigint DEFAULT NULL COMMENT '岗位ID',
  `status` bit(1) DEFAULT b'1' COMMENT '状态：0-禁用，1-正常',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除标记：0-未删除，1-已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `role_code` varchar(50) NOT NULL COMMENT '角色编码',
  `sort` int DEFAULT 0 COMMENT '排序',
  `status` bit(1) DEFAULT b'1' COMMENT '状态：0-禁用，1-正常',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_code` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `parent_id` bigint DEFAULT 0 COMMENT '父菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `menu_code` varchar(50) DEFAULT NULL COMMENT '菜单编码',
  `path` varchar(255) DEFAULT NULL COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `sort` int DEFAULT 0 COMMENT '排序',
  `menu_type` tinyint DEFAULT 1 COMMENT '类型：0-目录，1-菜单，2-按钮',
  `status` bit(1) DEFAULT b'1' COMMENT '状态：0-禁用，1-正常',
  `visible` bit(1) DEFAULT b'1' COMMENT '是否可见',
  `keep_alive` bit(1) DEFAULT b'1' COMMENT '是否缓存',
  `always_show` bit(1) DEFAULT b'0' COMMENT '是否总是显示',
  `created_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `parent_id` bigint DEFAULT 0 COMMENT '父部门ID',
  `dept_name` varchar(50) NOT NULL COMMENT '部门名称',
  `sort` int DEFAULT 0 COMMENT '排序',
  `leader` varchar(50) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `status` bit(1) DEFAULT b'1' COMMENT '状态：0-禁用，1-正常',
  `created_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门表';

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `post_code` varchar(50) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `sort` int DEFAULT 0 COMMENT '排序',
  `status` bit(1) DEFAULT b'1' COMMENT '状态：0-禁用，1-正常',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_post_code` (`post_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='岗位表';

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关联表';

-- ----------------------------
-- Insert default data
-- ----------------------------
-- Insert default admin user (password: admin123)
INSERT INTO `sys_user` (`id`, `username`, `password`, `nickname`, `status`, `created_by`, `created_time`) 
VALUES (1, 'admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'Administrator', 1, 'system', NOW());

-- Insert default roles
INSERT INTO `sys_role` (`id`, `role_name`, `role_code`, `sort`, `status`, `created_by`, `created_time`) VALUES
(1, '超级管理员', 'SUPER_ADMIN', 1, 1, 'system', NOW()),
(2, '普通用户', 'USER', 2, 1, 'system', NOW());

-- Insert default menus
INSERT INTO `sys_menu` (`id`, `parent_id`, `menu_name`, `menu_code`, `path`, `component`, `icon`, `sort`, `menu_type`, `status`) VALUES
(1, 0, '系统管理', 'system', '/system', 'Layout', 'Setting', 1, 0, 1),
(2, 1, '用户管理', 'system:user', '/system/user', 'system/user/index', 'User', 1, 1, 1),
(3, 1, '角色管理', 'system:role', '/system/role', 'system/role/index', 'Peoper', 2, 1, 1),
(4, 1, '菜单管理', 'system:menu', '/system/menu', 'system/menu/index', 'Menu', 3, 1, 1),
(5, 1, '部门管理', 'system:dept', '/system/dept', 'system/dept/index', 'Office', 4, 1, 1),
(6, 1, '岗位管理', 'system:post', '/system/post', 'system/post/index', 'Postcard', 5, 1, 1);

-- Insert default admin user role
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (1, 1);

-- Insert super admin menu permissions
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6);

-- ----------------------------
-- Insert base_customer data
-- ----------------------------
INSERT INTO `base_customer` (`customer_code`, `customer_name`, `short_name`, `customer_type`, `contact_person`, `phone`, `mobile`, `email`, `province`, `city`, `address`, `credit_limit`, `status`, `created_by`, `created_time`) VALUES
('C001', '华为技术有限公司', '华为', 1, '张经理', '0755-28780888', '13800138000', 'info@huawei.com', '广东省', '深圳市', '深圳市龙岗区坂田华为基地', 1000000, 1, 'system', NOW()),
('C002', '腾讯科技有限公司', '腾讯', 1, '李经理', '0755-83766666', '13800138001', 'info@tencent.com', '广东省', '深圳市', '深圳市南山区科技园', 1000000, 1, 'system', NOW()),
('C003', '阿里巴巴集团', '阿里', 1, '王经理', '0571-88188888', '13800138002', 'info@alibaba.com', '浙江省', '杭州市', '杭州市余杭区阿里巴巴园区', 1000000, 1, 'system', NOW()),
('C004', '百度在线网络技术有限公司', '百度', 1, '赵经理', '010-59928888', '13800138003', 'info@baidu.com', '北京市', '北京市', '北京市海淀区百度科技园', 800000, 1, 'system', NOW()),
('C005', '京东集团', '京东', 1, '刘经理', '010-89111111', '13800138004', 'info@jd.com', '北京市', '北京市', '北京市亦庄经济开发区', 800000, 1, 'system', NOW()),
('C006', '美团', '美团', 1, '周经理', '010-57678888', '13800138005', 'info@meituan.com', '北京市', '北京市', '北京市朝阳区望京', 600000, 1, 'system', NOW()),
('C007', '字节跳动', '字节', 1, '吴经理', '010-68768888', '13800138006', 'info@bytedance.com', '北京市', '北京市', '北京市海淀区知春路', 600000, 1, 'system', NOW()),
('C008', '小米科技有限责任公司', '小米', 1, '郑经理', '010-56788888', '13800138007', 'info@xiaomi.com', '北京市', '北京市', '北京市海淀区小米科技园', 500000, 1, 'system', NOW()),
('C009', '网易公司', '网易', 1, '孙经理', '0571-89898888', '13800138008', 'info@163.com', '浙江省', '杭州市', '杭州市滨江区网易大厦', 500000, 1, 'system', NOW()),
('C010', '拼多多', '拼多多', 1, '钱经理', '021-58778888', '13800138009', 'info@pinduoduo.com', '上海市', '上海市', '上海市长宁区拼多多总部', 500000, 1, 'system', NOW());

-- ----------------------------
-- Table structure for base_supplier
-- ----------------------------
DROP TABLE IF EXISTS `base_supplier`;
-- 创建供应商表
CREATE TABLE IF NOT EXISTS `base_supplier` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `supplier_code` varchar(50) DEFAULT NULL,
  `supplier_name` varchar(100) NOT NULL,
  `short_name` varchar(50) DEFAULT NULL,
  `supplier_type` int DEFAULT NULL,
  `contact_person` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `bank_name` varchar(100) DEFAULT NULL,
  `bank_account` varchar(50) DEFAULT NULL,
  `tax_number` varchar(50) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `status` bit(1) DEFAULT b'1',
  `created_by` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Insert base_supplier data
-- ----------------------------
INSERT INTO `base_supplier` (`supplier_code`, `supplier_name`, `short_name`, `supplier_type`, `contact_person`, `phone`, `mobile`, `email`, `province`, `city`, `address`, `status`, `created_by`, `created_time`) VALUES
('S001', '联想集团', '联想', 1, '张经理', '010-58888888', '13900139000', 'info@lenovo.com', '北京市', '北京市', '北京市海淀区联想总部', 1, 'system', NOW()),
('S002', '戴尔科技公司', '戴尔', 1, '李经理', '021-58888888', '13900139001', 'info@dell.com', '上海市', '上海市', '上海市静安区戴尔大厦', 1, 'system', NOW()),
('S003', '惠普公司', 'HP', 1, '王经理', '010-58888888', '13900139002', 'info@hp.com', '北京市', '北京市', '北京市朝阳区HP大厦', 1, 'system', NOW()),
('S004', '英特尔公司', 'Intel', 1, '赵经理', '010-58888888', '13900139003', 'info@intel.com', '北京市', '北京市', '北京市海淀区Intel中心', 1, 'system', NOW()),
('S005', '三星电子', '三星', 1, '刘经理', '010-58888888', '13900139004', 'info@samsung.com', '北京市', '北京市', '北京市朝阳区三星大厦', 1, 'system', NOW());

-- ----------------------------
-- Table structure for base_material
-- ----------------------------
DROP TABLE IF EXISTS `base_material`;
CREATE TABLE `base_material` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `material_code` varchar(50) DEFAULT NULL COMMENT '物料编码',
  `material_name` varchar(100) NOT NULL COMMENT '物料名称',
  `spec` varchar(100) DEFAULT NULL COMMENT '规格',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位',
  `category` varchar(50) DEFAULT NULL COMMENT '分类',
  `safe_stock` int DEFAULT 0 COMMENT '安全库存',
  `purchase_price` decimal(18,2) DEFAULT NULL COMMENT '采购价',
  `sale_price` decimal(18,2) DEFAULT NULL COMMENT '销售价',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` bit(1) DEFAULT b'1' COMMENT '状态：0-禁用，1-正常',
  `created_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_material_code` (`material_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物料表';

-- ----------------------------
-- Insert base_material data
-- ----------------------------
INSERT INTO `base_material` (`material_code`, `material_name`, `spec`, `unit`, `category`, `safe_stock`, `purchase_price`, `sale_price`, `status`, `created_by`, `created_time`) VALUES
('M001', '笔记本电脑', 'i5/16G/512G', '台', '电子产品', 50, 5000.00, 6000.00, 1, 'system', NOW()),
('M002', '台式机主机', 'i7/32G/1T', '台', '电子产品', 30, 4000.00, 4800.00, 1, 'system', NOW()),
('M003', '显示器', '27寸/4K', '台', '电子产品', 40, 1500.00, 1800.00, 1, 'system', NOW()),
('M004', '机械键盘', '104键/青轴', '个', '配件', 100, 200.00, 250.00, 1, 'system', NOW()),
('M005', '无线鼠标', '蓝牙/静音', '个', '配件', 150, 80.00, 100.00, 1, 'system', NOW()),
('M006', '固态硬盘', '1TB/NVMe', '个', '配件', 80, 600.00, 720.00, 1, 'system', NOW()),
('M007', '内存条', '16G/DDR4', '条', '配件', 60, 300.00, 360.00, 1, 'system', NOW()),
('M008', '打印机', '激光/双面', '台', '办公设备', 20, 1500.00, 1800.00, 1, 'system', NOW());

-- ----------------------------
-- Table structure for base_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `base_warehouse`;
CREATE TABLE `base_warehouse` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `warehouse_code` varchar(50) DEFAULT NULL COMMENT '仓库编码',
  `warehouse_name` varchar(100) NOT NULL COMMENT '仓库名称',
  `short_name` varchar(50) DEFAULT NULL COMMENT '简称',
  `warehouse_type` int DEFAULT 3 COMMENT '仓库类型：1-原材料仓，2-成品仓，3-通用仓',
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  `city` varchar(50) DEFAULT NULL COMMENT '城市',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `manager` varchar(50) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` bit(1) DEFAULT b'1' COMMENT '状态：0-禁用，1-正常',
  `created_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_warehouse_code` (`warehouse_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='仓库表';

-- ----------------------------
-- Insert base_warehouse data
-- ----------------------------
INSERT INTO `base_warehouse` (`warehouse_code`, `warehouse_name`, `short_name`, `warehouse_type`, `province`, `city`, `address`, `manager`, `phone`, `status`, `created_by`, `created_time`) VALUES
('W001', '北京总仓', '北京仓', 3, '北京市', '北京市', '北京市朝阳区仓库路1号', '王主管', '010-12345678', 1, 'system', NOW()),
('W002', '上海分仓', '上海仓', 3, '上海市', '上海市', '上海市浦东新区仓库路2号', '李主管', '021-12345678', 1, 'system', NOW()),
('W003', '广州分仓', '广州仓', 1, '广东省', '广州市', '广州市白云区仓库路3号', '张主管', '020-12345678', 1, 'system', NOW()),
('W004', '成都成品仓', '成都仓', 2, '四川省', '成都市', '成都市龙泉驿区仓库路4号', '刘主管', '028-12345678', 1, 'system', NOW());
