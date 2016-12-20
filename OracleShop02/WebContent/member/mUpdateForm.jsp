<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$(document).ready(function(){
		$('#memberPw').focus();
		$('#updateBtn').click(function(){
			if($('#memberPw').val() == ""){
				alert("비번를 입력하세요");
				$('#memberPw').focus();
				return;
			}
			$('#updateMember').attr({action:"<c:url value='/MUpdateAction.mem'/>",method:"post"}).submit();
		});
	});
</script>
</head>
<body>
<div class="container">
<center><h1>회원가입</h1></center>
<center><h5>(*은 필수입력 사항입니다.)</h5></center>
	<form action="<c:url value='/MUpdateAction.mem' />" method="post" id="updateMember" >
		<div class="form-group">
			<label> *아이디 : </label>
			<input type="text" name="memberId" class="form-control" value="${memberList.memberId}" readonly/>
		</div>
		<div class="form-group">
			<label> *비번확인 : </label>
			<input type="password" name="memberPw" id="memberPw"class="form-control" />
		</div>
		<div class="form-group">
			<label> *이  름 : </label>
			<input type="text" name="memberName" class="form-control" value="${memberList.memberName}"/>
		</div>
		<div class="form-group">
			<label> *권  한 : </label><br/>
			<input type="text" name="memberLevel" class="form-control" value="${memberList.memberLevel}" readonly/>
		</div>
		<div class="form-group">
			<label> *성  별 : </label><br/>
			<input type="text" name="memberSex" class="form-control" value="${memberList.memberSex}" readonly/>
			
		</div>
		<div class="form-group">
			<label> *우편번호 : </label>
			<input type="text" name="memberAddn" class="form-control" value="${memberList.memberAddn}"/>
		</div>
		<div class="form-group">
			<label> *주  소 : </label>
			<input type="text" name="memberAdd" class="form-control" value="${memberList.memberAdd}"/>
		</div>
		<div class="form-group">
			<label> *상세주소 : </label>
			<input type="text" name="memberAdds" class="form-control" value="${memberList.memberAdds}"/>
		</div>
		<div class="form-group">
			<label> *이메일 : </label>
			<input type="text" name="memberEmail" class="form-control" value="${memberList.memberEmail}"/>
		</div>
		<div class="form-group">
			<label> 전화번호 : </label>
			<input type="text" name="memberPhone" class="form-control" value="${memberList.memberPhone}"/>
		</div>
		<div class="form-group">
			<label> *핸드폰 : </label>
			<input type="text" name="memberMobile" class="form-control" value="${memberList.memberMobile}"/>
		</div>
		<div class="form-group">
			<label> 마일리지 : </label>
			<input type="text" name="memberMileage" class="form-control" value="${memberList.memberMileage}" readonly/>
		</div>
		<div class="form-group">
			<input type="button" value = "회원정보수정" class="btn btn-info" id="updateBtn"/>
			<a href = "<c:url value='/MDelete.mem?memberId=${memberList.memberId}'/>" class="btn btn-info" >회원정보삭제</a> 
		</div>
	</form>
</div>
<body>
</body>
</html>