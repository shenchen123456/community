package com.personal.entity;

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
    private Date createTime;
}
