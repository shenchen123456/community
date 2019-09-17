package com.personal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.personal.dto.NotificationDTO;
import com.personal.entity.Comment;
import com.personal.entity.Notification;
import com.personal.entity.NotificationExample;
import com.personal.enums.NotificationStatusEnum;
import com.personal.enums.NotificationTypeEnum;
import com.personal.exception.CustomizeErrorEnum;
import com.personal.exception.CustomizeException;
import com.personal.mapper.CommentMapper;
import com.personal.mapper.NotificationMapper;
import com.personal.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Chen
 * @Data: 2019/9/16
 * @Description: com.personal.service.impl
 * @Version: 1.0.0
 */
@Service
public class NotificationServiceImpl implements NotificationService {


    @Autowired
    NotificationMapper notificationMapper;

    @Autowired
    CommentMapper commentMapper;

    @Override
    public PageInfo<Notification> getUserWithAllNotification(Integer userId, Integer currentPage, Integer size) {

        PageHelper.startPage(currentPage, size);

        NotificationExample example = new NotificationExample();
        example.setOrderByClause("create_time desc");
        example.createCriteria()
                .andReceiverEqualTo(1);
        List<Notification> notifications = notificationMapper.selectByExample(example);


        return new PageInfo<>(notifications);
    }

    @Override
    public Integer findQuestionId(NotificationDTO notificationDTO) {

        Notification notification = notificationMapper.selectByPrimaryKey(notificationDTO.getId());

        if (notification == null){
            throw new CustomizeException(CustomizeErrorEnum.NOTIFICATION_NOT_FOUND);
        }

        if (notificationDTO.getType().equals(NotificationTypeEnum.REPLY_QUESTION.getType())) {
            //通知 回复问题
            //修改通知状态为已读
            updateNotificationStatus(notification);

            return notification.getOuterId();
        }else if (notificationDTO.getType().equals(NotificationTypeEnum.REPLY_COMMENT.getType())){

            //通知 回复评论

            Comment comment = commentMapper.selectByPrimaryKey(notification.getOuterId());
            //修改通知状态为已读
            updateNotificationStatus(notification);

            return comment.getParentId();
        }else {
            throw new CustomizeException(CustomizeErrorEnum.NOTIFICATION_TYPE_ERROR);
        }

    }

    @Override
    public Integer findUnreadCount(Integer id) {

        NotificationExample example = new NotificationExample();
        example.createCriteria()
                .andReceiverEqualTo(id)
                .andStatusEqualTo(NotificationStatusEnum.UNREAD.getStatus());
        List<Notification> notifications = notificationMapper.selectByExample(example);

        return notifications.size();
    }

    private void updateNotificationStatus(Notification notification) {
        NotificationExample example = new NotificationExample();
        example.createCriteria().andIdEqualTo(notification.getId());
        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByExampleSelective(notification,example);
    }
}
