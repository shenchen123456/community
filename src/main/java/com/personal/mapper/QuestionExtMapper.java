package com.personal.mapper;

import com.personal.entity.Question;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.entity
 * @Version: 1.0.0
 */
public interface QuestionExtMapper {

    boolean incrementView (@Param("record")Question record);

    boolean incrementComment (@Param("record")Question record);
}
