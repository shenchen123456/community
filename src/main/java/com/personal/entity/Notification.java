package com.personal.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Notification {
    private Integer id;

    private Integer notifier;

    private String notifierName;

    private String content;

    private Integer receiver;

    private Integer outerId;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    private Integer status;


}