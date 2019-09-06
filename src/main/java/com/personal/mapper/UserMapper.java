package com.personal.mapper;

import com.personal.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.mapper
 * @Version: 1.0.0
 */
public interface UserMapper {

    @Select("select id,account_id,name,token,create_time from user where token=#{token}")
    User findOneByToken(String token);

    @Insert("insert into user(account_id, name, token) values(#{accountId},#{name},#{token})")
    boolean insertUser(User user);

}
