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
<center><h1>ȸ������Ʈ</h1></center>
<c:import url="/member/mSearchForm.jsp"></c:import>
<div class="container">
	<table class="table table-striped">
	
		<thead>
			<tr>
				<th>���̵�</th><th>��  ��</th><th>��  ��</th><th>��  ��</th>
				<th>��  ��</th><th>�̸���</th><th>�ڵ���</th><th>���ϸ���</th>
			</tr>
		</thead>
		<tbody>

		<c:forEach var="i" items="${memberlist}">

			<tr>
				<td><a href ="<c:url value="/MUpdateForm.mem?memberId=${i.memberId}"></c:url>">${i.memberId}</a></td>
				<td>${i.memberName}</td>
				<td>${i.memberLevel}</td>
				<td>${i.memberSex}</td>
				<td>${i.memberAdd}</td>
				<td>${i.memberEmail}</td>
				<td>${i.memberMobile}</td>
				<td>${i.memberMileage}</td>
			</tr>
		
		</c:forEach>

		</tbody>
	</table>
</div>
<body>
</body>
</html>