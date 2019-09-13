package com.personal.exception;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.exception
 * @Version: 1.0.0
 */
public class CustomizeException extends RuntimeException{

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public CustomizeException(ICustomizeErrorEnum iCustomizeErrorEnum){
        this.code = iCustomizeErrorEnum.getCode();
        this.message = iCustomizeErrorEnum.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

}
