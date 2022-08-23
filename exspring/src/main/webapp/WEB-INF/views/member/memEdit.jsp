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

<%-- <jsp:include page="/WEB-INF/jsp/menu.jsp"/> --%>

<h1>회원정보변경<h1>
	
<form action='${pageContext.request.contextPath}/member/edit.do' method='post'>
아이디 : <input type = 'text' name='memId' value="${memVo.memId}" readonly="readonly"/><br>
이름 : <input type = 'text' name='memName' value="${memVo.memName}" /><br>
포인트 : <input type = 'text' name='memPoint' value="${memVo.memPoint}"/>	<br>	
	<input type='submit'/>	

</form>
				
</body>
</html>