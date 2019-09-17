package com.personal.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.personal.entity.User;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Chen
 * @Data: 2019/9/14
 * @Description: com.personal.vo
 * @Version: 1.0.0
 */
@Data
public class CommentVO {
    private Integer id;

    private Integer parentId;

    private Integer type;

    private Integer commentor;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    private Integer likeCount;

    private Integer commentCount;

    private String content;
    
    private User user;

}
