package com.personal.mapper;

import com.personal.entity.Question;
import com.personal.entity.QuestionExample;
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

    //XML
    long countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    //注解
    @Insert("insert into question(title, description, creator, tag) values(#{title},#{description},#{creator},#{tag})")
    boolean insertQuestion(Question question);

    @Select("Select id,title,description,creator,create_time,update_time,comment_count,view_count,like_count,tag from question")
    @Results( id = "BASE_QUESTION_USER",value = {
            @Result(column = "id", id = true, property = "id"),
            @Result(column = "title", property = "title"),
            @Result(column = "description",property = "description"),
            @Result(column = "creator",property = "creator"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime"),
            @Result(column = "comment_count",property = "commentCount"),
            @Result(column = "view_count",property = "viewCount"),
            @Result(column = "like_count",property = "likeCount"),
            @Result(column = "tag",property = "tag"),
            @Result(column = "creator",property = "user",one = @One(select = "com.personal.mapper.UserMapper.findOneById",fetchType = FetchType.EAGER))
    })
    List<QuestionVO> getAllQuestionWithUser();

    @Select("Select id,title,description,creator,create_time,update_time,comment_count,view_count,like_count,tag from question where creator=#{creator}")
    List<Question> getQuestionByCreator(Integer creator);

    @Select("Select id,title,description,creator,create_time,update_time,comment_count,view_count,like_count,tag from question where id=#{id}")
    @ResultMap(value = "BASE_QUESTION_USER")
    QuestionVO findOneQuestionByIdWithUser(Integer id);

    @Select("Select id,title,description,creator,create_time,update_time,comment_count,view_count,like_count,tag from question where id=#{id}")
    Question findOneById(Integer id);

    @Update("Update question set title=#{title},description=#{description},tag=#{tag} where id=#{id}")
    boolean updateQuestion(Question question);
}
