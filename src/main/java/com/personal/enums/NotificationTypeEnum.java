package com.personal.enums;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.enums
 * @Version: 1.0.0
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);

    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType() == type){
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }
}
