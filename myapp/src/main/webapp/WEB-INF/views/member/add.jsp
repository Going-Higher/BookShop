<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-icons-1.9.1/bootstrap-icons.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<title>회원관리</title>
<script type="text/javascript">
// 	(1) 회원등록 폼을 제출(submit)할 때, 비밀번호와 비밀번호확인 값이 다르면 안내메시지를 출력하고 제출하지 않도록 구현
// 	(2) 회원등록 폼을 제출(submit)할 때, 중복확인을 성공한 적이 없으면 안내메시지를 출력하고 제출하지 않도록 구현
// 	(3) 중복확인 버튼을 클릭하면 
// 		입력한 아이디가 데이터베이스에 없는 경우, 저장 버튼을 활성화(중복확인 버튼을 비활성화)
// 		입력한 아이디가 데이터베이스에 이미 있는 경우, 저장 버튼을 비활성화(disalbed)
// 	(4) 회원아이디 값을 변경한 경우에는 다시 중복확인을 하도록 구현(중복확인 버튼을 활성화, 저장 버튼을 비활성화)
	
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
				url: "${pageContext.request.contextPath}/member/check.do",
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
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>회원등록</h1>
				<form id="memForm" action="${pageContext.request.contextPath}/member/add.do" method="post">
					<div class="mb-3">
						<label for="memId" class="form-label">아이디</label> 
						<div class="input-group">
							<input type="text" name="memId" class="form-control" id="memId">
							<button type="button" id="dupBtn" class="btn btn-primary">중복확인</button>
						</div>
					</div>
					<div class="mb-3">
						<label for="memPass" class="form-label">비밀번호</label> 
						<input type="password" name="memPass" class="form-control" id="memPass">
					</div>
					<div class="mb-3">
						<label for="memPassCheck" class="form-label">비밀번호확인</label> 
						<input type="password" class="form-control" id="memPassCheck">
					</div>
					<div class="mb-3">
						<label for="memName" class="form-label">이름</label> 
						<input type="text" name="memName" class="form-control" id="memName">
					</div>
					<div class="mb-3">
						<label for="memPoint" class="form-label">포인트</label> 
						<input type="text" name="memPoint" class="form-control" id="memPoint">
					</div>
					<button type="submit" id="saveBtn" class="btn btn-primary"><i class="bi-file-arrow-up"></i> 저장</button>
					<a href="${pageContext.request.contextPath}/member/list.do">
						<button type="button" class="btn btn-primary"><i class="bi-plus-circle"></i> 회원목록</button>
					</a>
				</form>
			</div>
		</div>
	</div>
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>