package com.personal.controller;

import com.personal.dto.AccessTokenDTO;
import com.personal.dto.GithubUser;
import com.personal.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

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

    /**
     * GitHub回调 URL
     * @param code GitHub传来（只能使用一次）
     * @param state
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam("code")String code,
                           @RequestParam("state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("45433d33477f5f586e86");
        accessTokenDTO.setClient_secret("f5bc6ff21f39ac61d4820396f61bc92ea06f45e9");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
