package com.personal.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private Integer id;

    private Integer parentId;

    private Integer type;

    private Integer commentor;

    private Date createTime;

    private Date updateTime;

    private Integer likeCount;

    private String content;

    public Comment() {
    }
}