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
    NOT_LOGIN(2004,"当前操作需要登录,请先登录"),
    SYSTEM_ERROR(2005,"服务器冒烟了，要不稍后再试试?"),
    TYPE_PARAM_WRONG(2006,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2007,"回复的评论不存在,要不换个试试?" ),
    CONTENT_NOT_BE_EMPTY(2008,"评论不能为空" ),
    TITLE_NOT_BE_EMPTY(2009,"标题不能为空" ),
    DESCRIPTION_NOT_BE_EMPTY(2010,"问题补充不能为空" ),
    TAG_NOT_BE_EMPTY(2011,"标签不能为空" ),
    NOTIFICATION_NOT_FOUND(2012,"通知没找到,要不要换个试试" ),
    NOTIFICATION_TYPE_ERROR(2013,"通知类型错误" );
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
