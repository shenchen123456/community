package com.personal.service;

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

    User findOneByAccountId(String accountId);

    User findOneByName(String name);


    UserVO findOneByIdWithQuestion(Integer id);
}
