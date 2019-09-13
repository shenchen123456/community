package com.personal.controller;

import com.personal.dto.CommentDTO;
import com.personal.dto.MessageDTO;
import com.personal.entity.Comment;
import com.personal.entity.User;
import com.personal.exception.CustomizeErrorEnum;
import com.personal.service.CommentService;
import com.personal.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
public class CommentController {

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @PostMapping("/comment")
    @ResponseBody
    public MessageDTO post(@RequestBody CommentDTO commentDTO, HttpServletRequest request){

        //校验用户是否登录
//        String username = (String) request.getSession().getAttribute("username");
//        Integer userId = (Integer) request.getSession().getAttribute("userId");
//
//        if (null == username && null ==userId){
//            return MessageDTO.errorOf(CustomizeErrorEnum.NOT_LOGIN);
//        }
//
//        User user = userService.findOneByNameAndId(username,userId);
//
//        if (null == user) {
//            return MessageDTO.errorOf(CustomizeErrorEnum.NOT_LOGIN);
//        }

        Comment comment = new Comment();

        BeanUtils.copyProperties(commentDTO,comment);

        commentService.insert(comment);


        return MessageDTO.successOf();
    }
}
