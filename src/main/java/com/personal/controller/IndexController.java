package com.personal.controller;

import com.personal.entity.User;
import com.personal.provider.CookieProvider;
import com.personal.service.QuestionService;
import com.personal.service.UserService;
import com.personal.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: Chen
 * @Data: 2019/9/5
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
public class IndexController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
