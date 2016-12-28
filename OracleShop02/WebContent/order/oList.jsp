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
<c:choose>
	<c:when test="${sessionScope.sessionLevel eq '관리자'}">
		<div>
			<center>
				<h1>주문리스트</h1>
			</center>
			<br />
			<form action="<c:url value='/OUpdateForm.ord'/>" method="post"> 
				<table class="table">
					<thead>
						<tr>
							<th>이미지</th>
							<th>상품명</th>
							<th>결제가격</th>
							<th>처리상태</th>
							<th>처리결과실행</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="orderList" items="${orderList}">
							<tr>
								<td>
									<img src="<c:url value='/imgFile/'/>${orderList.orderImg}">
								</td>
								<td>${orderList.orderGoodsName}</td>
								<td>${orderList.orderPayFinal}</td>
								<td>
									<select name="tradeState">
										<option value="상품준비중"></option>
										<option value="배송중"></option>
										<option value="주문거래완료"></option>
									</select>
								</td>
								<td><input type="submit" value="처리상태갱신" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</c:when>
	<c:when test="${sessionScope.sessionLevel eq '구매자'}">
		<div>
			<center>
				<h1>주문리스트</h1>
				<h4>상품이미지를 클릭하시면 주문수정페이지로 이동됩니다.</h4>
			</center>
			<br />
			<form>
				<table class="table">
					<thead>
						<tr>
							<th>이미지</th>
							<th>상품명</th>
							<th>결제가격</th>
							<th>처리상태</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="orderList" items="${orderList}">
							<tr>
								<td><a href="<c:url value='/OUpdateForm.ord?orderNum=${orderList.orderNum}'/>">
									<img src="<c:url value='/imgFile/'/>${orderList.orderImg}"></a>
								</td>
								<td>${orderList.orderGoodsName}</td>
								<td>${orderList.orderPayFinal}</td>
								<td>${orderList.orderTradeState}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</c:when>
</c:choose>

</body>
</html>