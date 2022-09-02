package com.exam.myapp.member;

import java.util.List;

public interface MemberService {
	public List<MemberVo> selectList();

	public int insert(MemberVo vo);
}
