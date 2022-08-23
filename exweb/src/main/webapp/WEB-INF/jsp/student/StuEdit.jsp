<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
<style>table{border : 1px solid black</style>	
</head>
<body>
<h1>학생정보변경<h1>
<form action='${pageContext.request.contextPath}/student/edit.do' method='post'>
	학생번호 : <input type = 'text' name='stuNo' value="${stuVo.stuNo}" readonly="readonly"/><br>
	학생이름 : <input type = 'text' name='stuName' value="${stuVo.stuName}"/><br>
	학생점수 : <input type = 'text' name='stuScore' value="${stuVo.stuScore}"/><br>
		
<input type='submit'/>
</form>
		
	
</body>
</html>