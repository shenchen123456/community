package com.personal.controller;

import com.github.pagehelper.PageInfo;
import com.personal.exception.CustomizeErrorCode;
import com.personal.exception.CustomizeException;
import com.personal.service.QuestionService;
import com.personal.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

        model.addAttribute("question",question);

        return "question";
    }
}
