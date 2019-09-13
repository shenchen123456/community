package com.personal;

import com.personal.entity.Question;
import com.personal.entity.QuestionExample;
import com.personal.mapper.QuestionMapper;
import com.personal.service.QuestionService;
import com.personal.service.impl.UserServiceImpl;
import com.personal.vo.QuestionVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    QuestionService questionService;


    @Autowired
    QuestionMapper questionMapper;

    @Test
    public void testUserService() {

        //UserVO oneByIdWithQuestion = userService.findOneQuestionByIdWithUser(1,1,3);
        //System.out.println(oneByIdWithQuestion);

        //User one = userService.findOne(1);
        //System.out.println(one);
        //boolean zhangsan = userService.insertUser(new User().setAccountId("1456").setToken(UUID.randomUUID().toString()).setName("zhangsan"));
        //System.out.println(zhangsan);


    }

    @Test
    public void testQuestionService() {

        //PageInfo<QuestionVO> questions = questionService.getQuestions(3, 1);
        //System.out.println(questions);


    }

    @Test
    public void testQuestionMapper() {
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andCreatorEqualTo(1);

        //List<Question> questions = questionMapper.selectByExample(questionExample);
        //System.out.println(questions);

    }
}
