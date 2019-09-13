package com.personal.controller;

import com.personal.dto.AccessTokenDTO;
import com.personal.dto.GithubUser;
import com.personal.entity.User;
import com.personal.provider.GithubProvider;
import com.personal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @Auther: Chen
 * @Data: 2019/9/5
 * @Description: com.personal.controller
 * @Version: 1.0.0
 */
@Controller
public class AuthorizeController {

    @Autowired
    private  GithubProvider githubProvider;

    @Autowired
    private UserService userService;

    @Value("${github.clientId}")
    private String clientId;

    @Value("${github.clientSecret}")
    private String clientSecret;

    @Value("${github.redirectUri}")
    private String redirectUri;

    /**
     * GitHub回调 URL
     * @param code GitHub传来（只能使用一次）
     * @param state
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam("code")String code,
                           @RequestParam("state")String state,
                           HttpServletResponse httpServletResponse){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO().setClient_id(clientId).setClient_secret(clientSecret).
                                        setCode(code).setRedirect_uri(redirectUri).setState(state);
        //System.out.println(accessTokenDTO);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);

        GithubUser user = githubProvider.getUser(accessToken);

        //检查数据是否存在该用户,用户存在数据不一样则更新
        User result = userService.checkUser(user);
        if (null != result && null !=user) {

            httpServletResponse.addCookie(new Cookie("token",result.getToken()));

            return "redirect:/";
        }
        //登录成功，且数据库通过AccountId没查询到对应的用户，则认为是新用户
        if(null !=user && result ==null ){
            String token = UUID.randomUUID().toString();
            //插入数据库持久化
            userService.insertUser(new User().setAccountId(user.getId()+"")
                    .setName(user.getLogin())
                    .setToken(token)
                    .setAvatarUrl(user.getAvatar_url()));
            //System.out.println(user.getName());
            httpServletResponse.addCookie(new Cookie("token",token));
        }
        return "redirect:/";
    }
}
