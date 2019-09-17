package com.personal;

import com.personal.dto.NotificationDTO;
import com.personal.entity.NotificationExample;
import com.personal.entity.QuestionExample;
import com.personal.enums.NotificationStatusEnum;
import com.personal.enums.NotificationTypeEnum;
import com.personal.mapper.CommentMapper;
import com.personal.mapper.QuestionMapper;
import com.personal.service.NotificationService;
import com.personal.service.QuestionService;
import com.personal.service.impl.UserServiceImpl;
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

    @Autowired
    NotificationService notificationService;



    @Test
    public void testUserService() {

        //UserVO oneByIdWithQuestion = userService.findOneQuestionByIdWithUser(1,1,3);
        //System.out.println(oneByIdWithQuestion);

        //User one = userService.findOne(1);
        //System.out.println(one);
        //boolean zhangsan = userService.insertUser(new User().setAccountId("1456").setToken(UUID.randomUUID().toString()).setName("zhangsan"));
        //System.out.println(zhangsan);
//        CommentExample example = new CommentExample();
//        example.createCriteria()
//                .andParentIdEqualTo(5)
//                .andTypeEqualTo(CommentTypeEnum.QUESTION.getType());


 //       List<CommentVO> comments = commentMapper.selectByExampleWithUser(example);

 //       System.out.println(comments);
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setId(5);
        notificationDTO.setType(NotificationTypeEnum.REPLY_COMMENT.getType());
        Integer questionId = notificationService.findQuestionId(notificationDTO);
        System.out.println(questionId);

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
