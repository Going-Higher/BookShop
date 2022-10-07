package com.exam.myapp.member;

import java.util.List;

public interface MemberService {
	public List<MemberVo> selectList();

	public int insert(MemberVo vo);

	public MemberVo select(MemberVo vo);

	public int update(MemberVo vo);

	public int delete(MemberVo vo);

	public MemberVo selectLogin(MemberVo vo);
}
