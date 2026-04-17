package org.example.modules.system.auth.annotation;

import java.lang.annotation.*;

/**
 * 操作日志注解
 * 标记在Controller方法上，自动记录操作日志
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperLog {

    /**
     * 模块名称
     */
    String module() default "";

    /**
     * 操作类型：新增、修改、删除、查询、导入、导出、登录等
     */
    String operType() default "";

    /**
     * 操作描述
     */
    String description() default "";

    /**
     * 是否记录请求参数
     */
    boolean logParam() default true;

    /**
     * 是否记录返回结果
     */
    boolean logResult() default true;

    /**
     * 是否记录耗时
     */
    boolean logCostTime() default true;

    /**
     * 保存请求参数的字段
     * 用于排除敏感字段如密码
     */
    String[] excludeParamFields() default {};

    /**
     * 保存返回结果的字段
     * 用于排除敏感字段
     */
    String[] excludeResultFields() default {};
}