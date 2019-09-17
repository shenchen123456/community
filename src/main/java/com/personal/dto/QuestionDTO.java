package com.personal.dto;

import lombok.Data;

/**
 * @Auther: Chen
 * @Data: 2019/9/14
 * @Description: com.personal.dto
 * @Version: 1.0.0
 */
@Data
public class QuestionDTO {

    private Integer id;

    private String title;

    private String description;

    private String tag;
}
