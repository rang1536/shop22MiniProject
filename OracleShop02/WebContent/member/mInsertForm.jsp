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
</head>
<body>
<div class="container">
<center><h1>회원가입</h1></center>
<center><h5>(*은 필수입력 사항입니다.)</h5></center>
	<form action="<c:url value='/mInsertAction.mem' />" method="post" >
		<div class="form-group">
			<label> *아이디 : </label>
			<input type="text" name="memberId" class="form-control"/>
		</div>
		<div class="form-group">
			<label> *비  번 : </label>
			<input type="password" name="memberPw" class="form-control" />
		</div>
		<div class="form-group">
			<label> *이  름 : </label>
			<input type="text" name="memberName" class="form-control" />
		</div>
		<div class="form-group">
			<label> *권  한 : </label><br/>
			<label class="radio-inline">
				<input type="radio" name="memberLevel" value="관리자" />관리자
			</label>
			<label class="radio-inline">
				<input type="radio" name="memberLevel" value="구매자"/>구매자
			</label>
			<label class="radio-inline">	
				<input type="radio" name="memberLevel" value="판매자"/>판매자
			</label>
		</div>
		<div class="form-group">
			<label> *성  별 : </label><br/>
			<label class="radio-inline">
				<input type="radio" name="memberSex" value="남성"/>남성
			</label>
			<label class="radio-inline">
				<input type="radio" name="memberSex" value="여성"/>여성
			</label>
		</div>
		<div class="form-group">
			<label> *우편번호 : </label>
			<input type="text" name="memberAddn" class="form-control"/>
		</div>
		<div class="form-group">
			<label> *주  소 : </label>
			<input type="text" name="memberAdd" class="form-control"/>
		</div>
		<div class="form-group">
			<label> *상세주소 : </label>
			<input type="text" name="memberAdds" class="form-control"/>
		</div>
		<div class="form-group">
			<label> *이메일 : </label>
			<input type="text" name="memberEmail" class="form-control"/>
		</div>
		<div class="form-group">
			<label> 전화번호 : </label>
			<input type="text" name="memberPhone" class="form-control"/>
		</div>
		<div class="form-group">
			<label> *핸드폰 : </label>
			<input type="text" name="memberMobile" class="form-control"/>
		</div>
		<div class="form-group">
			<label> 마일리지 : </label>
			<input type="text" name="memberMileage" class="form-control"/>
		</div>
		<div class="form-group">
			<input type="submit" value = "회원가입" class="btn btn-info"/>
			<input type="reset" value = "다시작성" class="btn btn-info" />
		</div>
	</form>
</div>
<body>
</body>
</html>