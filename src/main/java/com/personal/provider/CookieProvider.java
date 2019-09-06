package com.personal.provider;

import com.personal.entity.User;
import com.personal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.provider
 * @Version: 1.0.0
 */
@Component
public class CookieProvider {

    @Autowired
    UserService userService;

    /**
     * 获取token，并通过token拿到User信息
     * @param cookies
     * @return
     */
    public User getUserByToken(Cookie[] cookies){

        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    return userService.findOneByToken(cookie.getValue());
                }
            }
        }
        return null;
    }
}
