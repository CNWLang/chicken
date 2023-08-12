package com.example.chicken.rs.util;

import lombok.Data;

@Data
public class Result<T> {
    private boolean code;
    private String message;
    private T data;

    public Result() {
    }

    //封装静态方法  -- 成功！
    public static <T> Result<T> success(T data, String message){
        Result<T> result = new Result<>();
        result.setCode(true);
        result.setData(data);
        result.setMessage(message);
        return result;
    }
    //封装静态方法  -- 失败
    public static <T> Result<T> error(String message){
        Result<T> result = new Result<>();
        result.setCode(false);
        result.setMessage(message);
        return result;
    }

}
