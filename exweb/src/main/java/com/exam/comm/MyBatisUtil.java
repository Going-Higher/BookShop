package com.exam.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {	
	private static SqlSessionFactory sqlSessionFactory = null;

	static {
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

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}	
}
