package com.exam.member;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.exam.comm.MyBatisUtil;

public class MemberDaoBatis implements MemberDao {
	//싱클톤(Singleton)패턴
	//클래스의 인스턴스를 1개만 생성하여 애플리케이션 전체에서 공유하여 사용하고 싶을 때,
	private MemberDaoBatis() {	} //클래스외부에서 인스턴스생성(생성자 호출)을 금지
	private static MemberDaoBatis memberDaoBatis = new MemberDaoBatis(); //클래스 내부에서 인스턴스 생성 및 보관
	public static MemberDaoBatis getInstance() { //클래스 외부에서 필요한 경우, 보관한 인스턴스를 제공하는 메서드
		return memberDaoBatis;		
	}
	
	private SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();	

	@Override
	public List<MemberVo> selectMemberList() {
		List<MemberVo> list = null;
		//마이바티스를 통한 데이터베이스와의 세션(연결)을 가져와서 
		try (SqlSession session = sqlSessionFactory.openSession()) {			
			//해당 세션을 통해 마이바티스에 등록된 SQL문을 실행
			//실행할 SQL문의 종류에 따라서 메서드를 선택
			//"namespace.id"로 실행한 SQL문을 지정
			list = session.selectList("com.exam.member.MemberDao.selectMemberList");
		}
		return list;
	}

	@Override
	public MemberVo selectMember(String memId) {
		MemberVo vo = null;		
		try (SqlSession session = sqlSessionFactory.openSession()) {				
			vo = session.selectOne("com.exam.member.MemberDao.selectMember", memId);
		}
		return vo;
	}
	
	@Override
	public int insertMember(MemberVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {	
			//SQL문 실행에 필요한 데이터는 두번째 인자로 전달
			num = session.insert("com.exam.member.MemberDao.insertMember", vo);
			session.commit(); //insert, update, delete 후에는 커밋 필요
		}
		return num;
	}

	@Override
	public int delMember(String memId) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {				
			num = session.delete("com.exam.member.MemberDao.delMember", memId);
			session.commit(); 
		}
		return num;
	}

	@Override
	public int updatetMember(MemberVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {	
			num = session.update("com.exam.member.MemberDao.updateMember", vo);
			session.commit(); 
		}
		return num;
	}

	@Override
	public MemberVo selectLoginMember(MemberVo vo) {
		MemberVo memVo = null;		
		try (SqlSession session = sqlSessionFactory.openSession()) {				
			memVo = session.selectOne("com.exam.member.MemberDao.selectLoginMember", vo);
		}
		return memVo;
	}
	
}
