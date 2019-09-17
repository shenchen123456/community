package com.personal.service;

import com.personal.entity.Comment;
import com.personal.enums.CommentTypeEnum;
import com.personal.vo.CommentVO;

import java.util.List;

/**
 * @Auther: Chen
 * @Data: 2019/9/13
 * @Description: com.personal.service
 * @Version: 1.0.0
 */
public interface CommentService {
    boolean insert(Comment comment, String createName);

    List<CommentVO> getAllCommentsByQuestionIdWithUser(Integer id, CommentTypeEnum commentType);

    Integer updateReplyCount(Integer id);
}
