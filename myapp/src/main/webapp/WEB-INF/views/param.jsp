<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 스프링 폼 태그 사용을 위한 태그 라이브러리 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 폼 태그 연습</title>
</head>
<body>
	<h2>스프링 폼 태그 사용</h2>
	<%-- <form:form> 태그 내부의 입력 요소들이 사용할 값을 담고 있는 모델 객체의 이름을 modelAttribute 속성값으로 지정 --%>
	<form:form modelAttribute="testVo" action="${pageContext.request.contextPath}/param.do">
		<!-- 각 입력요소의 값으로 사용할 모델 객체의 속성이름을 path 속성값으로 지정 -->
		점심 식사 : 
		<form:radiobuttons path="lunch" items="${codeList}" itemValue="id" itemLabel="title"/>
		<br/>
		저녁 식사 : 
		<form:select path="dinner" items="${codeList}" itemValue="id" itemLabel="title"/>
		<br/>
		좋아하는 음식들 :
		<form:checkboxes path="food" items="${codeList}" itemValue="id" itemLabel="title"/>
		<br/>
		<input type="submit" />
	</form:form>
	
	<h2>스프링 폼 태그 미사용</h2>
	<form action="" method="post">
		<!-- 라디오버튼으로 codeList에 있는 음식들을 선택할 수 있도록 구현 -->
		<!-- 현재 testVo의 lunch의 음식이 선택되어 있도록 구현 -->
		점심 식사 : 
		<!-- <input type="radio" name="lunch" value="f001" id="lunch1" /><label for="lunch1">피자</label>
		<input type="radio" name="lunch" value="f002" id="lunch2" checked="checked" /><label for="lunch2">햄버거</label>
		<input type="radio" name="lunch" value="f003" id="lunch3" /><label for="lunch3">스파게티</label> -->
		<c:forEach var="code" items="${codeList}" varStatus="stat">
			<input type="radio" name="lunch" value="${code.id}" ${code.id == testVo.lunch ? 'checked' : ''}	id="lunch${stat.count}" /><label for="lunch1">${code.title}</label>
		</c:forEach>
		<br/>
		<!-- 셀렉트로 codeList에 있는 음식들을 선택할 수 있도록 구현 -->
		<!-- 현재 testVo의 dinner의 음식이 선택되어 있도록 구현 -->
		저녁 식사 : 
		<select name="dinner">	
			<!-- <option value="f001" selected="selected">피자</option>
			<option value="f002">햄버거</option>
			<option value="f003">스파게티</option> -->
			<c:forEach var="code" items="${codeList}">
				<option value="${code.id}" ${code.id == testVo.dinner ? 'selected' : ''}>${code.title}</option>
			</c:forEach>
		</select>
		<br/>
		<!-- 체크박스로 codeList에 있는 음식들을 선택할 수 있도록 구현 -->
		<!-- 현재 testVo의 food의 음식이 선택되어 있도록 구현 -->
		좋아하는 음식들 :
		<c:forEach var="code" items="${codeList}" varStatus="stat">
			<input type="checkbox" name="food" value="${code.id}" ${testVo.food.contains(code.id) ? 'checked' : ''} id="food${stat.count}" /><label for="food">${code.title}</label>
		</c:forEach>
		<br/>
		<input type="submit" />
	</form>
</body>
</html>