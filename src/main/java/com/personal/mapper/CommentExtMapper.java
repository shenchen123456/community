package com.personal.mapper;

import com.personal.entity.Comment;
import com.personal.entity.CommentExample;
import com.personal.entity.Question;
import com.personal.vo.CommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentExtMapper {

    List<CommentVO> selectByExampleWithUser(CommentExample example);

    boolean incrementComment (@Param("record") Comment record);

}