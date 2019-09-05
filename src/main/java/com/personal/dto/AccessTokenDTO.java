package com.personal.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @Auther: Chen
 * @Data: 2019/9/5
 * @Description: com.personal.dto
 * @Version: 1.0.0
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
