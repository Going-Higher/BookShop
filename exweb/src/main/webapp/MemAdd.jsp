add.jsp


<%@page import="com.exam.exspring.member.MemberVo"%>
<%@page import="com.exam.exspring.member.MemberDaoJdbc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!MemberDaoJdbc memberDao = new MemberDaoJdbc();%>    

<%
    request.setCharacterEncoding("utf-8");
    MemberVo vo = new MemberVo();
    vo.setMemId(request.getParameter("memId"));
    vo.setMemPass(request.getParameter("mempass"));
    vo.setMemName(request.getParameter("memname"));
    vo.setMemPoint(Integer.parseInt(request.getParameter("mempoint")));
    int num =memberDao.insertMember(vo);

    //resp.sendredirect("이동할 사이트주소"): 명령을 사용하여
    // 웹브라우저에게 특정 사이트로 이동하라는 명령을 담은 응답을 전송

    response.sendRedirect( request.getContextPath() + "/MemList.jsp");
    %>