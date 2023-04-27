package com.example.demo17.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chaonianye
 * @description
 * @date 2023/4/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Object data;
    private Meta meta;

    public static Result ok(Object data) {
        return new Result(data, new Meta(null, 200));
    }

    public static Result ok(Object data, String msg) {
        return new Result(data, new Meta(msg, 200));
    }

    public static Result fail(Object data, String msg, Integer status) {
        return new Result(data, new Meta(msg, status));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Meta {
    private String msg;
    private Integer status;
}
