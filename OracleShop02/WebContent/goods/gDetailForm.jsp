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
						<td>${goods.goodsImg}</td>
						<td>${goods.goodsMemberId}</td>
						<td>${goods.goodsName}</td>
						<td>${goods.goodsPrice}</td>
						<td>
							<select>
								<option>색상</option>
								<option>빨강</option>
								<option>검정</option>
								<option>노랑</option>
							</select>
						</td>
						<td>
							<select>
								<option>유아용</option>
								<option>성인용</option>
							</select>
						</td>
						<td>${goods.goodsDate}</td>
						<td>${goods.goodsAmount}</td>
						<td>${goods.goodsDetail}</td>
						<td><a href="<c:url value="/goods/GUpdateForm.goo?goodsNum=${goods.goodsNum}"/>">업데이트</a></td>
						<td><a href="<c:url value="/goods/gDelete.goo?goodsNum=${goods.goodsNum}"/>">딜리트</a></td>
					</tr>
				</tbody>
			</table>
			<a href="<c:url value='/OInsert.ord?goodsNum=${goods.goodsNum}'/>">주문하기</a>
		</form>
	</div>


</body>
</html>