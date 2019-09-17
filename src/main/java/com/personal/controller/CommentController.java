package com.personal.controller;

import com.github.pagehelper.util.StringUtil;
import com.personal.dto.CommentDTO;
import com.personal.dto.MessageDTO;
import com.personal.entity.Comment;
import com.personal.enums.CommentTypeEnum;
import com.personal.exception.CustomizeErrorEnum;
import com.personal.provider.UserLoginProvider;
import com.personal.service.CommentService;
import com.personal.vo.CommentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
public class CommentController {

    @Autowired
    UserLoginProvider userLoginProvider;

    @Autowired
    CommentService commentService;

    /**
     * 发送问题评论
     * @param commentDTO
     * @param request
     * @return
     */
    @PostMapping("/comment")
    @ResponseBody
    public MessageDTO sendComment(@RequestBody CommentDTO commentDTO, HttpServletRequest request){

        if (StringUtil.isEmpty(commentDTO.getContent())) {
            return MessageDTO.errorOf(CustomizeErrorEnum.CONTENT_NOT_BE_EMPTY);
        }

        //校验用户是否登录
        String username = (String) request.getSession().getAttribute("username");
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        boolean result = userLoginProvider.checkUserIsLogin(username,userId);

        if (!result){
            return MessageDTO.errorOf(CustomizeErrorEnum.NOT_LOGIN);
        }

        Comment comment = new Comment();

        BeanUtils.copyProperties(commentDTO,comment);

        comment.setCommentor(userId);

        commentService.insert(comment,username);


        return MessageDTO.successOf();
    }

    /**
     * 通过问题Id获取所有评论并带有user信息
     * @param id
     * @return
     */
    @GetMapping("/question/{id}/comments")
    @ResponseBody
    public List<CommentVO> getAllCommentsByQuestionIdWithUser(@PathVariable("id")Integer id){

        List<CommentVO> comments = commentService.getAllCommentsByQuestionIdWithUser(id, CommentTypeEnum.QUESTION);

        return comments;
    }


    /**
     * 发送问题评论的回复
     * @param commentDTO
     * @param request
     * @return
     */
    @PutMapping("/reply")
    @ResponseBody
    public MessageDTO sendReply(@RequestBody CommentDTO commentDTO, HttpServletRequest request){

        if (StringUtil.isEmpty(commentDTO.getContent())) {
            return MessageDTO.errorOf(CustomizeErrorEnum.CONTENT_NOT_BE_EMPTY);
        }

        //校验用户是否登录
        String username = (String) request.getSession().getAttribute("username");
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        boolean result = userLoginProvider.checkUserIsLogin(username,userId);

        if (!result){
            return MessageDTO.errorOf(CustomizeErrorEnum.NOT_LOGIN);
        }

        Comment comment = new Comment();

        BeanUtils.copyProperties(commentDTO,comment);

        comment.setCommentor(userId);

        commentService.insert(comment, username);


        return MessageDTO.successOf();

    }


    /**
     * 通过问题Id获取所有回复评论的信息并带有user信息
     * @param id
     * @return
     */
    @GetMapping("/question/reply/{id}")
    @ResponseBody
    public List<CommentVO> getAllReplyByQuestionIdWithUser(@PathVariable("id")Integer id){

        List<CommentVO> comments = commentService.getAllCommentsByQuestionIdWithUser(id, CommentTypeEnum.COMMENT);

        return comments;
    }

    @GetMapping("/reply/{id}")
    public MessageDTO updateReplyCount(@PathVariable("id")Integer id) {

        Integer count = commentService.updateReplyCount(id);

        return MessageDTO.successOf();
    }
}
