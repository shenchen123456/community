package com.personal.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: Chen
 * @Data: 2019/9/5
 * @Description: com.personal.dto
 * @Version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
