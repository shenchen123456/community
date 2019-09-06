package com.personal;

import com.personal.entity.User;
import com.personal.service.UserService;
import com.personal.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void testUserService() {

        //User one = userService.findOne(1);
        //System.out.println(one);
        boolean zhangsan = userService.insertUser(new User().setAccountId("1456").setToken(UUID.randomUUID().toString()).setName("zhangsan"));
        System.out.println(zhangsan);

    }

}
