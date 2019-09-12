package com.personal.service;

import com.github.pagehelper.PageInfo;
import com.personal.entity.Question;
import com.personal.vo.QuestionVO;

import java.util.List;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.service
 * @Version: 1.0.0
 */
public interface QuestionService {

    boolean insertQuestion(Question question);

    PageInfo<QuestionVO> getQuestions(Integer size, Integer currentPage);
}
