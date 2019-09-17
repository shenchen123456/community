package com.personal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.dto
 * @Version: 1.0.0
 */
@Data
public class CommentDTO {

    private Integer parentId;

    @NotBlank (message = "评论不能为空")
    private String content;

    private Integer type;
}
