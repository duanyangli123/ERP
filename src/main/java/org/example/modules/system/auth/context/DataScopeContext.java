package org.example.modules.system.auth.context;

import org.example.modules.system.auth.enums.DataScopeType;

import java.util.HashSet;
import java.util.Set;

/**
 * 数据权限上下文
 * 用于在当前请求线程中存储数据权限信息
 */
public class DataScopeContext {

    private static final ThreadLocal<DataScopeHolder> HOLDER = new ThreadLocal<>();

    /**
     * 设置数据权限
     */
    public static void setDataScope(DataScopeType type, Set<Long> deptIds, String deptAlias) {
        DataScopeHolder holder = new DataScopeHolder();
        holder.setType(type);
        holder.setDeptIds(deptIds);
        holder.setDeptAlias(deptAlias);
        holder.setExcludeCreator(false);
        HOLDER.set(holder);
    }

    /**
     * 设置数据权限（包含是否排除创建人）
     */
    public static void setDataScope(DataScopeType type, Set<Long> deptIds, String deptAlias, boolean excludeCreator) {
        DataScopeHolder holder = new DataScopeHolder();
        holder.setType(type);
        holder.setDeptIds(deptIds);
        holder.setDeptAlias(deptAlias);
        holder.setExcludeCreator(excludeCreator);
        HOLDER.set(holder);
    }

    /**
     * 获取数据权限类型
     */
    public static DataScopeType getType() {
        DataScopeHolder holder = HOLDER.get();
        return holder != null ? holder.getType() : DataScopeType.ALL;
    }

    /**
     * 获取部门ID集合
     */
    public static Set<Long> getDeptIds() {
        DataScopeHolder holder = HOLDER.get();
        return holder != null ? holder.getDeptIds() : new HashSet<>();
    }

    /**
     * 获取部门别名
     */
    public static String getDeptAlias() {
        DataScopeHolder holder = HOLDER.get();
        return holder != null ? holder.getDeptAlias() : "";
    }

    /**
     * 是否排除创建人
     */
    public static boolean isExcludeCreator() {
        DataScopeHolder holder = HOLDER.get();
        return holder != null && holder.isExcludeCreator();
    }

    /**
     * 清除数据权限
     */
    public static void clear() {
        HOLDER.remove();
    }

    /**
     * 数据权限持有者
     */
    public static class DataScopeHolder {
        private DataScopeType type;
        private Set<Long> deptIds;
        private String deptAlias;
        private boolean excludeCreator;

        public DataScopeType getType() {
            return type;
        }

        public void setType(DataScopeType type) {
            this.type = type;
        }

        public Set<Long> getDeptIds() {
            return deptIds;
        }

        public void setDeptIds(Set<Long> deptIds) {
            this.deptIds = deptIds;
        }

        public String getDeptAlias() {
            return deptAlias;
        }

        public void setDeptAlias(String deptAlias) {
            this.deptAlias = deptAlias;
        }

        public boolean isExcludeCreator() {
            return excludeCreator;
        }

        public void setExcludeCreator(boolean excludeCreator) {
            this.excludeCreator = excludeCreator;
        }
    }
}