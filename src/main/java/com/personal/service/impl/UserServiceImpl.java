package com.personal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.personal.dto.GithubUser;
import com.personal.entity.Question;
import com.personal.entity.User;
import com.personal.mapper.QuestionMapper;
import com.personal.mapper.UserMapper;
import com.personal.service.UserService;
import com.personal.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.service.impl
 * @Version: 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    PageHelper pageHelper;

    @Override
    public User findOneByToken(String token) {
        return userMapper.findOneByToken(token);
    }


    @Override
    public User findOneByName(String name) {
        return userMapper.findOneByName(name);
    }

    @Override
    public UserVO getUserWithAllQuestion(Integer id, Integer currentPage, Integer size) {

        UserVO userVO = new UserVO();

        User user = userMapper.findOneById(id);

        BeanUtils.copyProperties(user, userVO);

        pageHelper.startPage(currentPage, size);

        List<Question> questions = questionMapper.getQuestionByCreator(user.getId());

        PageInfo pageInfo = new PageInfo(questions);

        userVO.setPageInfo(pageInfo);


        return userVO;
    }

    /**
     * 通过AccountId查询数据的用户信息，存在则返回数据，不存在则返回null
     *
     * @param user
     * @return
     */
    @Override
    public User checkUser(GithubUser user) {

        User dbUser = userMapper.findOneByAccountId(user.getId() + "");

        if (null != dbUser) {
            //GitHub的用户数据和数据库用户一样则返回数据库用户信息,不一样则更新数据
            if ((user.getLogin()).equals(dbUser.getName()) &&
                    (user.getAvatar_url()).equals(dbUser.getAvatarUrl()) &&
                    (user.getId() + "").equals(dbUser.getAccountId())) {
                return dbUser;
            }

            //插入成功返回新的用户信息
            boolean result = userMapper.updateUser(new User().
                    setAccountId(user.getId() + "").
                    setAvatarUrl(user.getAvatar_url()).
                    setName(user.getLogin()).
                    setToken(UUID.randomUUID().toString()));

            if (result) {
                User newUser = userMapper.findOneByAccountId(user.getId() + "");
                return newUser;
            }
        }
        return null;
    }

    @Override
    public boolean insertUser(User user) {
        return userMapper.insertUser(user);
    }

}
