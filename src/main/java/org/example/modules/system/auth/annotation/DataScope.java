package org.example.modules.system.auth.annotation;

import java.lang.annotation.*;

/**
 * 数据权限注解
 * 标记在Controller方法上，控制数据权限范围
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {

    /**
     * 数据范围类型
     * 1=全部数据权限
     * 2=自定数据权限
     * 3=本部门数据权限
     * 4=本部门及以下数据权限
     * 5=仅本人数据权限
     */
    int value() default 1;

    /**
     * 自定义部门ID（当value=2时使用）
     * 支持SpEL表达式，如：#{#role.deptId}
     */
    String deptId() default "";

    /**
     * 部门别名（用于SQL中的表别名）
     */
    String deptAlias() default "";

    /**
     * 是否排除创建人
     * 当为true时，会额外排除用户创建的数据
     */
    boolean excludeCreator() default false;
}