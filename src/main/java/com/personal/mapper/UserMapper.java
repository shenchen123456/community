package com.personal.mapper;

import com.personal.entity.User;
import com.personal.vo.UserVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.mapper
 * @Version: 1.0.0
 */
public interface UserMapper {

    @Select("select id,account_id,name,token,create_time,avatar_url from user where token=#{token}")
    User findOneByToken(String token);

    @Select("select id,account_id,name,token,create_time,avatar_url from user where name=#{name}")
    User findOneByName(String name);

    @Select("select id,account_id,name,token,create_time,avatar_url from user where id=#{id}")
    User findOneById(Integer id);

    @Select("select id,account_id,name,token,create_time,avatar_url from user where account_id=#{accountId}")
    User findOneByAccountId(String accountId);

    @Select("select id,name,avatar_url from user where id=#{id}")
    @Results({
            @Result(column = "id",property = "id", id = true),
            @Result(column = "name",property = "name"),
            @Result(column = "avatar_url",property = "avatarUrl"),
            @Result(column = "id",property = "questions",
                    many = @Many(select = "com.personal.mapper.UserMapper.getQuestionByCreator",fetchType = FetchType.LAZY))
    })
    UserVO findOneByIdWithQuestion(Integer id);

    @Insert("insert into user(account_id, name, token,avatar_url) values(#{accountId},#{name},#{token},#{avatarUrl})")
    boolean insertUser(User user);
}
