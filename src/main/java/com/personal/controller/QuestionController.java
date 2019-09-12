package com.personal.controller;

import com.github.pagehelper.PageInfo;
import com.personal.service.QuestionService;
import com.personal.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Auther: Chen
 * @Data: 2019/9/7
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/questions")
    public PageInfo<QuestionVO> getQuestions(
            @RequestParam(value = "size", defaultValue = "3") Integer size,
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage) {

        PageInfo<QuestionVO> questions = questionService.getQuestions(size, currentPage);

        return questions;
    }
}
