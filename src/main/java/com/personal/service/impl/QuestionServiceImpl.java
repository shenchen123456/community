package com.personal.service.impl;

import com.personal.entity.Question;
import com.personal.mapper.QuestionMapper;
import com.personal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean insertQuestion(Question question){
        System.out.println(question);
        return questionMapper.insertQuestion(question);
    }
}
