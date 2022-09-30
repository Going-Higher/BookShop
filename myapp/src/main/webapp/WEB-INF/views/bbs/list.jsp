<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col">
	<h1>게시글목록</h1>
	<a href="${pageContext.request.contextPath}/bbs/add.do">
		<button type="button" class="btn btn-primary"><i class="bi-plus-circle"></i> 등록</button>
	</a>
	<table class="table table-hover">
		<thead>
			<tr><th>제목</th><th>작성자</th><th>등록일</th></tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${bbsList}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/bbs/edit.do?bbsNo=${vo.bbsNo}"><c:out value="${vo.bbsTitle}" /></a></td><!-- c:out 태그로 보안 강화 -->
					<td><c:out value="${vo.bbsWriter}" /></td>
					<td>${vo.bbsReqDate}</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
