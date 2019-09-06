package com.personal.dto;

import lombok.Data;

/**
 * @Auther: Chen
 * @Data: 2019/9/5
 * @Description: com.personal.dto
 * @Version: 1.0.0
 */
@Data
public class GithubUser {
    private Long id;
    private String login;
    private String name;
    private String email;
    private String company;
    private String bio;
}
