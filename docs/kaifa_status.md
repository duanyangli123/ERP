# ERP系统开发状态

> 更新时间：2026-04-15 10:30

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
| 2026-04-10 14:55 | 登录认证 | 创建JWT工具类、AuthService、AuthController |
| 2026-04-13 14:45 | 客户管理 | 创建BaseCustomer实体、Mapper、Service、Controller |
| 2026-04-13 14:50 | 供应商管理 | 创建BaseSupplier实体、Mapper、Service、Controller |
| 2026-04-13 14:55 | 物料管理 | 创建BaseMaterial实体、Mapper、Service、Controller |
| 2026-04-13 15:00 | 仓库管理 | 创建BaseWarehouse实体、Mapper、Service、Controller |
| 2026-04-13 15:10 | 销售订单 | 创建SalOrder、SalOrderItem实体、Mapper、Service、Controller |
| 2026-04-13 15:18 | 采购订单 | 创建PurOrder实体、Mapper、Service、Controller |
| 2026-04-13 15:24 | 库存查询 | 创建InvStock实体、Mapper、Service、Controller |
| 2026-04-14 09:33 | 财务管理 | 创建FinReceivable、FinPayable、FinPayment、FinReceipt、FinAccount、FinAccountFlow实体及Mapper、Service、Controller |
| 2026-04-14 10:00 | 销售出库 | 创建SalOutbound、SalOutboundItem实体、Mapper、Service、Controller |
| 2026-04-14 10:15 | 采购入库 | 创建PurReceipt、PurReceiptItem实体、Mapper、Service、Controller |
| 2026-04-14 10:30 | 销售退货 | 创建SalReturn、SalReturnItem实体、Mapper、Service、Controller |
| 2026-04-14 10:45 | 采购退货 | 创建PurReturn、PurReturnItem实体、Mapper、Service、Controller |
| 2026-04-14 11:00 | 仓库库区库位 | 创建BaseWarehouseArea、BaseWarehouseLocation实体、Service、Controller |
| 2026-04-14 11:15 | 客户地址联系人 | 创建BaseCustomerAddress、BaseCustomerContact实体、Service、Controller |
| 2026-04-14 11:30 | 供应商联系人 | 创建BaseSupplierContact实体、Service、Controller |
| 2026-04-14 11:45 | 库存流水 | 创建InvStockFlow实体、Mapper、Service、Controller |
| 2026-04-14 12:00 | 单位管理 | 创建BaseUnit实体、Mapper、Service、Controller |
| 2026-04-15 09:00 | 审批流程 | 创建OaProcessDef、OaTask、OaApprover等审批相关实体和Service |
| 2026-04-15 09:30 | 消息通知 | 创建SysMessage、NotifyChannel等消息通知相关组件 |
| 2026-04-15 10:00 | 完善文档 | 更新开发状态文档，补充所有已完成功能 |
| 2026-04-15 10:35 | 前端初始化 | 创建Vue 3 + Vite项目，配置Element Plus、Pinia、Vue Router |
| 2026-04-15 10:40 | 前端认证 | 实现登录页面、用户状态管理、路由守卫 |
| 2026-04-15 10:45 | 前端API | 创建auth、system、base、sales、purchase、finance接口文件 |
| 2026-04-15 10:50 | 前端系统管理 | 实现用户、角色、菜单、部门管理页面 |
| 2026-04-15 10:55 | 前端基础数据 | 实现客户、供应商、物料、仓库管理页面 |
| 2026-04-15 11:00 | 前端销售模块 | 实现销售订单、销售出库、销售退货页面 |
| 2026-04-15 11:05 | 前端采购模块 | 实现采购订单、采购入库、采购退货页面 |
| 2026-04-15 11:10 | 前端财务模块 | 实现应收账款、应付账款、收款单、付款单、账户管理页面 |
| 2026-04-15 11:15 | 更新文档 | 补充前端开发记录到开发状态文档 |

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
| 登录认证 | ✅ 已完成 | JWT工具类、AuthService、AuthController、权限注解、拦截器 |
| 基础数据模块 | ✅ 已完成 | 客户、供应商、物料、仓库、单位、地址、联系人、库区库位 |
| 销售模块 | ✅ 已完成 | 销售订单、销售出库、销售退货 |
| 采购模块 | ✅ 已完成 | 采购订单、采购入库、采购退货 |
| 库存模块 | ✅ 已完成 | 库存查询、库存流水 |
| 财务模块 | ✅ 已完成 | 应收账款、应付账款、收款、付款、账户、资金流水 |
| 审批流程 | ✅ 已完成 | 流程定义、任务管理、审批候选人 |
| 消息通知 | ✅ 已完成 | 消息管理、通知分发 |
| 前端开发 | ✅ 已完成 | 完整前端页面，涵盖所有业务模块 |

---

## 二、已创建文件清单

### 2.1 基础框架

