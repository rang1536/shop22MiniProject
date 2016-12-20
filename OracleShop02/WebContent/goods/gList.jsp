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
	세션값 확인 : ${sessionId}
	<c:choose>
		<c:when test="${sessionId =='관리자'}">
			<div class="container">
				<div>
					<c:import url="gSearchForm.jsp"></c:import>
				</div>
				<div>
					<h1>상품리스트</h1>
					<br />
					<form>
						<table class="table">
							<thead>
								<tr>
									<th>이미지</th>
									<th>상품명</th>
									<th>가격</th>
									<th>상품삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="goodsList" items="${goodsList}">
									<tr>
									
										<td><a
											href="<c:url value="/goods/gDetailForm.goo?goodsNum=${goodsList.goodsNum}"/>">
											<img src="../imgFile/${goodsList.goodsImg}">
											</a></td>
										<td>${goodsList.goodsName}</td>
										<td>${goodsList.goodsPrice}</td>
										<td><a
											href="<c:url value="/goods/gDelete.goo?goodsNum=${goodsList.goodsNum}"/>">딜리트</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</form>
				</div>
			</div>
		</c:when>

		<c:when test="${sessionId=='판매자'}">
			<div class="container">
				<div>
					<c:import url="gSearchForm.jsp"></c:import>
				</div>
				<div>




					<h1>상품리스트</h1>
					<br />
					<form>
						<table class="table">
							<thead>
								<tr>
									<th>이미지</th>
									<th>상품명</th>
									<th>가격</th>
									<th>상품수정</th>
									<th>상품삭제</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="goodsList" items="${goodsList}">
									<tr>
										<td><a
											href="<c:url value="/goods/gDetailForm.goo?goodsNum=${goodsList.goodsNum}"/>">${goodsList.goodsImg}</a></td>
										<td>${goodsList.goodsName}</td>
										<td>${goodsList.goodsPrice}</td>
										<td><a
											href="<c:url value="/goods/GUpdateForm.goo?goodsNum=${goodsList.goodsNum}"/>">업데이트</a></td>
										<td><a
											href="<c:url value="/goods/gDelete.goo?goodsNum=${goodsList.goodsNum}"/>">딜리트</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</form>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="container">
				<div>
					<c:import url="gSearchForm.jsp"></c:import>
				</div>
				<div>


					<h1>상품리스트</h1>
					<br />
					<form>
						<table class="table">
							<thead>
								<tr>
									<th>이미지</th>
									<th>상품명</th>
									<th>가격</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="goodsList" items="${goodsList}">
									<tr>
										<td><a
											href="<c:url value="/goods/gDetailForm.goo?goodsNum=${goodsList.goodsNum}"/>">${goodsList.goodsImg}</a></td>
										<td>${goodsList.goodsName}</td>
										<td>${goodsList.goodsPrice}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>