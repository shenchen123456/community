package com.personal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.personal.entity.Question;
import com.personal.exception.CustomizeErrorEnum;
import com.personal.exception.CustomizeException;
import com.personal.mapper.QuestionExtMapper;
import com.personal.mapper.QuestionMapper;
import com.personal.service.QuestionService;
import com.personal.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.service.impl
 * @Version: 1.0.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    QuestionExtMapper questionExtMapper;

    @Autowired
    PageHelper pageHelper;

    @Override
    public PageInfo<QuestionVO> getQuestions(Integer size, Integer currentPage) {
        pageHelper.startPage(currentPage,size);
        List<QuestionVO> questionsWithUser = questionMapper.getAllQuestionWithUser();
        PageInfo page = new PageInfo(questionsWithUser);
        return page;
    }

    @Override
    public QuestionVO findOneQuestionByIdWithUser (Integer id) {
        QuestionVO question = questionMapper.findOneQuestionByIdWithUser(id);
        if (null == question) {
            throw new CustomizeException(CustomizeErrorEnum.QUESTION_NOT_FOUND);
        }
        return question;
    }

    @Override
    public Question findOneById(Integer id) {
        return questionMapper.findOneById(id);
    }

    @Override
    public boolean checkQuestion(Question question) {

        Question dbQuestion = questionMapper.findOneById(question.getId());

        if(null != dbQuestion){
            if(question.getTag().equals(dbQuestion.getTag()) &&
                    question.getTitle().equals(dbQuestion.getTitle()) &&
                    question.getDescription().equals(dbQuestion.getDescription())) {
                throw new CustomizeException(CustomizeErrorEnum.QUESTION_NOT_MODIFY);
            }
        }
        boolean result = questionMapper.updateQuestion(question);

        if (false == result) {
            throw new CustomizeException(CustomizeErrorEnum.QUESTION_NOT_FOUND);
        }

        return result;
    }

    @Override
    public void incrementView(Integer id) {
        Question record = new Question().setId(id).setViewCount(1);
        questionExtMapper.incrementView(record);
    }

}
