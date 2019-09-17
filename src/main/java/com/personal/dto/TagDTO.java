package com.personal.dto;

import lombok.Data;

import java.util.List;

/**
 * @Auther: Chen
 * @Data: 2019/9/15
 * @Description: com.personal.dto
 * @Version: 1.0.0
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
