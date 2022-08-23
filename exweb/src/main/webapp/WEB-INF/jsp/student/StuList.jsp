<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset='UTF-8'>
	<title>Insert title here</title>		
	</head>
	<body>
	<h1>학생목록<h1>		
	
	<a href='${pageContext.request.contextPath}/student/add.do'>학생추가</a><br>
	
	<table border=1><tr align='center' bgcolor='lightgreen'>
	<td>학생번호</td><td>학생이름</td><td>학생점수</td><td>삭제</td></tr>		
 		<c:forEach var="vo" items="${stulist}">	
 		<tr align="center">
 			<td><a href="${pageContext.request.contextPath}/student/edit.do?stuNo=${vo.stuNo}"><c:out value="${vo.stuNo}"/></a></td> 			
 			<td><c:out value="${vo.stuName}"/></td>
 			<td><c:out value="${vo.stuScore}"/></td>
			<td><a href='${pageContext.request.contextPath}/student/del.do?stuNo=${vo.stuNo}'>삭제</a></td>
		</tr>
		</c:forEach>
	</table>
	</body>
	</html>