package com.personal;

import com.personal.entity.Question;
import com.personal.entity.User;
import com.personal.mapper.QuestionMapper;
import com.personal.service.QuestionService;
import com.personal.service.UserService;
import com.personal.service.impl.UserServiceImpl;
import com.personal.vo.QuestionVO;
import com.personal.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    QuestionService questionService;

    @Test
    public void testUserService() {

        UserVO oneByIdWithQuestion = userService.findOneByIdWithQuestion(7);
        System.out.println(oneByIdWithQuestion);

        //User one = userService.findOne(1);
        //System.out.println(one);
        //boolean zhangsan = userService.insertUser(new User().setAccountId("1456").setToken(UUID.randomUUID().toString()).setName("zhangsan"));
        //System.out.println(zhangsan);


    }

    @Test
    public void testQuestionService() {

        //List<QuestionVO> questions = questionService.getQuestions(5, 1);
        //System.out.println(questions);
    }


}
