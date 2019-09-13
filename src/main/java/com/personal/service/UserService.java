package com.personal.service;

import com.personal.dto.GithubUser;
import com.personal.entity.User;
import com.personal.vo.UserVO;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.service
 * @Version: 1.0.0
 */
public interface UserService {

    boolean insertUser(User user);

    User findOneByToken(String token);

    User findOneByName(String name);

    UserVO getUserWithAllQuestion(Integer id,Integer currentPage,Integer size);

    User checkUser(GithubUser user);
}
