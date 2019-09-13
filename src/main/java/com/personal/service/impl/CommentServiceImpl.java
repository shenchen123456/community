package com.personal.service.impl;

import com.personal.entity.Comment;
import com.personal.entity.Question;
import com.personal.enums.CommentTypeEnum;
import com.personal.exception.CustomizeErrorEnum;
import com.personal.exception.CustomizeException;
import com.personal.mapper.CommentMapper;
import com.personal.mapper.QuestionExtMapper;
import com.personal.mapper.QuestionMapper;
import com.personal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    QuestionExtMapper questionExtMapper;
    @Autowired
    QuestionMapper questionMapper;

    @Override
    public boolean insert(Comment comment) {
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

        }else {
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (null == question){
                throw new CustomizeException(CustomizeErrorEnum.QUESTION_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);
            question.setCommentCount(1);
            questionExtMapper.incrementComment(question);
        }

        return false;
    }
}
