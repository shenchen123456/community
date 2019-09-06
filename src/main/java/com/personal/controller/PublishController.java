package com.personal.controller;

import com.personal.entity.Question;
import com.personal.entity.User;
import com.personal.provider.CookieProvider;
import com.personal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
public class PublishController {

    @Autowired
    QuestionService questionService;

    @Autowired
    CookieProvider cookieProvider;

    @GetMapping("/publish")
    public String publish(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();

        User user = cookieProvider.getUserByToken(cookies);

        if (null != user) {
            httpServletRequest.getSession().setAttribute("username", user.getAccountId());
        }

        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest httpServletRequest,
            Model model) {
        Cookie[] cookies = httpServletRequest.getCookies();

        User user = cookieProvider.getUserByToken(cookies);

        if (null == user) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        questionService.insertQuestion(new Question()
                .setTitle(title)
                .setDescription(description)
                .setTag(tag)
                .setCreator(user.getId()));

        return "publish";
    }
}
