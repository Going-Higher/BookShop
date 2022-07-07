<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>도서 등록</div>
		<div>
			<form method="post">
				<div>
					<label>도서번호:</label>
					<p>${item.bookid}</p>
				</div>
				<div>
					<label>도서명:</label>
					<input type="text" name="bookname" value="${item.bookname}">
				</div>
				<div>
					<label>출판사:</label>
					<input type="text" name="publisher" value="${item.publisher}">
				</div>
				<div>
					<label>가격:</label>
					<input type="number" name="price" value="${item.price}">
				</div>
				<div>
					<button>변경</button>
					<button type="button" onclick="history.back()">취소</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>