package com.personal.provider;

import com.personal.dto.AccessTokenDTO;
import com.personal.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: Chen
 * @Data: 2019/9/5
 * @Description: com.personal.provider
 * @Version: 1.0.0
 */
@Component
public class GithubProvider {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取accessToken
     *
     * @param accessTokenDTO 获取accessToken的参数
     * @return accessToken
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        String accesstokenAll = restTemplate.postForObject("https://github.com/login/oauth/access_token", accessTokenDTO, String.class);
        //System.out.println(accesstokenAll);
        //分割传来的字符串获取 accesstoken
        String accesstoken = (accesstokenAll.split("&")[0]).
                            split("=")[1];
        return accesstoken;
    }

    /**
     * 通过accessToken获取用户信息
     * @param accessToken
     * @return 用户信息
     */
    public GithubUser getUser(String accessToken) {
        GithubUser githubUser = restTemplate.getForObject("https://api.github.com/user?access_token=" + accessToken, GithubUser.class);
        //System.out.println(githubUser);
        return githubUser;
    }
}
