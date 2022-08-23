package com.exam.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StuDaoJdbc {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";//데이터베이스 서버 주소
	String user = "web";//데이터베이스 사용자 아이디
	String password = "web01";//데이터베이스 사용자 비밀번호
	
//	{
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {			
//			e.printStackTrace();
//		}
//	}
	
	public ArrayList<StuVo> selectList() {
		// 데이터베이스 student 테이블의 정보를 select하여 출력
		ArrayList<StuVo> list = new ArrayList<StuVo>();
		String selectSql = "SELECT stu_no, stu_name, stu_score FROM student";
		try (
				Connection conn = DriverManager.getConnection(url, user, password);						
				PreparedStatement pstmt = conn.prepareStatement(selectSql);				
				ResultSet rs = pstmt.executeQuery();
		) {			
			
			while (rs.next()) {		// 다음 레코드가 있는 동안 반복	
				StuVo vo = new StuVo();
				vo.setStuNo(rs.getString("stu_no"));
				vo.setStuName(rs.getString("stu_name"));
				vo.setStuScore(rs.getInt("stu_score"));					
				list.add(vo);
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return list;
	}

	public int insert(StuVo vo) {
		int num = 0;
		// 데이터베이스 student 테이블에 회원정보를 insert
		String insertSql = "INSERT INTO student "
				+ "(stu_no, stu_name, stu_score) "
				+ "VALUES (?, ?, ?)";
		try (
				Connection conn = DriverManager.getConnection(url, user, password);						
				PreparedStatement pstmt = conn.prepareStatement(insertSql);								
		) {	
			//?에 주입할 값의 타입에 따라서 setXXX() 메서드 사용
			pstmt.setString(1, vo.getStuNo());//pstmt에 담긴 SQL문의 1번째 ?에 id 값을 주입
			pstmt.setString(2, vo.getStuName());//pstmt에 담긴 SQL문의 2번째 ?에 id 값을 주입
			pstmt.setInt(3, vo.getStuScore());//pstmt에 담긴 SQL문의 3번째 ?에 id 값을 주입	
			num = pstmt.executeUpdate();//SQL문 실행결과 변경된 레코드 수를 반환
				
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return num;
	}

	public int delete(String stu_no) {
		// 입력한 번호의 학생을 student 테이블에서 삭제
		int num = 0;
		String deleteSql = "DELETE FROM student WHERE stu_no = ?";		
		
		try (
				Connection conn = DriverManager.getConnection(url, user, password);						
				PreparedStatement pstmt = conn.prepareStatement(deleteSql);								
		) {	
			//?에 주입할 값의 타입에 따라서 setXXX() 메서드 사용
			pstmt.setString(1, stu_no);//pstmt에 담긴 SQL문의 1번째 ?에 id 값을 주입
			
			num = pstmt.executeUpdate();//SQL문 실행결과 변경된 레코드 수를 반환						
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return num;
	}
}