| 文件路径 | 说明 |
|----------|------|
| `pom.xml` | Maven依赖配置 |
| `src/main/resources/application.yml` | 应用配置 |
| `src/main/java/org/example/common/entity/BaseEntity.java` | 基础实体类（包含id、创建时间、更新时间、删除标志） |
| `src/main/java/org/example/common/entity/BaseSimpleEntity.java` | 简单实体类（仅包含id） |
| `src/main/java/org/example/common/model/ApiResponse.java` | 统一响应类 |
| `src/main/java/org/example/config/MybatisPlusConfig.java` | MyBatis Plus配置 |
| `src/main/java/org/example/common/exception/GlobalExceptionHandler.java` | 全局异常处理 |
| `src/main/java/org/example/common/exception/BusinessException.java` | 业务异常类 |

### 2.2 系统管理模块

#### 2.2.1 实体类

| 文件路径 | 说明 |
|----------|------|
| `modules/system/entity/SysUser.java` | 用户实体 |
| `modules/system/entity/SysRole.java` | 角色实体 |
| `modules/system/entity/SysMenu.java` | 菜单实体 |
| `modules/system/entity/SysDept.java` | 部门实体 |
| `modules/system/entity/SysPost.java` | 岗位实体 |
| `modules/system/entity/SysUserRole.java` | 用户角色关联实体 |
| `modules/system/entity/SysRoleMenu.java` | 角色菜单关联实体 |

#### 2.2.2 认证授权

| 文件路径 | 说明 |
|----------|------|
| `modules/system/auth/util/TokenUtils.java` | JWT Token工具类 |
| `modules/system/auth/model/LoginUser.java` | 登录用户信息模型 |
| `modules/system/auth/model/UserProfileVO.java` | 用户资料VO |
| `modules/system/auth/interceptor/AuthInterceptor.java` | 认证拦截器 |
| `modules/system/auth/cache/AuthCacheService.java` | 认证缓存服务 |
| `modules/system/auth/annotation/IgnoreAuth.java` | 忽略认证注解 |
| `modules/system/auth/annotation/RequirePermission.java` | 权限校验注解 |

#### 2.2.3 审批流程

| 文件路径 | 说明 |
|----------|------|
| `modules/system/entity/OaProcessDef.java` | 流程定义实体 |
| `modules/system/entity/OaProcessNode.java` | 流程节点实体 |
| `modules/system/entity/OaTask.java` | 任务实体 |
| `modules/system/entity/OaApprover.java` | 审批人配置实体 |
| `modules/system/entity/SysMessage.java` | 系统消息实体 |
| `modules/system/model/OaProcessDefDetailVO.java` | 流程定义详情VO |
| `modules/system/model/OaProcessDefSaveRequest.java` | 流程定义保存请求 |
| `modules/system/model/OaProcessDetailVO.java` | 流程详情VO |
| `modules/system/model/OaMyTaskVO.java` | 我的任务VO |
| `modules/system/model/OaMyTaskQuery.java` | 我的任务查询 |
| `modules/system/model/OaApproverCandidateVO.java` | 审批候选人VO |
| `modules/system/model/OaProcessNodeSaveDTO.java` | 流程节点保存DTO |
| `modules/system/model/SysMessageQuery.java` | 消息查询 |
| `modules/system/model/SendMessageCommand.java` | 发送消息命令 |
| `modules/system/notify/NotifyChannelDispatcher.java` | 通知渠道分发器 |

#### 2.2.4 其他系统实体

| 文件路径 | 说明 |
|----------|------|
| `modules/system/model/RoleMenuAssignRequest.java` | 角色菜单分配请求 |
| `modules/system/model/UserRoleAssignRequest.java` | 用户角色分配请求 |
| `modules/system/model/SysMenuTreeVO.java` | 菜单树VO |
| `modules/system/model/ResetPasswordRequest.java` | 重置密码请求 |

### 2.3 基础数据模块

