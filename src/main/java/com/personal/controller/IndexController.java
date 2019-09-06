package com.personal.controller;

import com.personal.entity.User;
import com.personal.provider.CookieProvider;
import com.personal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Chen
 * @Data: 2019/9/5
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    CookieProvider cookieProvider;

    @GetMapping("/")
    public String hello(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();

        User user = cookieProvider.getUserByToken(cookies);

        if (null !=user){
            httpServletRequest.getSession().setAttribute("username",user.getAccountId());
        }

        return "index";
    }
}
