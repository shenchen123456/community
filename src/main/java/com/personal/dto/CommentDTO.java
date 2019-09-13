package com.personal.dto;

import lombok.Data;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.dto
 * @Version: 1.0.0
 */
@Data
public class CommentDTO {

    private Integer parentId;
    private String content;
    private Integer type;
}
