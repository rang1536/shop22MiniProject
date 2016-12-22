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
<title>GLIST</title>
</head>
<body>

	<div class="container">
		<h1>��ǰ�󼼺���</h1>
		<br/>
		
		
		<form>
			<table class="table">
				<thead>
					<tr>
						<th>�̹���</th>
						<th>�Ǹ��ڸ�</th>
						<th>��ǰ��</th>
						<th>����</th>
						<th>����</th>
						<th>������</th>
						<th>��ǰ�����</th>
						<th>�ܿ�����</th>
						<th>������</th>
						<th>��ǰ����</th>
						<th>��ǰ����</th>
						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${goods.goodsImg}</td>
						<td>${goods.goodsMemberId}</td>
						<td>${goods.goodsName}</td>
						<td>${goods.goodsPrice}</td>
						<td>
							<select>
								<option>����</option>
								<option>����</option>
								<option>����</option>
								<option>���</option>
							</select>
						</td>
						<td>
							<select>
								<option>���ƿ�</option>
								<option>���ο�</option>
							</select>
						</td>
						<td>${goods.goodsDate}</td>
						<td>${goods.goodsAmount}</td>
						<td>${goods.goodsDetail}</td>
						<td><a href="<c:url value="/goods/GUpdateForm.goo?goodsNum=${goods.goodsNum}"/>">������Ʈ</a></td>
						<td><a href="<c:url value="/goods/gDelete.goo?goodsNum=${goods.goodsNum}"/>">����Ʈ</a></td>
					</tr>
				</tbody>
			</table>
			<a href="<c:url value='/OInsert.ord?goodsNum=${goods.goodsNum}'/>">�ֹ��ϱ�</a>
		</form>
	</div>


</body>
</html>