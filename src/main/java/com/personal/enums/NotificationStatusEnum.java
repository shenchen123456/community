package com.personal.enums;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.enums
 * @Version: 1.0.0
 */
public enum NotificationTypeEnum {
    REPLY_QUESTION(1,"回复了问题"),
    REPLY_COMMENT(1,"回复了评论");

    private Integer type;
    private String message;

    NotificationTypeEnum(Integer type, String message) {
        this.type = type;
        this.message = message;
    }

    public Integer getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
