# ERP系统开发指南

## 一、项目概述

### 1.1 项目简介
本项目是一套完整的企业资源规划（ERP）系统，采用前后端分离架构：
- **后端**：Java 8 + Spring Boot 2.x + MyBatis Plus
- **前端**：Vue 3 + Element Plus
- **数据库**：MySQL 8.0
- **开发工具**：IntelliJ IDEA（后端）、WebStorm/VS Code（前端）

### 1.2 项目模块
```
ERP系统
├── 后端 (D:\ERPAPI\untitled)
│   ├── src/main/java/org/example/
│   │   ├── config/          # 配置类
│   │   ├── common/          # 公共组件（异常处理、工具类、实体基类）
│   │   └── modules/         # 业务模块
│   │       ├── system/      # 系统管理（用户、角色、菜单、部门、审批流程）
│   │       ├── base/        # 基础数据（客户、供应商、仓库、物料）
│   │       ├── sales/       # 销售管理（销售订单、销售退货、销售出库）
│   │       ├── purchase/    # 采购管理（采购订单、采购入库、采购退货）
│   │       ├── inventory/   # 库存管理（库存查询、库存流水）
│   │       └── finance/     # 财务管理（应收账款、应付账款、收款、付款）
│   └── src/main/resources/
│       ├── db/init/         # 数据库初始化脚本
│       │   ├── mysql_ERP.sql      # 完整数据库结构
│       │   └── erp_demo_data.sql # 演示数据
│       └── application.yml # 应用配置
│
└── 前端 (开发规则中提到在 D:\ERPAPI\erp)
    ├── public/              # 静态资源
    ├── src/
    │   ├── api/            # API接口
    │   ├── components/     # 公共组件
    │   ├── layouts/       # 布局组件
    │   ├── router/        # 路由配置
    │   ├── store/         # 状态管理
    │   ├── utils/         # 工具函数
    │   └── views/         # 页面视图
    └── package.json       # 前端依赖配置
```

---

## 二、环境搭建

### 2.1 后端环境

#### 2.1.1 JDK安装
- 下载 JDK 8：https://www.oracle.com/java/technologies/downloads/#java8
- 或使用 OpenJDK：https://adoptium.net/
- 配置环境变量：
  ```
  JAVA_HOME = C:\Program Files\Java\jdk1.8.0_xxx
  PATH = %JAVA_HOME%\bin
  ```

#### 2.1.2 Maven安装
- 下载 Maven 3.8+：https://maven.apache.org/download.cgi
- 配置阿里云镜像（`maven/conf/settings.xml`）：
  ```xml
  <mirrors>
    <mirror>
      <id>aliyunmaven</id>
      <mirrorOf>*</mirrorOf>
      <name>阿里云公共仓库</name>
      <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
  </mirrors>
  ```

#### 2.1.3 MySQL安装
- 下载 MySQL 8.0：https://dev.mysql.com/downloads/mysql/
- 创建数据库：
  ```sql
  CREATE DATABASE erp DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
  ```
- 执行初始化脚本：
  ```bash
  mysql -u root -p erp < src/main/resources/db/init/mysql_ERP.sql
  mysql -u root -p erp < src/main/resources/db/init/erp_demo_data.sql
  ```

#### 2.1.4 运行后端
```bash
cd D:\ERPAPI\untitled
mvn clean package -DskipTests
java -jar target/untitled-1.0-SNAPSHOT.jar
```
默认端口：`8080`

---

### 2.2 前端环境

#### 2.2.1 Node.js安装
- 下载 Node.js 18+：https://nodejs.org/

#### 2.2.2 创建Vue项目（如D:\ERPAPI\erp不存在）
```bash
# 使用Vue CLI创建项目
npm install -g @vue/cli
vue create erp

# 或使用Vite创建（推荐）
npm create vite@latest erp -- --template vue
cd erp
npm install
```

#### 2.2.3 安装依赖
```bash
# 核心依赖
npm install vue@3 vue-router@4 pinia element-plus axios

# 开发依赖
npm install -D vite @vitejs/plugin-vue
```

#### 2.2.4 运行前端
```bash
cd D:\ERPAPI\erp
npm run dev
```
默认端口：`5173`

---

## 三、技术栈详解

### 3.1 后端技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Java | 8 | 运行环境 |
| Spring Boot | 2.x | 快速开发框架 |
| MyBatis Plus | 3.5.x | ORM框架 |
| MySQL | 8.0 | 关系型数据库 |
| JWT | - | 身份认证 |
| Lombok | - | 代码生成 |
| Hutool | - | 工具集 |

### 3.2 前端技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Vue | 3.x | 渐进式前端框架 |
| Vue Router | 4.x | 路由管理 |
| Pinia | 2.x | 状态管理 |
| Element Plus | - | UI组件库 |
| Axios | - | HTTP请求 |
| Vite | - | 构建工具 |

