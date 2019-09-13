package com.personal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Chen
 * @Data: 2019/9/12
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
public class LogOutController {

    /**
     * 退出登录，移除session和cookie
     * @param request
     * @return
     */
    @GetMapping("/logOut")
    public String logOut(HttpServletRequest request, HttpServletResponse response){

        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("userId");

        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }
}
