<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
<center><h3>회원검색</h3></center>
<c:choose>
	<c:when test="${sessionLevel != '관리자'}">
		<div class="container">
			<form action="<c:url value='/MSearch.mem'></c:url>" class="form-inline" method="post">
				<div class="form-group">
					<label> 이  름 : </label>
					<input type="text" name="memberName" class="form-control" />
				</div>
				<div class="form-group">
					<label> 아이디 : </label>
					<input type="text" name="memberId" class="form-control"/>
				</div>
				<div class="form-group">
					<input type="submit" value="검색" class="btn btn-info">
				</div>
			</form>
		</div>
	</c:when>
	<c:when test="${sessionLevel eq '관리자'}">
		<div class="container">
			<form action="<c:url value='/MSearch.mem'></c:url>" class="form-inline" method="post">
				<div class="form-group">
					<label> 이  름 : </label>
					<input type="text" name="memberName" class="form-control"/>
				</div>
				<div class="form-group">
					<label> 성  별 : </label><br/>
					<label class="radio-inline">
						<input type="radio" name="memberSex" value="남성"/>남성
					</label>
					<label class="radio-inline">
						<input type="radio" name="memberSex" value="여성"/>여성
					</label>
				</div>
				<div class="form-group">
					<label>가입일 :</label>
					<input type="date" name="startDay" class="form-control"/>~
					<input type="date" name="endDay" class="form-control"/>
				</div>
				<div class="form-group">
					<label> 지  역 : </label>
					<input type="text" name="memberAdd" class="form-control" placeholder="시 정보만 입력하세요"/>
				</div>
				<div class="form-group">
					<input type="submit" value="검색" class="btn btn-info">
				</div>
			</form>
		</div>
	</c:when>
</c:choose>

<body>
</body>
</html>