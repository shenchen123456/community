package com.personal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.personal.entity.Question;
import com.personal.entity.User;
import com.personal.mapper.QuestionMapper;
import com.personal.mapper.UserMapper;
import com.personal.service.QuestionService;
import com.personal.vo.QuestionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    PageHelper pageHelper;

    @Autowired
    UserMapper userMapper;

    public boolean insertQuestion(Question question){
        System.out.println(question);
        return questionMapper.insertQuestion(question);
    }

    @Override
    public PageInfo<QuestionVO> getQuestions(Integer size, Integer currentPage) {
        pageHelper.startPage(currentPage,size);
        List<QuestionVO> questions = questionMapper.getQuestionsWithUser();

        PageInfo page = new PageInfo(questions);

        return page;
    }
}
