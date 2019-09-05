package com.personal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Chen
 * @Data: 2019/9/5
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String hello(){
        return "index";
    }
}
