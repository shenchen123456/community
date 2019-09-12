package com.personal.vo;

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
    private String name;
    private String avatarUrl;
    List<Question> questions;
}
