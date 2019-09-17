package com.personal.controller;

import com.github.pagehelper.PageInfo;
import com.personal.dto.MessageDTO;
import com.personal.dto.QuestionDTO;
import com.personal.entity.Question;
import com.personal.exception.CustomizeErrorEnum;
import com.personal.provider.UserLoginProvider;
import com.personal.service.QuestionService;
import com.personal.vo.QuestionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @Auther: Chen
 * @Data: 2019/9/7
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    UserLoginProvider userLoginProvider;

    @GetMapping("/questions")
    @ResponseBody
    public PageInfo<QuestionVO> getQuestions(
            @RequestParam(value = "size", defaultValue = "3") Integer size,
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage) {

        PageInfo<QuestionVO> questions = questionService.getQuestions(size, currentPage);

        return questions;
    }

    @GetMapping("/question/{id}")
    public String getQuestionByIdWithUser(@PathVariable("id")Integer id,
                                          Model model){
        QuestionVO question = questionService.findOneQuestionByIdWithUser(id);
        //浏览数+1
        questionService.incrementView(id);

        model.addAttribute("question",question);

        return "question";
    }

//    @PutMapping("/question")
//    @ResponseBody
//    public MessageDTO sendQuestion(@RequestBody QuestionDTO questionDTO,
//                                   HttpServletRequest request){
//        if ("".equals(questionDTO.getTitle())|| questionDTO.getTitle() == null ){
//            return MessageDTO.errorOf(CustomizeErrorEnum.TITLE_NOT_BE_EMPTY);
//        }
//        if ("".equals(questionDTO.getDescription())|| questionDTO.getDescription() == null ){
//            return MessageDTO.errorOf(CustomizeErrorEnum.DESCRIPTION_NOT_BE_EMPTY);
//        }
//        if ("".equals(questionDTO.getTag())|| questionDTO.getTag() == null ){
//            return MessageDTO.errorOf(CustomizeErrorEnum.TAG_NOT_BE_EMPTY);
//        }
//
//        //校验用户登录
//        String username = (String) request.getSession().getAttribute("username");
//        Integer userId = (Integer) request.getSession().getAttribute("userId");
//
//        boolean result = userLoginProvider.checkUserIsLogin(username,userId);
//
//        if (!result){
//            return MessageDTO.errorOf(CustomizeErrorEnum.NOT_LOGIN);
//        }
//
//        Question question = new Question();
//
//        BeanUtils.copyProperties(questionDTO,question);
//
//        question.setCreator(userId);
//
//        questionService.questionCreateOrUpdate(question);
//
//        return MessageDTO.successOf();
//
//    }
}
