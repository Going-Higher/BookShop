<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<c:if test="${loginUser == null}">
		<a href="${pageContext.request.contextPath}/member/login.do">로그인</a> |
		<a href="${pageContext.request.contextPath}/member/add.do">회원가입</a>
	</c:if>
	<c:if test="${loginUser != null}">
		<c:out value="${loginUser.memName}"/> 님
		<a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
	</c:if>
	<hr />
</div>
</body>
</html>