---

## 四、数据库设计

### 4.1 核心表结构

#### 4.1.1 系统模块
- `sys_user` - 用户表
- `sys_role` - 角色表
- `sys_menu` - 菜单表
- `sys_dept` - 部门表
- `sys_post` - 岗位表

#### 4.1.2 基础数据模块
- `base_customer` - 客户表
- `base_supplier` - 供应商表
- `base_warehouse` - 仓库表
- `base_material` - 物料表
- `base_unit` - 单位表

#### 4.1.3 业务模块
- `sal_order` / `sal_order_item` - 销售订单
- `pur_order` / `pur_order_item` - 采购订单
- `inv_stock` - 库存表
- `fin_account` - 账户表

### 4.2 表设计规范
```sql
-- 基础字段（所有表通用）
CREATE TABLE example (
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_by      VARCHAR(50) COMMENT '创建人',
    created_time    DATETIME COMMENT '创建时间',
    updated_by      VARCHAR(50) COMMENT '更新人',
    updated_time    DATETIME COMMENT '更新时间',
    deleted         BIT(1) DEFAULT FALSE COMMENT '是否删除'
);
```

---

## 五、开发规范

### 5.1 代码规范

#### 5.1.1 后端规范
- 包名：`org.example.modules.{模块名}`
- Controller：以 `Controller` 结尾
- Service：以 `Service` 结尾，实现类以 `ServiceImpl` 结尾
- Mapper：以 `Mapper` 结尾
- Entity：以实体名称命名

示例：
```
org.example.modules.system
├── controller/SysUserController.java
├── service/SysUserService.java
├── service/impl/SysUserServiceImpl.java
├── mapper/SysUserMapper.java
└── entity/SysUser.java
```

#### 5.1.2 数据库规范
- 表名：使用小写字母+下划线，如 `sys_user`
- 字段名：使用小写字母+下划线，如 `user_name`
- 主键：统一使用 `BIGINT` 类型的 `id`
- 软删除：使用 `deleted` 字段，BIT(1) 类型

### 5.2 接口规范

#### 5.2.1 RESTful API
```
GET    /api/{module}/{resource}        # 查询列表
GET    /api/{module}/{resource}/{id}   # 查询详情
POST   /api/{module}/{resource}        # 新增
PUT    /api/{module}/{resource}/{id}   # 更新
DELETE /api/{module}/{resource}/{id}   # 删除
```

#### 5.2.2 响应格式
```json
{
    "code": 200,
    "message": "操作成功",
    "data": {}
}
```

---

## 六、核心功能说明

### 6.1 用户认证
- JWT Token 认证
- 登录接口：`POST /api/auth/login`
- 登出接口：`POST /api/auth/logout`

### 6.2 权限控制
- 基于角色的权限控制（RBAC）
- 菜单权限 + 按钮权限
- 数据权限（部门级别）

### 6.3 审批流程
- 可配置的审批流程
- 支持多级审批
- 审批节点：开始→审批节点→结束

---

## 七、常见问题

### 7.1 后端启动失败
1. 检查MySQL是否启动
2. 检查application.yml中的数据库配置
3. 检查端口8080是否被占用

### 7.2 前端启动失败
1. 检查Node.js版本是否正确
2. 删除node_modules重新安装：`rm -rf node_modules && npm install`

### 7.3 数据库恢复
如果遇到数据丢失，可以从以下位置恢复：
1. Git仓库历史
2. IDE本地历史
3. 数据库备份文件

---

## 八、开发流程

1. **创建分支**
   ```bash
   git checkout -b feature/xxx
   ```

2. **开发功能**
   - 后端：Controller → Service → Mapper → Entity
   - 前端：API → View → Router

3. **提交代码**
   ```bash
   git add .
   git commit -m "feat: 添加xxx功能"
   ```

4. **合并到主分支**
   ```bash
   git checkout master
   git merge feature/xxx
   ```

---

## 九、相关文档

- 开发规则：`D:\ERPAPI\untitled\开发规则.txt`
- 完整数据库：`D:\ERPAPI\untitled\src\main\resources\db\init\mysql_ERP.sql`
- 演示数据：`D:\ERPAPI\untitled\src\main\resources\db\init\erp_demo_data.sql`

---

## 十、注意事项

1. 每次开发前先读取当前进度，开发完成后立即同步更新文档
2. 初始化数据写到 `erp_demo_data.sql` 中
3. md文档使用UTF-8直接追加写入
4. docx文档通过解压word/document.xml后修改正文，再重新打包写回
5. 更新文档时必须先保留原历史记录，再追加新记录，禁止整篇覆盖