| 文件路径 | 说明 |
|----------|------|
| `modules/base/entity/BaseCustomer.java` | 客户实体 |
| `modules/base/entity/BaseSupplier.java` | 供应商实体 |
| `modules/base/entity/BaseMaterial.java` | 物料实体 |
| `modules/base/entity/BaseWarehouse.java` | 仓库实体 |
| `modules/base/entity/BaseUnit.java` | 单位实体 |
| `modules/base/entity/BaseCustomerAddress.java` | 客户地址实体 |
| `modules/base/entity/BaseCustomerContact.java` | 客户联系人实体 |
| `modules/base/entity/BaseSupplierContact.java` | 供应商联系人实体 |
| `modules/base/entity/BaseWarehouseArea.java` | 库区实体 |
| `modules/base/entity/BaseWarehouseLocation.java` | 库位实体 |
| `modules/base/mapper/BaseCustomerMapper.java` | 客户Mapper |
| `modules/base/mapper/BaseSupplierMapper.java` | 供应商Mapper |
| `modules/base/mapper/BaseMaterialMapper.java` | 物料Mapper |
| `modules/base/mapper/BaseWarehouseMapper.java` | 仓库Mapper |
| `modules/base/mapper/BaseUnitMapper.java` | 单位Mapper |
| `modules/base/service/BaseCustomerService.java` | 客户Service |
| `modules/base/service/BaseSupplierService.java` | 供应商Service |
| `modules/base/service/BaseMaterialService.java` | 物料Service |
| `modules/base/service/BaseWarehouseService.java` | 仓库Service |
| `modules/base/service/BaseUnitService.java` | 单位Service |
| `modules/base/service/impl/BaseCustomerServiceImpl.java` | 客户Service实现 |
| `modules/base/service/impl/BaseSupplierServiceImpl.java` | 供应商Service实现 |
| `modules/base/service/impl/BaseMaterialServiceImpl.java` | 物料Service实现 |
| `modules/base/service/impl/BaseWarehouseServiceImpl.java` | 仓库Service实现 |
| `modules/base/service/impl/BaseUnitServiceImpl.java` | 单位Service实现 |
| `modules/base/service/impl/BaseCustomerAddressServiceImpl.java` | 客户地址Service实现 |
| `modules/base/service/impl/BaseCustomerContactServiceImpl.java` | 客户联系人Service实现 |
| `modules/base/service/impl/BaseSupplierContactServiceImpl.java` | 供应商联系人Service实现 |
| `modules/base/service/impl/BaseWarehouseAreaServiceImpl.java` | 库区Service实现 |
| `modules/base/service/impl/BaseWarehouseLocationServiceImpl.java` | 库位Service实现 |
| `modules/base/controller/BaseCustomerController.java` | 客户Controller |
| `modules/base/controller/BaseSupplierController.java` | 供应商Controller |
| `modules/base/controller/BaseMaterialController.java` | 物料Controller |
| `modules/base/controller/BaseWarehouseController.java` | 仓库Controller |
| `modules/base/controller/BaseUnitController.java` | 单位Controller |
| `modules/base/controller/BaseCustomerAddressController.java` | 客户地址Controller |
| `modules/base/controller/BaseCustomerContactController.java` | 客户联系人Controller |
| `modules/base/controller/BaseSupplierContactController.java` | 供应商联系人Controller |
| `modules/base/controller/BaseWarehouseAreaController.java` | 库区Controller |
| `modules/base/controller/BaseWarehouseLocationController.java` | 库位Controller |

### 2.4 销售模块

| 文件路径 | 说明 |
|----------|------|
| `modules/sales/entity/SalOrder.java` | 销售订单实体 |
| `modules/sales/entity/SalOrderItem.java` | 销售订单明细实体 |
| `modules/sales/entity/SalOutbound.java` | 销售出库实体 |
| `modules/sales/entity/SalOutboundItem.java` | 销售出库明细实体 |
| `modules/sales/entity/SalReturn.java` | 销售退货实体 |
| `modules/sales/entity/SalReturnItem.java` | 销售退货明细实体 |
| `modules/sales/mapper/SalOrderMapper.java` | 销售订单Mapper |
| `modules/sales/mapper/SalOrderItemMapper.java` | 销售订单明细Mapper |
| `modules/sales/mapper/SalOutboundMapper.java` | 销售出库Mapper |
| `modules/sales/mapper/SalOutboundItemMapper.java` | 销售出库明细Mapper |
| `modules/sales/mapper/SalReturnMapper.java` | 销售退货Mapper |
| `modules/sales/mapper/SalReturnItemMapper.java` | 销售退货明细Mapper |
| `modules/sales/model/SalOrderSaveRequest.java` | 销售订单保存请求 |
| `modules/sales/model/SalOrderDetailVO.java` | 销售订单详情VO |
| `modules/sales/model/SalOrderQuery.java` | 销售订单查询 |
| `modules/sales/model/SalOutboundSaveRequest.java` | 销售出库保存请求 |
| `modules/sales/model/SalOutboundDetailVO.java` | 销售出库详情VO |
| `modules/sales/model/SalReturnSaveRequest.java` | 销售退货保存请求 |
| `modules/sales/model/SalReturnDetailVO.java` | 销售退货详情VO |
| `modules/sales/model/SalReturnQuery.java` | 销售退货查询 |
| `modules/sales/service/SalOrderService.java` | 销售订单Service |
| `modules/sales/service/SalOutboundService.java` | 销售出库Service |
| `modules/sales/service/SalReturnService.java` | 销售退货Service |
| `modules/sales/service/impl/SalOrderServiceImpl.java` | 销售订单Service实现 |
| `modules/sales/service/impl/SalOutboundServiceImpl.java` | 销售出库Service实现 |
| `modules/sales/service/impl/SalReturnServiceImpl.java` | 销售退货Service实现 |
| `modules/sales/controller/SalOrderController.java` | 销售订单Controller |
| `modules/sales/controller/SalOutboundController.java` | 销售出库Controller |
| `modules/sales/controller/SalReturnController.java` | 销售退货Controller |

