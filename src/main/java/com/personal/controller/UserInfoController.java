package com.personal.controller;

import com.personal.dto.MessageDTO;
import com.personal.entity.Notification;
import com.personal.exception.CustomizeErrorEnum;
import com.personal.provider.UserLoginProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Chen
 * @Data: 2019/9/12
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
public class UserInfoController {

    @Autowired
    UserLoginProvider userLoginProvider;


    @GetMapping("/userInfo/{action}")
    public String userInfo(HttpServletRequest request,
                           @PathVariable("action")String action,
                           Model model){

        String username = (String) request.getSession().getAttribute("username");
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        boolean result = userLoginProvider.checkUserIsLogin(username,userId);

        if (result == false){
            return "redirect:/";
        }

        if ("question".equals(action)) {
            model.addAttribute("section","question");
            model.addAttribute("sectionName","我的提问");
        }else if ("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }
        return "userInfo";
    }
}
