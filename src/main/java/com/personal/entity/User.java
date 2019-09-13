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
public class User {

    private Integer id;

    private String accountId;

    private String name;

    private String token;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    private String avatarUrl;
}
