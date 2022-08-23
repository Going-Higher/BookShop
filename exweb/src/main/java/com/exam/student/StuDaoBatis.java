package com.exam.student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StuDaoBatis implements StuDao {
	
	private SqlSessionFactory sqlSessionFactory = null;

	public StuDaoBatis() {
		try {
			//마이바티스 설정 파일 위치
			String resource = "mybatis/mybatis-config.xml";
			//마이바티스 설정파일 읽을 수 있는 입력스트림
			InputStream inputStream = Resources.getResourceAsStream(resource); 
			//마이바티스 설정 파일의 내용대로 마이바티스 본체(sqlSessionFactory)를 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<StuVo> selectStuList() {
		List<StuVo> list = null;
		//마이바티스를 통한 데이터베이스와의 세션(연결)을 가져와서 
		try (SqlSession session = sqlSessionFactory.openSession()) {			
			//해당 세션을 통해 마이바티스에 등록된 SQL문을 실행
			//실행할 SQL문의 종류에 따라서 메서드를 선택
			//"namespace.id"로 실행한 SQL문을 지정
			list = session.selectList("com.exam.student.StuDao.selectStuList");
		}
		return list;
	}

	@Override
	public StuVo selectStu(String stuNo) {
		StuVo vo = null;		
		try (SqlSession session = sqlSessionFactory.openSession()) {				
			vo = session.selectOne("com.exam.student.StuDao.selectStu", stuNo);
		}
		return vo;
	}
	
	@Override
	public int insertStu(StuVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {	
			//SQL문 실행에 필요한 데이터는 두번째 인자로 전달
			num = session.insert("com.exam.student.StuDao.insertStu", vo);
			session.commit(); //insert, update, delete 후에는 커밋 필요
		}
		return num;
	}

	@Override
	public int delStu(String stuNo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {				
			num = session.delete("com.exam.student.StuDao.delStu", stuNo);
			session.commit(); 
		}
		return num;
	}

	@Override
	public int updateStu(StuVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {	
			num = session.update("com.exam.student.StuDao.updateStu", vo);
			session.commit(); 
		}
		return num;
	}
	
}
