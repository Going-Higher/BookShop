package com.exam.exspring.member;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {

	List<MemberVo> selectMemberList();

	int insertMember(MemberVo vo);

	int delMember(String memId);

	MemberVo selectMember(String memId);

	int updateMember(MemberVo vo);	

	MemberVo selectLoginMember(MemberVo vo);

}