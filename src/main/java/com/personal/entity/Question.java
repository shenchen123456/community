package com.personal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.entity
 * @Version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class Question {

    private Integer id;

    private String title;

    private String description;

    private Integer creator;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    private Integer viewCount;

    private Integer likeCount;

    private Integer commentCount;

    private String tag;
}
