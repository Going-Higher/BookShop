package com.exam.myapp.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
	public List<MemberVo> selectList();
	public int insert(MemberVo vo);
}
