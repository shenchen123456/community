package com.personal.dto;

import com.personal.exception.CustomizeException;
import com.personal.exception.ICustomizeErrorEnum;
import lombok.Data;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.dto
 * @Version: 1.0.0
 */
@Data
public class MessageDTO {

    private int code;
    private String message;

    public MessageDTO(int code, String message) {
        this.code = code;
        this.message = message;
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
}
