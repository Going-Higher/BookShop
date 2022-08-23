<%@page import="com.exam.exspring.member.MemberDaoJdbc"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	MemberDaoJdbc memberDao = new MemberDaoJdbc();
%>

<%


	request.setCharacterEncoding("utf-8");  
	String memId = request.getParameter("memId");
	int num = memberDao.delMember(memId);

	response.sendRedirect(request.getContextPath() + "/MemList.jsp");
%>
