package com.personal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: Chen
 * @Data: 2019/9/17
 * @Description: com.personal.dto
 * @Version: 1.0.0
 */
@Data
public class NotificationDTO {

    @NotBlank(message = "notificationId不能为空")
    private Integer id;
    @NotBlank(message = "notificationType不能为空")
    private Integer type;
}
