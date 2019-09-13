package com.personal.service;

import com.github.pagehelper.PageInfo;
import com.personal.entity.Question;
import com.personal.vo.QuestionVO;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.service
 * @Version: 1.0.0
 */
public interface QuestionService {

    boolean insertQuestion(Question question);

    PageInfo<QuestionVO> getQuestions(Integer size, Integer currentPage);

    QuestionVO findOneQuestionByIdWithUser(Integer id);

    Question findOneById(Integer id);

    boolean checkQuestion(Question question);
}
