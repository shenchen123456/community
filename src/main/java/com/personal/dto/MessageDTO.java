package com.personal.dto;

import com.personal.exception.CustomizeException;
import com.personal.exception.ICustomizeErrorEnum;
import lombok.Data;

import java.util.ArrayList;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.dto
 * @Version: 1.0.0
 */
@Data
public class MessageDTO<T> {

    private int code;
    private String message;
    private T data;

    private MessageDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private MessageDTO(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static MessageDTO errorOf(int code, String message) {
        return new MessageDTO(code,message);
    }

    public static MessageDTO errorOf(ICustomizeErrorEnum errorEnum) {
        return errorOf(errorEnum.getCode(),errorEnum.getMessage());
    }

    public static MessageDTO errorOf(CustomizeException e) {
        return errorOf(e.getCode(),e.getMessage());
    }

    public static MessageDTO successOf() {
        return new MessageDTO(200,"请求成功");
    }

    public static <T> MessageDTO successOf(T t) {
        return new MessageDTO(200,"请求成功",t);
    }
}
