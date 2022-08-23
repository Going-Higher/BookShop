<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시판</title>
</head>
<body>
		
<jsp:include page="/WEB-INF/views/comm/menu.jsp"/>
		
<h1>새글쓰기</h1>

<form action='${pageContext.request.contextPath}/bbs/add.do' method='post'>
<table border="1">
	<tbody>
		<tr>
			<th>제목</th>
			<td><input type= 'text' name='bbsTitle' /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="bbsContent" rows="10" cols="20"></textarea></td>
		</tr>
		<%-- <tr>
			<th>작성자</th>
			<td><input type= 'text' name='bbsWriter' value="${sessionScope.loginUser.memId}" /></td>
		</tr> --%>
	</tbody>
</table>	
	<input type='submit' value="저장"/>
</form>
		
</body>
</html>