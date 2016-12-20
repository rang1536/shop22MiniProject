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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Insert title here</title>


</head>
<body>



	<div class="container">
	
		<h2>��ǰ����</h2>
		<form class="form-inline" action="<c:url value="/goods/GUpdateAction.goo"/>" method="post">
			<input type="hidden" name="goodsNum" value="${goods.goodsNum}"/>
			<div class="form-group">
				<label for="goodsMemberId">����ڸ�:</label> <input type="text"
					class="form-control" id="goodsMemberId" name="goodsMemberId" 
					value="${goods.goodsMemberId}"
					 readonly>
			</div>
			<div class="form-group">
				<label for="goodsName">��ǰ��:</label> <input type="text"
					class="form-control" id="goodsName" name="goodsName" placeholder="${goods.goodsName}">
			</div>
			<div class="form-group">
				<label for="goodsCate">��ǰ�з�:</label> <input type="text"
					class="form-control" id="goodsCate" name="goodsCate" placeholder="${goods.goodsCate}">
			</div>
			<div class="form-group">
				<label for="goodsPrice">��ǰ����:</label> <input type="text"
					class="form-control" id="goodsPrice" name="goodsPrice"  placeholder="${goods.goodsPrice}">
			</div>
			<div class="form-group">
				<label for="goodsColor">��ǰ��:</label> <input type="text"
					class="form-control" id="goodsColor" name="goodsColor"  placeholder="${goods.goodsColor}">
			</div>
			<div class="form-group">
				<label for="goodsSize">��ǰ������:</label> <input type="text"
					class="form-control" id="goodsSize" name="goodsSize"  placeholder="${goods.goodsSize}">
			</div>
			<div class="form-group">
				<label for="goodsAmount">��ǰ����:</label> <input type="text"
					class="form-control" id="goodsAmount" name="goodsAmount"  placeholder="${goods.goodsAmount}">
			</div>
			<div class="form-group">
				<label for="goodsImg">��ǰ�̹���:</label> <input type="file"
					class="form-control" id="goodsImg" name="goodsImg"  placeholder="${goods.goodsImg}">
			</div>
			<div class="form-group">
				<label for="goodsDetail">���Է�:</label> <br />
				<textarea id="goodsDetail" rows="5" cols="30" name="goodsDetail">${goods.goodsDetail}</textarea>
			</div>

			<button type="submit" id="btn" class="btn btn-default">����</button>
		</form>
	</div>



</body>
</html>