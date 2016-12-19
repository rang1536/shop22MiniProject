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
<center><h3>ȸ���˻�</h3></center>
<c:choose>
	<c:when test="${sessionLevel != '������'}">
		<div class="container">
			<form action="<c:url value='/MSearch.mem'></c:url>" class="form-inline" method="post">
				<div class="form-group">
					<label> ��  �� : </label>
					<input type="text" name="memberName" class="form-control" />
				</div>
				<div class="form-group">
					<label> ���̵� : </label>
					<input type="text" name="memberId" class="form-control"/>
				</div>
				<div class="form-group">
					<input type="submit" value="�˻�" class="btn btn-info">
				</div>
			</form>
		</div>
	</c:when>
	<c:when test="${sessionLevel eq '������'}">
		<div class="container">
			<form action="<c:url value='/MSearch.mem'></c:url>" class="form-inline" method="post">
				<div class="form-group">
					<label> ��  �� : </label>
					<input type="text" name="memberName" class="form-control"/>
				</div>
				<div class="form-group">
					<label> ��  �� : </label><br/>
					<label class="radio-inline">
						<input type="radio" name="memberSex" value="����"/>����
					</label>
					<label class="radio-inline">
						<input type="radio" name="memberSex" value="����"/>����
					</label>
				</div>
				<div class="form-group">
					<label>������ :</label>
					<input type="date" name="startDay" class="form-control"/>~
					<input type="date" name="endDay" class="form-control"/>
				</div>
				<div class="form-group">
					<label> ��  �� : </label>
					<input type="text" name="memberAdd" class="form-control" placeholder="�� ������ �Է��ϼ���"/>
				</div>
				<div class="form-group">
					<input type="submit" value="�˻�" class="btn btn-info">
				</div>
			</form>
		</div>
	</c:when>
</c:choose>

<body>
</body>
</html>