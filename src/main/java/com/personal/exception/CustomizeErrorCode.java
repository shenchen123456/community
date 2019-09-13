package com.personal.exception;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.exception
 * @Version: 1.0.0
 */
public enum  CustomizeErrorCode {
    QUESTION_NOT_FOUND("你找的问题不存在,要不要换个试试"),
    QUESTION_NOT_MODIFY("该问题未做任何修改");


    CustomizeErrorCode(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
