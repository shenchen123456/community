package com.personal.exception;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.exception
 * @Version: 1.0.0
 */
public enum CustomizeErrorEnum implements ICustomizeErrorEnum{
    QUESTION_NOT_FOUND(2001,"你找的问题不存在,要不要换个试试"),
    QUESTION_NOT_MODIFY(2002,"该问题未做任何修改"),
    TARGET_PARAM_NOT_FOUND(2003,"未选中任何问题或评论进行回复"),
    NOT_LOGIN(2003,"当前操作需要登录,请先登录"),
    SYSTEM_ERROR(2004,"服务器冒烟了，要不稍后再试试?"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在，要不换个试试?" );
    private Integer code;
    private String message;

    CustomizeErrorEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
