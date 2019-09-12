package com.personal.controller;

import com.personal.entity.Question;
import com.personal.entity.User;
import com.personal.provider.CookieProvider;
import com.personal.service.QuestionService;
import com.personal.service.UserService;
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
    UserService userService;

    @GetMapping("/publish")
    public String publish(HttpServletRequest httpServletRequest) {

        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description" ,required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            HttpServletRequest httpServletRequest,
            Model model) {
        //后端校验标题，描述，标签不能为空
        if (null == title || "".equals(title)) {
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if (null == description || "".equals(description)) {
            model.addAttribute("error","描述不能为空");
            return "publish";
        }if (null == tag || "".equals(tag)) {
            model.addAttribute("error","标签不能为空");
            return "publish";
        }
        //后端校验用户是否登录
        String username = (String) httpServletRequest.getSession().getAttribute("username");

        if (null == username) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        User user = userService.findOneByName(username);


        questionService.insertQuestion(new Question()
                .setTitle(title)
                .setDescription(description)
                .setTag(tag)
                .setCreator(user.getId()));

        return "publish";
    }
}
