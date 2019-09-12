package com.personal.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.personal.entity.Question;
import com.personal.entity.User;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Chen
 * @Data: 2019/9/8
 * @Description: com.personal.vo
 * @Version: 1.0.0
 */
@Data
public class QuestionVO {

    private Integer id;
    private String title;
    private String description;
    private Integer creator;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private User user;
}
