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
	<form action="<c:url value='/MDeleteAction.mem' />" method="post" >
		<div class="form-group">
			<label> *아이디 : </label>
			<input type="text" name="memberId" class="form-control" value="${memberList.memberId}" readonly/>
		</div>
		<div class="form-group">
			<label> *비번확인 : </label>
			<input type="password" name="memberPw" id="memberPw"class="form-control" />
		</div>
		<div class="form-group">
			<input type="submit" value = "회원삭제" class="btn btn-info"/>
		</div>
	</form>
</div>
<body>
</body>
</html>