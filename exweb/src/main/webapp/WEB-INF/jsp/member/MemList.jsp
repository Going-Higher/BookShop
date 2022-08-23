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

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>


<h1>회원목록<h1>
	
<a href='${pageContext.request.contextPath}/member/add.do'>회원추가</a><br>
<a href='<c:url value="/member/add.do"/>'>회원추가</a><br>

회원아이디 : 회원이름 : 회원포인트<br>
<c:forEach var="vo" items="${memList}">
	<a href="${pageContext.request.contextPath}/member/edit.do?memId=${vo.memId}"><c:out value="${vo.memId}"/></a>
	: <c:out value="${vo.memName}"/> : ${vo.memPoint}
	<a href='${pageContext.request.contextPath}/member/del.do?memId=${vo.memId}'>삭제</a><br>
</c:forEach>
 		
</body>
</html>