### 2.5 采购模块

| 文件路径 | 说明 |
|----------|------|
| `modules/purchase/entity/PurOrder.java` | 采购订单实体 |
| `modules/purchase/entity/PurOrderItem.java` | 采购订单明细实体 |
| `modules/purchase/entity/PurReceipt.java` | 采购入库实体 |
| `modules/purchase/entity/PurReceiptItem.java` | 采购入库明细实体 |
| `modules/purchase/entity/PurReturn.java` | 采购退货实体 |
| `modules/purchase/entity/PurReturnItem.java` | 采购退货明细实体 |
| `modules/purchase/mapper/PurOrderMapper.java` | 采购订单Mapper |
| `modules/purchase/mapper/PurOrderItemMapper.java` | 采购订单明细Mapper |
| `modules/purchase/mapper/PurReceiptMapper.java` | 采购入库Mapper |
| `modules/purchase/mapper/PurReceiptItemMapper.java` | 采购入库明细Mapper |
| `modules/purchase/mapper/PurReturnMapper.java` | 采购退货Mapper |
| `modules/purchase/mapper/PurReturnItemMapper.java` | 采购退货明细Mapper |
| `modules/purchase/model/PurOrderSaveRequest.java` | 采购订单保存请求 |
| `modules/purchase/model/PurOrderDetailVO.java` | 采购订单详情VO |
| `modules/purchase/model/PurOrderQuery.java` | 采购订单查询 |
| `modules/purchase/model/PurReceiptSaveRequest.java` | 采购入库保存请求 |
| `modules/purchase/model/PurReceiptDetailVO.java` | 采购入库详情VO |
| `modules/purchase/model/PurReturnSaveRequest.java` | 采购退货保存请求 |
| `modules/purchase/model/PurReturnDetailVO.java` | 采购退货详情VO |
| `modules/purchase/model/PurReturnQuery.java` | 采购退货查询 |
| `modules/purchase/service/PurOrderService.java` | 采购订单Service |
| `modules/purchase/service/PurReceiptService.java` | 采购入库Service |
| `modules/purchase/service/PurReturnService.java` | 采购退货Service |
| `modules/purchase/service/impl/PurOrderServiceImpl.java` | 采购订单Service实现 |
| `modules/purchase/service/impl/PurReceiptServiceImpl.java` | 采购入库Service实现 |
| `modules/purchase/service/impl/PurReturnServiceImpl.java` | 采购退货Service实现 |
| `modules/purchase/controller/PurOrderController.java` | 采购订单Controller |
| `modules/purchase/controller/PurReceiptController.java` | 采购入库Controller |
| `modules/purchase/controller/PurReturnController.java` | 采购退货Controller |

### 2.6 库存模块

| 文件路径 | 说明 |
|----------|------|
| `modules/inventory/entity/InvStock.java` | 库存实体 |
| `modules/inventory/entity/InvStockFlow.java` | 库存流水实体 |
| `modules/inventory/mapper/InvStockMapper.java` | 库存Mapper |
| `modules/inventory/mapper/InvStockFlowMapper.java` | 库存流水Mapper |
| `modules/inventory/service/InvStockService.java` | 库存Service |
| `modules/inventory/service/InvStockFlowService.java` | 库存流水Service |
| `modules/inventory/service/impl/InvStockServiceImpl.java` | 库存Service实现 |
| `modules/inventory/service/impl/InvStockFlowServiceImpl.java` | 库存流水Service实现 |
| `modules/inventory/controller/InvStockController.java` | 库存Controller |
| `modules/inventory/controller/InvStockFlowController.java` | 库存流水Controller |

### 2.7 财务模块

