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
<center><h1>결제 확인</h1></center>
<div>
	<table border="1" align="center"> 
		<tr>
			<td>
				주문하신 내용 최종 결제금액은 ${orderPayFinal}원 입니다<br/>
				마일리지 금액은  선택하신대로<br/>
				${choiceMileage}해드리겠습니다.
				감사합니다
			</td>
		</tr>
	</table>>
	<div class="form-group" align="center">
		<a href="<c:url value='/goods/gList.goo'/>" class="btn btn-primary">상품리스트</a>
		<a href="<c:url value='/OUpdateForm.ord'/>" class="btn btn-primary">주문확인/주문수정</a>
	</div>
</div>
</body>
</html>