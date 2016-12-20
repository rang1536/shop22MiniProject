<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionId=='������'}">
			<div class="container">
				<form>
					<table class="table">
						<thead>
							<tr>
								<th>ī�װ�</th>
								<th>��ǰ��</th>
								<th>����</th>
								<th>����</th>
								<th>������</th>
								<th>�̹���</th>
								<th>��ǰ����</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sg" items="${searchGoods}">
								<tr>
									<td>${sg.goodsCate}</td>
									<td>${sg.goodsName}</td>
									<td>${sg.goodsPrice}</td>
									<td>${sg.goodsColor}</td>
									<td>${sg.goodsSize}</td>
									<td>${sg.goodsImg}</td>
									<td><a
										href="<c:url value="/goods/gDelete.goo?goodsNum=${sg.goodsNum}"/>">����Ʈ</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</c:when>


		<c:when test="${sessionId=='�Ǹ���'}">
			<div class="container">
				<form>
					<table class="table">
						<thead>
							<tr>
								<th>ī�װ�</th>
								<th>��ǰ��</th>
								<th>����</th>
								<th>����</th>
								<th>������</th>
								<th>�̹���</th>
								<th>��ǰ����</th>
								<th>��ǰ����</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sg" items="${searchGoods}">
								<tr>
									<td>${sg.goodsCate}</td>
									<td>${sg.goodsName}</td>
									<td>${sg.goodsPrice}</td>
									<td>${sg.goodsColor}</td>
									<td>${sg.goodsSize}</td>
									<td>${sg.goodsImg}</td>
									<td><a
										href="<c:url value="/goods/GUpdateForm.goo?goodsNum=${sg.goodsNum}"/>">������Ʈ</a></td>
									<td><a
										href="<c:url value="/goods/gDelete.goo?goodsNum=${sg.goodsNum}"/>">����Ʈ</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</c:when>


		<c:otherwise>
			<div class="container">
				<form>
					<table class="table">
						<thead>
							<tr>
								<th>ī�װ�</th>
								<th>��ǰ��</th>
								<th>����</th>
								<th>����</th>
								<th>������</th>
								<th>�̹���</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sg" items="${searchGoods}">
								<tr>
									<td>${sg.goodsCate}</td>
									<td>${sg.goodsName}</td>
									<td>${sg.goodsPrice}</td>
									<td>${sg.goodsColor}</td>
									<td>${sg.goodsSize}</td>
									<td>${sg.goodsImg}</td>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</c:otherwise>
	</c:choose>


</body>
</html>