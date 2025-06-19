package com.mhl.t3.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JSendResponse<T>{

    private String status; // "success", "fail", "error"
    private T data;
    private String message;
    private Integer code;

    public static <T> JSendResponse<T> success(T data) {
        return new JSendResponse<>("success", data, null, null);
    }

    public static <T> JSendResponse<T> fail(T data, String message) {
        return new JSendResponse<>("fail", data, message, null);
    }

    public static <T> JSendResponse<T> error(String message, Integer code) {
        return new JSendResponse<>("error", null, message, code);
    }
}
