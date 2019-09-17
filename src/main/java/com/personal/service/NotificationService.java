package com.personal.service;

import com.github.pagehelper.PageInfo;
import com.personal.dto.NotificationDTO;
import com.personal.entity.Notification;

import java.util.List;

/**
 * @Auther: Chen
 * @Data: 2019/9/16
 * @Description: com.personal.service
 * @Version: 1.0.0
 */
public interface NotificationService {
    PageInfo<Notification> getUserWithAllNotification(Integer userId, Integer currentPage, Integer size);

    Integer findQuestionId(NotificationDTO notificationDTO);

    Integer findUnreadCount(Integer id);
}