| 文件路径 | 说明 |
|----------|------|
| `modules/finance/entity/FinAccount.java` | 账户实体 |
| `modules/finance/entity/FinAccountFlow.java` | 资金流水实体 |
| `modules/finance/entity/FinReceivable.java` | 应收账款实体 |
| `modules/finance/entity/FinPayable.java` | 应付账款实体 |
| `modules/finance/entity/FinReceipt.java` | 收款单实体 |
| `modules/finance/entity/FinReceiptItem.java` | 收款单明细实体 |
| `modules/finance/entity/FinPayment.java` | 付款单实体 |
| `modules/finance/entity/FinPaymentItem.java` | 付款单明细实体 |
| `modules/finance/mapper/FinAccountMapper.java` | 账户Mapper |
| `modules/finance/mapper/FinAccountFlowMapper.java` | 资金流水Mapper |
| `modules/finance/mapper/FinReceivableMapper.java` | 应收账款Mapper |
| `modules/finance/mapper/FinPayableMapper.java` | 应付账款Mapper |
| `modules/finance/mapper/FinReceiptMapper.java` | 收款单Mapper |
| `modules/finance/mapper/FinReceiptItemMapper.java` | 收款单明细Mapper |
| `modules/finance/mapper/FinPaymentMapper.java` | 付款单Mapper |
| `modules/finance/mapper/FinPaymentItemMapper.java` | 付款单明细Mapper |
| `modules/finance/model/FinReceiptSaveRequest.java` | 收款单保存请求 |
| `modules/finance/model/FinReceiptDetailVO.java` | 收款单详情VO |
| `modules/finance/model/FinPaymentSaveRequest.java` | 付款单保存请求 |
| `modules/finance/model/FinPaymentDetailVO.java` | 付款单详情VO |
| `modules/finance/service/FinAccountService.java` | 账户Service |
| `modules/finance/service/FinReceivableService.java` | 应收账款Service |
| `modules/finance/service/FinPayableService.java` | 应付账款Service |
| `modules/finance/service/FinReceiptService.java` | 收款Service |
| `modules/finance/service/FinPaymentService.java` | 付款Service |
| `modules/finance/service/impl/FinAccountServiceImpl.java` | 账户Service实现 |
| `modules/finance/service/impl/FinReceivableServiceImpl.java` | 应收账款Service实现 |
| `modules/finance/service/impl/FinPayableServiceImpl.java` | 应付账款Service实现 |
| `modules/finance/service/impl/FinReceiptServiceImpl.java` | 收款Service实现 |
| `modules/finance/service/impl/FinPaymentServiceImpl.java` | 付款Service实现 |
| `modules/finance/controller/FinAccountController.java` | 账户Controller |
| `modules/finance/controller/FinReceivableController.java` | 应收账款Controller |
| `modules/finance/controller/FinPayableController.java` | 应付账款Controller |
| `modules/finance/controller/FinReceiptController.java` | 收款Controller |
| `modules/finance/controller/FinPaymentController.java` | 付款Controller |

### 2.8 数据库脚本

| 文件路径 | 说明 |
|----------|------|
| `src/main/resources/db/init/mysql_ERP.sql` | 完整数据库结构 |
| `src/main/resources/db/init/erp_demo_data.sql` | 演示数据 |

### 2.9 前端项目

#### 2.9.1 项目配置

| 文件路径 | 说明 |
|----------|------|
| `package.json` | NPM依赖配置（Vue 3、Vite、Element Plus、Pinia、Axios、Vue Router） |
| `vite.config.js` | Vite构建配置 |
| `index.html` | HTML入口文件 |

#### 2.9.2 核心模块

| 文件路径 | 说明 |
|----------|------|
| `src/main.js` | 应用入口 |
| `src/App.vue` | 根组件 |
| `src/style.css` | 全局样式 |

#### 2.9.3 工具和配置

| 文件路径 | 说明 |
|----------|------|
| `src/utils/request.js` | Axios封装（请求/响应拦截器、Token管理、错误处理） |
| `src/router/index.js` | 路由配置（动态导入、路由守卫） |
| `src/stores/user.js` | 用户状态管理（Pinia Store） |

#### 2.9.4 API接口

| 文件路径 | 说明 |
|----------|------|
| `src/api/auth.js` | 认证接口（登录、登出、获取用户信息） |
| `src/api/system.js` | 系统管理接口（用户、角色、菜单、部门） |
| `src/api/base.js` | 基础数据接口（客户、供应商、物料、仓库） |
| `src/api/sales.js` | 销售模块接口（订单、出库、退货） |
| `src/api/purchase.js` | 采购模块接口（订单、入库、退货） |
| `src/api/finance.js` | 财务模块接口（应收应付、收付款、账户） |

#### 2.9.5 布局和页面

| 文件路径 | 说明 |
|----------|------|
| `src/layouts/MainLayout.vue` | 主布局（侧边栏、头部、主体内容） |
| `src/views/login/index.vue` | 登录页面 |
| `src/views/dashboard/index.vue` | 首页/仪表盘 |

#### 2.9.6 系统管理页面

| 文件路径 | 说明 |
|----------|------|
| `src/views/system/user/index.vue` | 用户管理页面 |
| `src/views/system/role/index.vue` | 角色管理页面 |
| `src/views/system/menu/index.vue` | 菜单管理页面 |
| `src/views/system/dept/index.vue` | 部门管理页面 |

#### 2.9.7 基础数据页面

| 文件路径 | 说明 |
|----------|------|
| `src/views/base/customer/index.vue` | 客户管理页面 |
| `src/views/base/supplier/index.vue` | 供应商管理页面 |
| `src/views/base/material/index.vue` | 物料管理页面 |
| `src/views/base/warehouse/index.vue` | 仓库管理页面 |

