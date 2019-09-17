package com.personal.provider;

import com.personal.dto.MessageDTO;
import com.personal.entity.User;
import com.personal.exception.CustomizeErrorEnum;
import com.personal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Chen
 * @Data: 2019/9/14
 * @Description: com.personal.provider
 * @Version: 1.0.0
 */
@Component
public class UserLoginProvider {

    @Autowired
    UserService userService;

    /**
     * 校验用户是否登录
     * @return
     */
    public boolean checkUserIsLogin(String username,Integer userId) {

        if (null == username && null ==userId){
            return false;
        }

        User user = userService.findOneByNameAndId(username,userId);

        if (null == user) {
            return false;
        }

        return true;
    }
}
