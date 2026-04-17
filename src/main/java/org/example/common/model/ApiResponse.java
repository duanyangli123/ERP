package org.example.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一API响应结果
 */
@Data
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 成功状态码
     */
    public static final int SUCCESS_CODE = 200;
    
    /**
     * 失败状态码
     */
    public static final int ERROR_CODE = 500;

    public ApiResponse() {
    }

    public ApiResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功响应（无数据）
     */
    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(SUCCESS_CODE, "操作成功", null);
    }

    /**
     * 成功响应（带数据）
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(SUCCESS_CODE, "操作成功", data);
    }

    /**
     * 成功响应（带消息和数据）
     */
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(SUCCESS_CODE, message, data);
    }

    /**
     * 失败响应
     */
    public static <T> ApiResponse<T> error() {
        return new ApiResponse<>(ERROR_CODE, "操作失败", null);
    }

    /**
     * 失败响应（带消息）
     */
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(ERROR_CODE, message, null);
    }

    /**
     * 失败响应（带状态码和消息）
     */
    public static <T> ApiResponse<T> error(Integer code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    /**
     * 失败响应（快捷方法）
     */
    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<>(ERROR_CODE, message, null);
    }

    /**
     * 判断是否成功
     */
    public boolean isSuccess() {
        return SUCCESS_CODE == this.code;
    }
}
