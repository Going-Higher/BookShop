<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>계산결과 : ${myValue.x} + ${myValue.y} = ${myValue.sum}</h1>
	<h1>현재서버시간 : <fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 HH시 mm분"/></h1>	
</body>
</html>