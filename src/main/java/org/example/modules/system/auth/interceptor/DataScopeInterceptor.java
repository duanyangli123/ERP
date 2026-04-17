package org.example.modules.system.auth.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.ResultHandler;
import org.example.modules.system.auth.context.DataScopeContext;
import org.example.modules.system.auth.enums.DataScopeType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;
import java.lang.reflect.Field;

/**
 * 数据权限拦截器
 * 在查询时自动注入数据权限过滤条件
 */
@Component
@Intercepts({
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
    @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class DataScopeInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];

        // 只处理查询操作
        if (ms.getSqlCommandType() != SqlCommandType.SELECT) {
            return invocation.proceed();
        }

        // 获取数据权限类型
        DataScopeType dataScopeType = DataScopeContext.getType();
        if (dataScopeType == null) {
            dataScopeType = DataScopeType.ALL;
        }

        // 全部数据权限，直接放行
        if (dataScopeType == DataScopeType.ALL) {
            return invocation.proceed();
        }

        // 获取部门ID集合
        Set<Long> deptIds = DataScopeContext.getDeptIds();
        String deptAlias = DataScopeContext.getDeptAlias();

        // 构建数据权限SQL条件
        String dataScopeSql = buildDataScopeSql(dataScopeType, deptIds, deptAlias);
        if (!StringUtils.hasText(dataScopeSql)) {
            return invocation.proceed();
        }

        // 修改SQL添加数据权限条件
        BoundSql boundSql = ms.getBoundSql(parameter);
        String originalSql = boundSql.getSql();
        String modifiedSql = addDataScopeCondition(originalSql, dataScopeSql);

        // 使用反射修改BoundSql
        Field sqlField = BoundSql.class.getDeclaredField("sql");
        sqlField.setAccessible(true);
        sqlField.set(boundSql, modifiedSql);

        return invocation.proceed();
    }

    /**
     * 构建数据权限SQL条件
     */
    private String buildDataScopeSql(DataScopeType type, Set<Long> deptIds, String deptAlias) {
        StringBuilder sql = new StringBuilder();

        switch (type) {
            case ALL:
                return "";
            case SELF:
                // 仅看本人创建的数据
                sql.append(" AND create_by = #{dataScopeParams.creator}");
                break;
            case DEPT:
                // 本部门数据
                if (deptIds != null && !deptIds.isEmpty()) {
                    sql.append(" AND ").append(deptAlias).append(".dept_id IN (#{dataScopeParams.deptIds})");
                }
                break;
            case DEPT_AND_CHILD:
                // 本部门及以下数据
                if (deptIds != null && !deptIds.isEmpty()) {
                    sql.append(" AND ").append(deptAlias).append(".dept_id IN (#{dataScopeParams.deptIds})");
                }
                break;
            case CUSTOM:
                // 自定义数据权限
                if (deptIds != null && !deptIds.isEmpty()) {
                    sql.append(" AND ").append(deptAlias).append(".dept_id IN (#{dataScopeParams.deptIds})");
                }
                break;
            default:
                return "";
        }

        return sql.toString();
    }

    /**
     * 添加数据权限条件到SQL
     */
    private String addDataScopeCondition(String originalSql, String dataScopeSql) {
        // 简单实现：在WHERE后添加条件
        // 实际项目中需要更复杂的SQL解析
        if (originalSql.toUpperCase().contains("WHERE")) {
            return originalSql + dataScopeSql;
        } else if (originalSql.toUpperCase().contains("ORDER BY")) {
            int orderIndex = originalSql.toUpperCase().indexOf("ORDER BY");
            return originalSql.substring(0, orderIndex) + " WHERE 1=1 " + dataScopeSql + " " + originalSql.substring(orderIndex);
        } else {
            return originalSql + " WHERE 1=1 " + dataScopeSql;
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        // 可以在这里读取配置
    }

    /**
     * 数据权限参数（用于SQL注入）
     */
    public static class DataScopeParams {
        private Long creator;
        private Set<Long> deptIds;

        public Long getCreator() {
            return creator;
        }

        public void setCreator(Long creator) {
            this.creator = creator;
        }

        public Set<Long> getDeptIds() {
            return deptIds;
        }

        public void setDeptIds(Set<Long> deptIds) {
            this.deptIds = deptIds;
        }
    }
}