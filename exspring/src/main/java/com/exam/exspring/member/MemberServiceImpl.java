package com.exam.exspring.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	@Override
	public List<MemberVo> selectMemberList() {		
		return memberDao.selectMemberList();
	}

	@Override
	public int insertMember(MemberVo vo) {
		return memberDao.insertMember(vo);
	}

	@Override
	public int delMember(String memId) {
		return memberDao.delMember(memId);
	}

	@Override
	public MemberVo selectMember(String memId) {
		return memberDao.selectMember(memId);
	}

	@Override
	public int updatetMember(MemberVo vo) {
		return memberDao.updateMember(vo);
	}

	@Override
	public MemberVo selectLoginMember(MemberVo vo) {
		return memberDao.selectLoginMember(vo);
	}

}
