package com.serein.wordbook.common;

/**
 * @Author 王强
 * @Date 2023/11/16 20:55
 * @Description 响应状态码枚举
 */
public enum ResponseCodeEnum {
    /**
     * 请求成功
     */
    SUCCESS(200, "请求成功"),
    /**
     * 请求失败
     */
    FAILURE(500, "请求失败"),

    /**
     * 请求失败
     */
    UNAUTHORIZED(501, "无访问权限");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 提示信息
     */
    private final String message;

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }

}
