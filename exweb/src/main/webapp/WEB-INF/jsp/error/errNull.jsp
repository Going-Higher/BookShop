<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!-- page 디렉티브의 isErrorPage 속성을 "true"로 설정하면,
현재 JSP 파일이 에러 발생시 실행되는 JSP 파일이라는 것을 의미하고, 
JSP의 exception 기본객체에서 발생한 에러정보에 접근이 가능하다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
	<h1>NULL</h1>
	<%=exception %>
	${pageContext.exception}
</body>
</html>