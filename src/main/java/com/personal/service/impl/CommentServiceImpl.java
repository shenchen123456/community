package com.personal.service.impl;

import com.personal.entity.Comment;
import com.personal.entity.CommentExample;
import com.personal.entity.Notification;
import com.personal.entity.Question;
import com.personal.enums.CommentTypeEnum;
import com.personal.enums.NotificationStatusEnum;
import com.personal.enums.NotificationTypeEnum;
import com.personal.exception.CustomizeErrorEnum;
import com.personal.exception.CustomizeException;
import com.personal.mapper.*;
import com.personal.service.CommentService;
import com.personal.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.service.impl
 * @Version: 1.0.0
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    CommentExtMapper commentExtMapper;

    @Autowired
    QuestionExtMapper questionExtMapper;
    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    NotificationMapper notificationMapper;

    @Override
    @Transactional
    public boolean insert(Comment comment, String createName) {
        if (comment.getParentId() == null || comment.getParentId() == 0){
            throw new CustomizeException(CustomizeErrorEnum.TARGET_PARAM_NOT_FOUND);
        }

        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorEnum.TYPE_PARAM_WRONG);
        }

        if (comment.getType() == CommentTypeEnum.COMMENT.getType()){
            //回复评论
            Comment dbcomment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (null == dbcomment){
                throw new CustomizeException(CustomizeErrorEnum.COMMENT_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);

            //父级评论数+1
            Comment commentCount = new Comment();
            commentCount.setId(comment.getParentId());
            commentCount.setCommentCount(1);
            commentExtMapper.incrementComment(commentCount);

            //创建通知
            createNotify(comment, dbcomment.getCommentor(), NotificationTypeEnum.REPLY_COMMENT.getType(), createName, comment.getContent());

        }else {
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (null == question){
                throw new CustomizeException(CustomizeErrorEnum.QUESTION_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);
            question.setCommentCount(1);
            questionExtMapper.incrementComment(question);

            //创建通知
            createNotify(comment, question.getCreator(), NotificationTypeEnum.REPLY_QUESTION.getType(), createName, question.getTitle());
        }

        return false;
    }

    /**
     * 创建通知
     * @param comment 评论
     * @param receiver 评论接收者
     * @param notificationType 回复评论或回复问题类型
     * @param createName 评论人名字
     * @param content 评论的问题标题或评论的回复的内容
     */
    private void createNotify(Comment comment, Integer receiver, Integer notificationType, String createName, String content) {
        Notification notification = new Notification();
        notification.setOuterId(comment.getParentId());
        notification.setNotifier(comment.getCommentor());
        notification.setNotifierName(createName);
        notification.setContent(content);
        notification.setType(notificationType);
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setReceiver(receiver);
        notificationMapper.insertSelective(notification);
    }

    /**
     * 拿到单个问题的所有回复,包括用户信息
     * @param id 问题唯一标识符
     * @return
     */
    @Override
    public List<CommentVO> getAllCommentsByQuestionIdWithUser(Integer id,CommentTypeEnum commentType) {

        CommentExample example = new CommentExample();
        example.createCriteria()
                .andParentIdEqualTo(id)
                .andTypeEqualTo(commentType.getType());
        example.setOrderByClause("create_time desc");

        List<CommentVO> commentsWithUser = commentExtMapper.selectByExampleWithUser(example);

        if (commentsWithUser.size() == 0) {
            return new ArrayList<>();
        }

        return commentsWithUser;
    }

    @Override
    public Integer updateReplyCount(Integer id) {

        CommentExample example = new CommentExample();
        example.createCriteria()
                .andParentIdEqualTo(id)
                .andTypeEqualTo(CommentTypeEnum.COMMENT.getType())
                ;
        example.setOrderByClause("create_time desc");


        return null;
    }
}
