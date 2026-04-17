package org.example.modules.system.auth.enums;

/**
 * 数据权限类型枚举
 */
public enum DataScopeType {

    /**
     * 全部数据权限
     */
    ALL(1, "全部数据权限"),

    /**
     * 自定数据权限
     */
    CUSTOM(2, "自定数据权限"),

    /**
     * 本部门数据权限
     */
    DEPT(3, "本部门数据权限"),

    /**
     * 本部门及以下数据权限
     */
    DEPT_AND_CHILD(4, "本部门及以下数据权限"),

    /**
     * 仅本人数据权限
     */
    SELF(5, "仅本人数据权限");

    private final int code;
    private final String description;

    DataScopeType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static DataScopeType fromCode(int code) {
        for (DataScopeType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        return ALL;
    }
}