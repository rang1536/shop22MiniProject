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
<h2>��ǰ�˻�</h2>
		<p>��ǰ�˻�</p>
		
		<form class="form-inline" action="<c:url value="/goods/gSearchForm.goo"/>" method="post">
			<div class="form-group">
			
				<label for="goodsCate">ī�װ�</label> 
				<select name="goodsCate">
					<c:forEach var="goodsCate" items="${goodsCate}">
						<option value="${goodsCate.goodsCateNum}">${goodsCate.goodsCateName}</option>
					</c:forEach>
						
				</select>
			</div>
			<div class="form-group">
				<label for="goodsName">��ǰ��</label> <input type="text"
					class="form-control" id="goodsName" name="goodsName" placeholder="��ǰ���� �Է��ϼ���">
			</div>
	
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	<c:choose>
		<c:when test="${sessionScope.sessionLevel eq '������'}">
			
				<div>
					<h1>��ǰ����Ʈ</h1>
					<br />
					<form>
						<table class="table">
							<thead>
								<tr>
									<th>�̹���</th>
									<th>��ǰ��</th>
									<th>����</th>
									<th>��ǰ����</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="goodsList" items="${goodsList}">
									<tr>
									
										<td><a href="<c:url value='/goods/gDetailForm.goo?goodsNum=${goodsList.goodsNum}'/>">
											<img src="<c:url value='/imgFile/'/>${goodsList.goodsImg}"></a>
										</td>
										<td>${goodsList.goodsName}</td>
										<td>${goodsList.goodsPrice}</td>
										<td><a href="<c:url value="/goods/gDelete.goo?goodsNum=${goodsList.goodsNum}"/>">����Ʈ</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</form>
				</div>
			
		</c:when>

		<c:when test="${sessionScope.sessionLevel eq '�Ǹ���'}">
			
			
				<div>
					<h1>��ǰ����Ʈ</h1>
					<br />
					<form>
						<table class="table">
							<thead>
								<tr>
									<th>�̹���</th>
									<th>��ǰ��</th>
									<th>����</th>
									<th>��ǰ����</th>
									<th>��ǰ����</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="goodsList" items="${goodsList}">
									<tr>
										<td><a href="<c:url value='/goods/gDetailForm.goo?goodsNum=${goodsList.goodsNum}'/>">
											<img src="<c:url value='/imgFile/'/>${goodsList.goodsImg}"></a>
										</td>
										<td>${goodsList.goodsName}</td>
										<td>${goodsList.goodsPrice}</td>
										<td><a href="<c:url value="/goods/GUpdateForm.goo?goodsNum=${goodsList.goodsNum}"/>">������Ʈ</a></td>
										<td><a href="<c:url value="/goods/gDelete.goo?goodsNum=${goodsList.goodsNum}"/>">����Ʈ</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</form>
				</div>
			
		</c:when>
		<c:otherwise>
			
			
				<div>
					<h1>��ǰ����Ʈ</h1>
					<br />
					<form>
						<table class="table">
							<thead>
								<tr>
									<th>�̹���</th>
									<th>��ǰ��</th>
									<th>����</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="goodsList" items="${goodsList}">
									<tr>
										<td><a href="<c:url value='/goods/gDetailForm.goo?goodsNum=${goodsList.goodsNum}'/>">
											<img src="<c:url value='/imgFile/'/>${goodsList.goodsImg}"></a>
										</td>
										<td>${goodsList.goodsName}</td>
										<td>${goodsList.goodsPrice}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</form>
				</div>
			
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>