#### 2.9.8 销售模块页面

| 文件路径 | 说明 |
|----------|------|
| `src/views/sales/order/index.vue` | 销售订单页面 |
| `src/views/sales/outbound/index.vue` | 销售出库页面 |
| `src/views/sales/return/index.vue` | 销售退货页面 |

#### 2.9.9 采购模块页面

| 文件路径 | 说明 |
|----------|------|
| `src/views/purchase/order/index.vue` | 采购订单页面 |
| `src/views/purchase/receipt/index.vue` | 采购入库页面 |
| `src/views/purchase/return/index.vue` | 采购退货页面 |

#### 2.9.10 财务模块页面

| 文件路径 | 说明 |
|----------|------|
| `src/views/finance/receivable/index.vue` | 应收账款页面 |
| `src/views/finance/payable/index.vue` | 应付账款页面 |
| `src/views/finance/receipt/index.vue` | 收款单页面 |
| `src/views/finance/payment/index.vue` | 付款单页面 |
| `src/views/finance/account/index.vue` | 账户管理页面 |

---

## 三、数据库表

### 3.1 系统管理模块

| 表名 | 说明 | 状态 |
|------|------|------|
| sys_user | 用户表 | ✅ 已创建 |
| sys_role | 角色表 | ✅ 已创建 |
| sys_menu | 菜单表 | ✅ 已创建 |
| sys_dept | 部门表 | ✅ 已创建 |
| sys_post | 岗位表 | ✅ 已创建 |
| sys_user_role | 用户角色关联表 | ✅ 已创建 |
| sys_role_menu | 角色菜单关联表 | ✅ 已创建 |
| oa_process_def | 流程定义表 | ✅ 已创建 |
| oa_process_node | 流程节点表 | ✅ 已创建 |
| oa_task | 任务表 | ✅ 已创建 |
| oa_approver | 审批人配置表 | ✅ 已创建 |
| sys_message | 系统消息表 | ✅ 已创建 |

### 3.2 基础数据模块

| 表名 | 说明 | 状态 |
|------|------|------|
| base_customer | 客户表 | ✅ 已创建 |
| base_supplier | 供应商表 | ✅ 已创建 |
| base_material | 物料表 | ✅ 已创建 |
| base_warehouse | 仓库表 | ✅ 已创建 |
| base_unit | 单位表 | ✅ 已创建 |
| base_customer_address | 客户地址表 | ✅ 已创建 |
| base_customer_contact | 客户联系人表 | ✅ 已创建 |
| base_supplier_contact | 供应商联系人表 | ✅ 已创建 |
| base_warehouse_area | 库区表 | ✅ 已创建 |
| base_warehouse_location | 库位表 | ✅ 已创建 |

### 3.3 业务模块

| 表名 | 说明 | 状态 |
|------|------|------|
| sal_order | 销售订单表 | ✅ 已创建 |
| sal_order_item | 销售订单明细表 | ✅ 已创建 |
| sal_outbound | 销售出库表 | ✅ 已创建 |
| sal_outbound_item | 销售出库明细表 | ✅ 已创建 |
| sal_return | 销售退货表 | ✅ 已创建 |
| sal_return_item | 销售退货明细表 | ✅ 已创建 |
| pur_order | 采购订单表 | ✅ 已创建 |
| pur_order_item | 采购订单明细表 | ✅ 已创建 |
| pur_receipt | 采购入库表 | ✅ 已创建 |
| pur_receipt_item | 采购入库明细表 | ✅ 已创建 |
| pur_return | 采购退货表 | ✅ 已创建 |
| pur_return_item | 采购退货明细表 | ✅ 已创建 |
| inv_stock | 库存表 | ✅ 已创建 |
| inv_stock_flow | 库存流水表 | ✅ 已创建 |

### 3.4 财务模块

| 表名 | 说明 | 状态 |
|------|------|------|
| fin_account | 账户表 | ✅ 已创建 |
| fin_account_flow | 资金流水表 | ✅ 已创建 |
| fin_receivable | 应收账款表 | ✅ 已创建 |
| fin_payable | 应付账款表 | ✅ 已创建 |
| fin_receipt | 收款单表 | ✅ 已创建 |
| fin_receipt_item | 收款单明细表 | ✅ 已创建 |
| fin_payment | 付款单表 | ✅ 已创建 |
| fin_payment_item | 付款单明细表 | ✅ 已创建 |

### 3.5 默认数据

- 管理员账号：`admin` / `admin123`
- 超级管理员角色
- 系统管理菜单完整配置
- 基础数据演示数据

---

## 四、API接口清单

### 4.1 认证接口

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | /api/auth/login | 用户登录 |
| POST | /api/auth/logout | 用户登出 |
| GET | /api/auth/profile | 获取当前用户信息 |

