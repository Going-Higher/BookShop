<%@page import="com.exam.exspring.member.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.exam.exspring.member.MemberDaoJdbc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	MemberDaoJdbc memberDao = new MemberDaoJdbc();
%>  
<%     		
	List<MemberVo> list  = memberDao.selectMemberList();
  %>  		
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset='UTF-8'>
		<title>Insert title here</title>
		</head>
		<body>
		<h1>회원목록<h1>
		
		<a href='<%=request.getContextPath()%>/MemAddForm.jsp'>회원추가</a><br>
		회원아이디 : 회원비밀번호 : 회원이름 : 회원포인트<br>
<%		
		for (int i = 0; i < list.size(); i++) {
			MemberVo vo = list.get(i);
%>
			<%=vo.getMemId()%> : <%=vo.getMemPass()%> : <%=vo.getMemName()%> : <%=vo.getMemPoint()%>
			<a href='<%=request.getContextPath()%>/MemDel.jsp?memId=<%=vo.getMemId()%>'>삭제</a><br>
<%		
	}			
%>  		
 		</body>
		</html>
