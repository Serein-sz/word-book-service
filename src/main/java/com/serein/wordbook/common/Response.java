package com.serein.wordbook.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 王强
 * @Date 2023/11/16 20:54
 * @Description 通用返回类
 */
@Data
public class Response<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public Response() {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
    }



    public Response(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> Response<T> ok() {
        return new Response<>(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage());
    }


    public static <T> Response<T> ok(T data) {
        return new Response<>(ResponseCodeEnum.SUCCESS.getCode(), data);
    }

    public static <T> Response<T> ok(String message, T data) {
        return new Response<>(ResponseCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> Response<T> ok(int code, T data) {
        return new Response<>(code, data);
    }

    public static <T> Response<T> ok(int code, String message, T data) {
        return new Response<>(code, message, data);
    }

    public static <T> Response<T> error() {
        return new Response<>(ResponseCodeEnum.FAILURE.getCode(), ResponseCodeEnum.FAILURE.getMessage());
    }

    public static <T> Response<T> error(String message) {
        return new Response<>(ResponseCodeEnum.FAILURE.getCode(), message);
    }

    public static <T> Response<T> error(ResponseCodeEnum responseCodeEnum) {
        return new Response<>(responseCodeEnum.getCode(), responseCodeEnum.getMessage());
    }

}
