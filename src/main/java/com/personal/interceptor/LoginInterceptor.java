package com.personal.interceptor;

import com.personal.entity.User;
import com.personal.provider.CookieProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Chen
 * @Data: 2019/9/10
 * @Description: com.personal.intercepte
 * @Version: 1.0.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Autowired
    CookieProvider cookieProvider;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie[] cookies = request.getCookies();

        User user = cookieProvider.getUserByToken(cookies);

        if (null !=user){
            request.getSession().setAttribute("username",user.getName());
            request.getSession().setAttribute("userId",user.getId());
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
