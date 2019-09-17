package com.personal.controller;

import com.personal.service.UserService;
import com.personal.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Chen
 * @Data: 2019/9/12
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/questions")
    public UserVO getUserQuestion(HttpServletRequest request,
                                  @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                  @RequestParam(value = "size", defaultValue = "3") Integer size) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        //TODO
        //userId可能为空

        if (userId == null || userId == 0){
            return null;
        }
        return userService.getUserWithAllQuestion(userId,currentPage,size);
    }
}
