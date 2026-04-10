# ERP系统开发状态

> 更新时间：2026-04-10 14:37

---

## 修改历史

| 时间 | 更改项目 | 说明 |
|------|----------|------|
| 2026-04-10 14:00 | 基础框架 | 创建pom.xml、application.yml、BaseEntity、ApiResponse等 |
| 2026-04-10 14:15 | 用户管理 | 创建SysUser实体、Mapper、Service、Controller、数据库脚本 |
| 2026-04-10 14:20 | 更新文档 | 添加修改历史记录表格 |
| 2026-04-10 14:30 | 角色管理 | 创建SysRole实体、Service、Controller |
| 2026-04-10 14:32 | 菜单管理 | 创建SysMenu实体、Service、Controller |
| 2026-04-10 14:34 | 部门管理 | 创建SysDept实体、Service、Controller |
| 2026-04-10 14:36 | 岗位管理 | 创建SysPost实体、Service、Controller |

---

## 一、项目当前状态

### 1.1 开发进度

| 模块 | 状态 | 说明 |
|------|------|------|
| 基础框架 | ✅ 已完成 | pom.xml、application.yml、BaseEntity、ApiResponse等 |
| 用户管理 | ✅ 已完成 | Entity、Mapper、Service、Controller、SQL |
| 角色管理 | ✅ 已完成 | Entity、Service、Controller |
| 菜单管理 | ✅ 已完成 | Entity、Service、Controller |
| 部门管理 | ✅ 已完成 | Entity、Service、Controller |
| 岗位管理 | ✅ 已完成 | Entity、Service、Controller |
| 登录认证 | ⏳ 待开发 | - |
| 基础数据模块 | ⏳ 待开发 | - |
| 业务模块 | ⏳ 待开发 | - |
| 财务模块 | ⏳ 待开发 | - |

---

## 二、已创建文件清单

### 2.1 基础框架

| 文件路径 | 说明 |
|----------|------|
| `pom.xml` | Maven依赖配置 |
| `src/main/resources/application.yml` | 应用配置 |
| `src/main/java/org/example/common/entity/BaseEntity.java` | 基础实体类 |
| `src/main/java/org/example/common/entity/BaseSimpleEntity.java` | 简单实体类 |
| `src/main/java/org/example/common/model/ApiResponse.java` | 统一响应类 |
| `src/main/java/org/example/config/MybatisPlusConfig.java` | MyBatis Plus配置 |

### 2.2 系统管理模块 - 用户管理

| 文件路径 | 说明 |
|----------|------|
| `modules/system/entity/SysUser.java` | 用户实体 |
| `modules/system/entity/SysRole.java` | 角色实体 |
| `modules/system/entity/SysMenu.java` | 菜单实体 |
| `modules/system/entity/SysDept.java` | 部门实体 |
| `modules/system/entity/SysPost.java` | 岗位实体 |
| `modules/system/mapper/SysUserMapper.java` | 用户Mapper |
| `modules/system/mapper/SysRoleMapper.java` | 角色Mapper |
| `modules/system/service/SysUserService.java` | 用户Service接口 |
| `modules/system/service/impl/SysUserServiceImpl.java` | 用户Service实现 |
| `modules/system/controller/SysUserController.java` | 用户Controller |

### 2.3 数据库脚本

| 文件路径 | 说明 |
|----------|------|
| `src/main/resources/db/init/mysql_ERP.sql` | 完整数据库结构（系统模块） |

---

## 三、数据库表

### 3.1 已创建表

| 表名 | 说明 | 状态 |
|------|------|------|
| sys_user | 用户表 | ✅ 已创建 |
| sys_role | 角色表 | ✅ 已创建 |
| sys_menu | 菜单表 | ✅ 已创建 |
| sys_dept | 部门表 | ✅ 已创建 |
| sys_post | 岗位表 | ✅ 已创建 |
| sys_user_role | 用户角色关联表 | ✅ 已创建 |
| sys_role_menu | 角色菜单关联表 | ✅ 已创建 |

### 3.2 默认数据

- 管理员账号：`admin` / `admin123`
- 超级管理员角色
- 系统管理菜单

---

## 四、API接口清单

### 4.1 用户管理

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | /api/system/user/page | 分页查询用户列表 |
| GET | /api/system/user/{id} | 获取用户详情 |
| POST | /api/system/user | 新增用户 |
| PUT | /api/system/user | 更新用户 |
| DELETE | /api/system/user/{id} | 删除用户 |

---

## 五、后续开发计划

### 阶段二：系统管理模块（继续）
1. 角色管理 CRUD
2. 菜单管理 CRUD
3. 部门管理 CRUD
4. 岗位管理 CRUD
5. 登录认证 JWT

### 阶段三：基础数据模块
1. 客户管理
2. 供应商管理
3. 物料管理
4. 仓库管理

### 阶段四：业务模块
1. 销售订单/出库
2. 采购订单/入库
3. 库存管理

### 阶段五：财务模块
1. 应收应付
2. 收付款

---

## 六、注意事项

1. ⚠️ 每次功能开发完成后必须更新本文档
2. ⚠️ 重要数据及时提交Git备份
3. 开发前先阅读 `docs/ERP开发指南.md`