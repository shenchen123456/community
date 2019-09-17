package com.personal.enums;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.enums
 * @Version: 1.0.0
 */
public enum NotificationStatusEnum {
    UNREAD(0,"未读通知"),
    READ(1,"已读通知");

    private Integer status;
    private String message;

    NotificationStatusEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