### 4.2 系统管理接口

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | /api/system/user/page | 分页查询用户列表 |
| GET | /api/system/user/{id} | 获取用户详情 |
| POST | /api/system/user | 新增用户 |
| PUT | /api/system/user | 更新用户 |
| DELETE | /api/system/user/{id} | 删除用户 |
| PUT | /api/system/user/assignRoles | 分配用户角色 |
| PUT | /api/system/user/resetPassword | 重置密码 |
| GET | /api/system/role/page | 分页查询角色列表 |
| POST | /api/system/role | 新增角色 |
| PUT | /api/system/role | 更新角色 |
| DELETE | /api/system/role/{id} | 删除角色 |
| PUT | /api/system/role/assignMenus | 分配角色菜单 |
| GET | /api/system/menu/tree | 获取菜单树 |
| GET | /api/system/menu/{id} | 获取菜单详情 |
| POST | /api/system/menu | 新增菜单 |
| PUT | /api/system/menu | 更新菜单 |
| DELETE | /api/system/menu/{id} | 删除菜单 |
| GET | /api/system/dept/tree | 获取部门树 |
| POST | /api/system/dept | 新增部门 |
| PUT | /api/system/dept | 更新部门 |
| DELETE | /api/system/dept/{id} | 删除部门 |
| GET | /api/system/post/page | 分页查询岗位列表 |
| POST | /api/system/post | 新增岗位 |
| PUT | /api/system/post | 更新岗位 |
| DELETE | /api/system/post/{id} | 删除岗位 |

### 4.3 基础数据接口

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | /api/base/customer/page | 分页查询客户列表 |
| GET | /api/base/customer/{id} | 获取客户详情 |
| POST | /api/base/customer | 新增客户 |
| PUT | /api/base/customer | 更新客户 |
| DELETE | /api/base/customer/{id} | 删除客户 |
| GET | /api/base/supplier/page | 分页查询供应商列表 |
| GET | /api/base/supplier/{id} | 获取供应商详情 |
| POST | /api/base/supplier | 新增供应商 |
| PUT | /api/base/supplier | 更新供应商 |
| DELETE | /api/base/supplier/{id} | 删除供应商 |
| GET | /api/base/material/page | 分页查询物料列表 |
| GET | /api/base/material/{id} | 获取物料详情 |
| POST | /api/base/material | 新增物料 |
| PUT | /api/base/material | 更新物料 |
| DELETE | /api/base/material/{id} | 删除物料 |
| GET | /api/base/warehouse/page | 分页查询仓库列表 |
| GET | /api/base/warehouse/{id} | 获取仓库详情 |
| POST | /api/base/warehouse | 新增仓库 |
| PUT | /api/base/warehouse | 更新仓库 |
| DELETE | /api/base/warehouse/{id} | 删除仓库 |
| GET | /api/base/unit/page | 分页查询单位列表 |
| GET | /api/base/unit/{id} | 获取单位详情 |
| POST | /api/base/unit | 新增单位 |
| PUT | /api/base/unit | 更新单位 |
| DELETE | /api/base/unit/{id} | 删除单位 |

### 4.4 销售模块接口

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | /api/sales/order/page | 分页查询销售订单列表 |
| GET | /api/sales/order/{id} | 获取销售订单详情 |
| POST | /api/sales/order | 新增销售订单 |
| PUT | /api/sales/order | 更新销售订单 |
| DELETE | /api/sales/order/{id} | 删除销售订单 |
| POST | /api/sales/order/submit | 提交销售订单 |
| GET | /api/sales/outbound/page | 分页查询销售出库列表 |
| GET | /api/sales/outbound/{id} | 获取销售出库详情 |
| POST | /api/sales/outbound | 新增销售出库 |
| PUT | /api/sales/outbound | 更新销售出库 |
| DELETE | /api/sales/outbound/{id} | 删除销售出库 |
| GET | /api/sales/return/page | 分页查询销售退货列表 |
| GET | /api/sales/return/{id} | 获取销售退货详情 |
| POST | /api/sales/return | 新增销售退货 |
| PUT | /api/sales/return | 更新销售退货 |
| DELETE | /api/sales/return/{id} | 删除销售退货 |

### 4.5 采购模块接口

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | /api/purchase/order/page | 分页查询采购订单列表 |
| GET | /api/purchase/order/{id} | 获取采购订单详情 |
| POST | /api/purchase/order | 新增采购订单 |
| PUT | /api/purchase/order | 更新采购订单 |
| DELETE | /api/purchase/order/{id} | 删除采购订单 |
| GET | /api/purchase/receipt/page | 分页查询采购入库列表 |
| GET | /api/purchase/receipt/{id} | 获取采购入库详情 |
| POST | /api/purchase/receipt | 新增采购入库 |
| PUT | /api/purchase/receipt | 更新采购入库 |
| DELETE | /api/purchase/receipt/{id} | 删除采购入库 |
| GET | /api/purchase/return/page | 分页查询采购退货列表 |
| GET | /api/purchase/return/{id} | 获取采购退货详情 |
| POST | /api/purchase/return | 新增采购退货 |
| PUT | /api/purchase/return | 更新采购退货 |
| DELETE | /api/purchase/return/{id} | 删除采购退货 |

