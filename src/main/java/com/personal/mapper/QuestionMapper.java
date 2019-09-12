package com.personal.mapper;

import com.personal.entity.Question;
import com.personal.vo.QuestionVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.entity
 * @Version: 1.0.0
 */
public interface QuestionMapper {

    @Insert("insert into question(title, description, creator, tag) values(#{title},#{description},#{creator},#{tag})")
    boolean insertQuestion(Question question);

    @Select("Select id,title,description,creator,create_time,comment_count,view_count,like_count,tag from question")
    @Results({
            @Result(column = "id", id = true, property = "id"),
            @Result(column = "title", property = "title"),
            @Result(column = "description",property = "description"),
            @Result(column = "creator",property = "creator"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "comment_count",property = "commentCount"),
            @Result(column = "view_count",property = "viewCount"),
            @Result(column = "like_count",property = "likeCount"),
            @Result(column = "tag",property = "tag"),
            @Result(column = "creator",property = "user",one = @One(select = "com.personal.mapper.UserMapper.findOneById",fetchType = FetchType.EAGER))
    })
    List<QuestionVO> getQuestionsWithUser();

    @Select("Select id,title,description,creator,create_time,comment_count,view_count,like_count,tag from question where creator=#{creator}")
    List<Question> getQuestionByCreator(Integer creator);
}
