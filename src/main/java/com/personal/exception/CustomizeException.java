package com.personal.exception;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.exception
 * @Version: 1.0.0
 */
public class CustomizeException extends RuntimeException{

    private String message;

    public CustomizeException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public CustomizeException(CustomizeErrorCode message) {
        this.message = message.getMessage();
    }

}