### 4.6 库存模块接口

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | /api/inventory/stock/page | 分页查询库存列表 |
| GET | /api/inventory/stock/{id} | 获取库存详情 |
| GET | /api/inventory/stock/material/{materialId} | 根据物料查询库存 |
| GET | /api/inventory/flow/page | 分页查询库存流水列表 |
| GET | /api/inventory/flow/{id} | 获取库存流水详情 |

### 4.7 财务模块接口

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | /api/finance/account/page | 分页查询账户列表 |
| GET | /api/finance/account/{id} | 获取账户详情 |
| POST | /api/finance/account | 新增账户 |
| PUT | /api/finance/account | 更新账户 |
| DELETE | /api/finance/account/{id} | 删除账户 |
| GET | /api/finance/receivable/page | 分页查询应收账款列表 |
| GET | /api/finance/receivable/{id} | 获取应收账款详情 |
| GET | /api/finance/payable/page | 分页查询应付账款列表 |
| GET | /api/finance/payable/{id} | 获取应付账款详情 |
| GET | /api/finance/receipt/page | 分页查询收款单列表 |
| GET | /api/finance/receipt/{id} | 获取收款单详情 |
| POST | /api/finance/receipt | 新增收款单 |
| PUT | /api/finance/receipt | 更新收款单 |
| DELETE | /api/finance/receipt/{id} | 删除收款单 |
| GET | /api/finance/payment/page | 分页查询付款单列表 |
| GET | /api/finance/payment/{id} | 获取付款单详情 |
| POST | /api/finance/payment | 新增付款单 |
| PUT | /api/finance/payment | 更新付款单 |
| DELETE | /api/finance/payment/{id} | 删除付款单 |

---

## 五、后续开发计划

### 5.1 第一阶段：基础框架（已完成）

- [x] Maven项目配置
- [x] Spring Boot基础配置
- [x] MyBatis Plus集成
- [x] 统一响应格式
- [x] 全局异常处理

### 5.2 第二阶段：系统管理（已完成）

- [x] 用户管理CRUD
- [x] 角色管理CRUD
- [x] 菜单管理CRUD
- [x] 部门管理CRUD
- [x] 岗位管理CRUD
- [x] 登录认证JWT
- [x] 权限控制
- [x] 审批流程
- [x] 消息通知

### 5.3 第三阶段：基础数据（已完成）

- [x] 客户管理
- [x] 供应商管理
- [x] 物料管理
- [x] 仓库管理
- [x] 单位管理
- [x] 客户地址管理
- [x] 客户联系人管理
- [x] 供应商联系人管理
- [x] 库区管理
- [x] 库位管理

### 5.4 第四阶段：业务模块（已完成）

- [x] 销售订单管理
- [x] 销售出库管理
- [x] 销售退货管理
- [x] 采购订单管理
- [x] 采购入库管理
- [x] 采购退货管理
- [x] 库存查询
- [x] 库存流水

### 5.5 第五阶段：财务模块（已完成）

- [x] 账户管理
- [x] 应收账款管理
- [x] 应付账款管理
- [x] 收款管理
- [x] 付款管理
- [x] 资金流水

### 5.6 第六阶段：前端开发（已完成）

- [x] 项目初始化（Vue 3 + Vite + Element Plus）
- [x] 基础框架搭建（Pinia状态管理、Vue Router路由、Axios封装）
- [x] 登录页面（登录/登出、Token管理、路由守卫）
- [x] 系统管理页面（用户、角色、菜单、部门）
- [x] 基础数据页面（客户、供应商、物料、仓库）
- [x] 销售管理页面（销售订单、销售出库、销售退货）
- [x] 采购管理页面（采购订单、采购入库、采购退货）
- [x] 财务模块页面（应收账款、应付账款、收款单、付款单、账户）

### 5.7 第七阶段：功能完善（待开发）

- [ ] 数据权限控制
- [ ] 操作日志记录
- [ ] 文件上传下载
- [ ] 数据导入导出
- [ ] 报表统计
- [ ] 性能优化
- [ ] 安全加固

---

## 六、注意事项

1. ⚠️ 每次功能开发完成后必须更新本文档
2. ⚠️ 重要数据及时提交Git备份
3. 开发前先阅读 `docs/ERP开发指南.md`
4. 所有后端代码遵循RESTful API设计规范
5. 数据库操作使用软删除（deleted字段）
6. 涉及金额字段使用Decimal类型，避免精度丢失
7. 时间字段统一使用DATETIME类型
8. 前端开发完成后需同步更新接口文档