<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<!-- 전송버튼을 클릭하면, -->
<!-- 이클립스 콘솔에 선택한 음식들이 출력 (pizza, sand, spa) -->
<!-- 웹 브라우저 화면에 선택한 음식들이 리스트(<li>) 엘리먼트들로 출력 -->
				
<%-- <form action="<c:url value="/test.do" />"> --%>
<form id="testForm" action="${pageContext.request.contextPath}/test.do" method="post">
	x : <input type="text" name="x" /> <br/>
	y : <input type="text" name="y" /> <br/>
	<p>음식주문</p>
	<input type="checkbox" name="food" value="pizza"/> 피자
	<input type="checkbox" name="food" value="sand"/> 샌드위치
	<input type="checkbox" name="food" value="spa"/> 스파게티
	<br />
	<p>자격증</p>
	<table id="licTable" border="1">
		<thead>
			<tr><th>자격이름</th><th>발급기관</th><th>발급일</th><th></th></tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text" name="licenseName" /></td>
				<td><input type="text" name="licenseOrg" /></td>
				<td><input type="date" name="licenseDate" /></td>
				<td><button class="delBtn" type="button">삭제</button></td>
			</tr>			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4"><button id="addBtn" type="button">추가</button></td>
			</tr>
		</tfoot>
	</table>	
	<input type="submit" value="전송" />
</form>

<!-- template -->
<!-- 화면에 출력되지 않지만, 이후 동적으로 화면에 추가할 엘리먼트를 정의하기 위하여 사용 -->
<!-- 구버전의 브라우저에서는 지원하지 않으며,  -->
<!-- 자바스크립트에서 템플릿 내용은 template 엘리먼트의 content 속성을 통해서 사용 -->
<template id="rowTemp">
	<tr>
		<td><input type="text" name="licenseName" /></td>
		<td><input type="text" name="licenseOrg" /></td>
		<td><input type="date" name="licenseDate" /></td>
		<td><button class="delBtn" type="button">삭제</button></td>
	</tr>
</template>

<script type="text/javascript">
	
	//추가버튼을 클릭하면, 자격증 1개 정보를 입력할 수 있는 <tr>을 <tbody>에 추가
// 	var $row = $('#licTable > tbody > tr').clone();
	var $row = $(document.querySelector('#rowTemp').content)
// 	$('#addBtn').click(function(){ });			
	$('#addBtn').on('click', function(){
// 		var row = '<tr>'
// 			+ '<td><input type="text" name="licenseName" /></td>'
// 			+ '<td><input type="text" name="licenseOrg" /></td>'
// 			+ '<td><input type="date" name="licenseDate" /></td>'
// 			+ '<td><button class="delBtn" type="button">삭제</button></td>'
// 			+ '</tr>';
		var row = $row.clone();
		$('#licTable tbody').append(row);
	});	
	
	//삭제버튼을 클릭하면, 클릭한 삭제버튼이 속한 <tr>을 삭제	
	$('#licTable').on('click','.delBtn', function(){
		$(this).closest('tr').remove();	
	});
	
	//전송버튼을 클릭하면, 입력한 자격증 정보들이 올바른 파라미터명으로 전송
	$('#testForm').on('submit', function(ev){ //testForm에 submit이벤트가 발생하면 실행
// 		ev.preventDefault(); //submit 이벤트에 대한 브라우저 기본동작(폼제출) 취소
		$('#licTable > tbody >tr').each(function(idx, elm) { //tbody의 tr마다 한번씩 함수 실행
			console.log(idx,elm);
			$(elm).find('input').each(function(i, e) { //tr 내부의 각 input마다 한번씩 함수 실행
				var n = $(e).prop('name'); //input의 원래 name 속성값
				$(e).prop('name', 'license[' + idx + '].' + n); //input의 name 속성값 변경
			});			
		});
	});
</script>
</body>
</html>
