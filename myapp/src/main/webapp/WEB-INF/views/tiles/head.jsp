<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
      	<c:if test="${loginUser != null}">
	        <a class="nav-link" href="${pageContext.request.contextPath}/member/list.do">회원관리</a>
    	    <a class="nav-link" href="${pageContext.request.contextPath}/bbs/list.do">게시판</a>
        	<a class="nav-link" href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
        	<a class="nav-link disabled">${sessionScope.loginUser.memName}</a>
      	</c:if>
      	
        <c:if test="${loginUser == null}">
	        <a class="nav-link" href="${pageContext.request.contextPath}/member/login.do">로그인</a>
	        <a class="nav-link" href="${pageContext.request.contextPath}/member/add.do">회원가입</a>
        </c:if>
      </div>
    </div>
  </div>
</nav>