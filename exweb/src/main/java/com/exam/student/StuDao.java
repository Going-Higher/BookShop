package com.exam.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.member.MemberVo;

interface StuDao {

	public List<StuVo> selectStuList() ;

	public int insertStu(StuVo vo) ;

	public int delStu(String stuNo) ;
	
	StuVo selectStu(String stuNo);
	
	int updateStu(StuVo vo);
	
}