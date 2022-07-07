<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>도서 목록</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>도서번호</th>
						<th>도서명</th>
						<th>출판사</th>
						<th>가격</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="5">검색된 도서가 없습니다</td>
						</tr>					
					</c:if>
					
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.bookid}</td>
							<td>${item.bookname}</td>
							<td>${item.publisher}</td>
							<td>${item.price}</td>
							<td><a href="update/${item.bookid}">변경</a> <a href="delete/${item.bookid}">삭제</a></td>
						</tr>					
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<ul>
								<li><a href="?page=1">처음</a></li>
								<li><a href="?page=${pager.prev}">이전</a></li>
								
								<c:forEach var="page" items="${pager.list}">
									<li><a href="?page=${page}">${page}</a></li>
								</c:forEach>
								
								<li><a href="?page=${pager.next}">다음</a></li>
								<li><a href="?page=${pager.last}">마지막</a></li>
							</ul>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div>
			<a href="add">등록</a>
		</div>
		
		<div>
			<a href="dummy">대량 등록</a>
		</div>
		
		<div>
			<a href="init">초기화</a>
		</div>
		
	</div>
</body>
</html>