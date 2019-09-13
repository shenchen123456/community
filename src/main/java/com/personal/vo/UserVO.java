package com.personal.vo;

import com.github.pagehelper.PageInfo;
import com.personal.entity.Question;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.entity
 * @Version: 1.0.0
 */
@Data
public class UserVO {

    private Integer id;

    private String accountId;

    private String name;

    private String token;

    private Date createTime;

    private Date updateTime;

    private String avatarUrl;

    PageInfo pageInfo;
}
