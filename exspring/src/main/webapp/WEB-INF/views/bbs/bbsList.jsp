<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시판</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
</head>
<body>

<jsp:include page="/WEB-INF/views/comm/menu.jsp"/>

<h1>게시판목록<h1>
	
<%-- <a href='${pageContext.request.contextPath}/bbs/add.do'>새글쓰기</a><br> --%>
<a href='<c:url value="/bbs/add.do"/>'><button type="button">새글쓰기</button></a><br>

<form action="${pageContext.request.contextPath}/bbs/list.do">
	<select name="searchType">
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="total">제목+내용</option>
	</select>
	<script type="text/javascript">
		if ('${searchInfo.searchType}') {
			//document.querySelector('[name="searchType"]').value = '${searchInfo.searchType}';
			$('[name="searchType"]').val( '${searchInfo.searchType}' );			
		}
	</script>
	<input type="text" name="searchWord" value="${searchInfo.searchWord}" placeholder="검색어를 입력하세요"/>
	<input type="submit" value="검색" />
</form>

<table border="1">
	<thead>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${bbsList}">	
			<tr>
				<td>${vo.bbsNo}</td>
				<td><a href="${pageContext.request.contextPath}/bbs/edit.do?bbsNo=${vo.bbsNo}"><c:out value="${vo.bbsTitle}"/></a></td> 
				<td><c:out value="${vo.bbsWriter}"/></td> 
				<td><fmt:formatDate value="${vo.bbsReqDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
 		
</body>
</html>
