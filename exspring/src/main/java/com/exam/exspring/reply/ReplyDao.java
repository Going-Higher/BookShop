package com.exam.exspring.reply;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyDao {
	int insertReply(ReplyVo vo);

	List<ReplyVo> selectReplyList(int repBbsNo);

	int deleteReply(ReplyVo vo);

}
