package com.personal.mapper;

import com.personal.entity.Question;
import org.apache.ibatis.annotations.Insert;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.entity
 * @Version: 1.0.0
 */
public interface QuestionMapper {

    @Insert("insert into question(title, description, creator, tag) values(#{title},#{description},#{creator},#{tag})")
    boolean insertQuestion(Question question);
}
