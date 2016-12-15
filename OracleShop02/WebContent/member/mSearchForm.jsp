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
<h3>회원검색</h3>
<div class="container">
	<form action="<c:url value='/MSearch.mem'></c:url>" class="form-inline" method="post">
		<div class="form-group">
			<select name="sk" class="form-control">
				<option value="member_id">아이디</option>
				<option value="member_level">권한</option>
				<option value="member_name">이름</option>
				<option value="member_email">이메일</option>
			</select>
		</div>
		<div class="form-group">
			<input type="text" name="sv" class="form-control">
		</div>
		<div class="form-group">
			<input type="submit" value="검색" class="btn btn-info">
		</div>
	</form>
</div>
<body>
</body>
</html>