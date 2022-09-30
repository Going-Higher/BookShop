<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	$(function(){//문서 로드가 완료된 후 실행
		var idChecked = false;//아이디중복확인여부
		
		$('#memForm').on('submit', function(e){//id=memForm인 폼 엘리먼트 제출(submit)시 실행
			if(!idChecked) {
				alert('아이디 중복확인이 필요합니다.');
				return false;
			}
			if($('#memPass').val() != $('#memPassCheck').val()) {
				alert('비밀번호 입력이 서로 다릅니다.')
				return false;//e.preventDefault();		
			}
		});	
		$('#dupBtn').on('click', function() {
			$.ajax({
				url: "${pageContext.request.contextPath}/bbs/check.do",
				method: "post",
				data: { memId: $('#memId').val() },
				dataTypes: 'json',
			}).done(function(resp) {
				console.log(resp);
				idChecked = resp.result;
				if(resp.result) {//사용가능한 아이디
					alert('사용가능한 아이디입니다.');
// 					$('#saveBtn').prop('disabled', false);
// 					$('#dupBtn').prop('disabled', true);
				} else {//이미 존재하는 아이디
					alert('이미 존재하는 아이디입니다.');
// 					$('#saveBtn').prop('disabled', true);					
// 					$('#dupBtn').prop('disabled', false);					
				}
			}).fail(function(jqXHR,textStatus) {
				alert('아이디 중복 확인 요청 실패');
			});
		});
		
		$('#memId').on('change', function() {
			idChecked = false;
// 			$('#saveBtn').prop('disabled', true);					
// 			$('#dupBtn').prop('disabled', false);	
		});
		
	});
</script>

<div class="row">
	<div class="col">
		<h1>게시글등록</h1>
		<form:form modelAttribute="bbsVo" id="memForm" action="${pageContext.request.contextPath}/bbs/add.do" method="post">
			<div class="mb-3">
				<form:label path="bbsTitle" class="form-label">제목</form:label> 
				<form:input path="bbsTitle" class="form-control" cssErrorClass="form-control is-invalid" />
				<form:errors path="bbsTitle" cssClass="invalid-feedback" />
			</div>
			<div class="mb-3">
				<form:label path="bbsContent" class="form-label">내용</form:label> 
				<form:textarea path="bbsContent" rows="5" class="form-control" cssErrorClass="form-control is-invalid"/>
				<form:errors path="bbsContent" cssClass="invalid-feedback" />
			</div>
			<button type="submit" id="saveBtn" class="btn btn-primary"><i class="bi-file-arrow-up"></i> 저장</button>
			<a href="${pageContext.request.contextPath}/bbs/list.do">
				<button type="button" class="btn btn-primary"><i class="bi-plus-circle"></i> 목록</button>
			</a>
		</form:form>
	</div>
</div>