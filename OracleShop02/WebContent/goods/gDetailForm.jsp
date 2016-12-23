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
	<c:choose>
		<c:when test="${sessionScope.sessionLevel eq '관리자'}">
			<h1>상품상세보기</h1>
			<br/>
			<form>
				<table class="table">
					<thead>
						<tr>
							<th>이미지</th>
							<th>판매자명</th>
							<th>상품명</th>
							<th>가격</th>
							<th>색상</th>
							<th>사이즈</th>
							<th>상품등록일</th>
							<th>잔여수량</th>
							<th>상세정보</th>
							<th>상품삭제</th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><img src="<c:url value='/imgFile/'/>${goods.goodsImg}"></td>
							<td>${goods.goodsMemberId}</td>
							<td>${goods.goodsName}</td>
							<td>${goods.goodsPrice}</td>
							<td>${goods.goodsColor}</td>
							<td>${goodsSizeName}</td>
							<td>${goods.goodsDate}</td>
							<td>${goods.goodsAmount}</td>
							<td>${goods.goodsDetail}</td>
							<td><a href="<c:url value="/goods/gDelete.goo?goodsNum=${goods.goodsNum}"/>">삭제</a></td>
						</tr>
					</tbody>
				</table>
				
			</form>
		</c:when>
			
		<c:when test="${sessionScope.sessionLevel eq '판매자'}">
				<h1>상품상세보기</h1>
				<br/>
				<form>
					<table class="table">
						<thead>
							<tr>
								<th>이미지</th>
								<th>판매자명</th>
								<th>상품명</th>
								<th>가격</th>
								<th>색상</th>
								<th>사이즈</th>
								<th>상품등록일</th>
								<th>잔여수량</th>
								<th>상세정보</th>
								<th>상품수정</th>
								<th>상품삭제</th>
								
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><img src="<c:url value='/imgFile/'/>${goods.goodsImg}"></td>
								<td>${goods.goodsMemberId}</td>
								<td>${goods.goodsName}</td>
								<td>${goods.goodsPrice}</td>
								<td>${goods.goodsColor}</td>
								<td>${goodsSizeName}</td>
								<td>${goods.goodsDate}</td>
								<td>${goods.goodsAmount}</td>
								<td>${goods.goodsDetail}</td>
								<td><a href="<c:url value="/goods/GUpdateForm.goo?goodsNum=${goods.goodsNum}"/>">수정</a></td>
								<td><a href="<c:url value="/goods/gDelete.goo?goodsNum=${goods.goodsNum}"/>">삭제</a></td>
							</tr>
						</tbody>
					</table>
				
				</form>
			</c:when>
			<c:otherwise>
					<h1>상품상세보기</h1>
					<br/>
					<form>
						<table class="table">
							<thead>
								<tr>
									<th>이미지</th>
									<th>판매자명</th>
									<th>상품명</th>
									<th>가격</th>
									<th>색상</th>
									<th>사이즈</th>
									<th>상품등록일</th>
									<th>잔여수량</th>
									<th>상세정보</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><img src="<c:url value='/imgFile/'/>${goods.goodsImg}"></td>
									<td>${goods.goodsMemberId}</td>
									<td>${goods.goodsName}</td>
									<td>${goods.goodsPrice}</td>
									<td>${goods.goodsColor}</td>
									<td>${goodsSizeName}</td>
									<td>${goods.goodsDate}</td>
									<td>${goods.goodsAmount}</td>
									<td>${goods.goodsDetail}</td>
							</tr>
						</tbody>
					</table>
					<div>
						<a href="<c:url value="/OInsert.ord?goodsNum=${goods.goodsNum}"/>">주문하기</a>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</div>


</body>
</html>