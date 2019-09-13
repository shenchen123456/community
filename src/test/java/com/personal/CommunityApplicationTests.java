package com.personal;

import com.github.pagehelper.PageInfo;
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

        QuestionVO oneQuestionByIdWithUser = questionService.findOneQuestionByIdWithUser(2);

        System.out.println(oneQuestionByIdWithUser);
    }


}
