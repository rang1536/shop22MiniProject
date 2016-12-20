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

		<h2>상품입력</h2>
		<form class="form-inline" action="<c:url value="/goods/gInsertAction.goo"/>" method="post"
		>
			<div class="form-group">
				<label for="goodsMemberId">등록자명:</label> <input type="text"
					class="form-control" id="goodsMemberId" name="goodsMemberId" placeholder="등록자명">
					<!-- 나중에 member테이블에서 id값 받아와서 readonly추가할 예정 -->
			</div>
			<div class="form-group">
				<label for="goodsName">상품명:</label> <input type="text"
					class="form-control" id="goodsName" name="goodsName" placeholder="상품명">
			</div>
			<div class="form-group">
				<label for="goodsCate">상품분류:</label>
				<select name="goodsCate">
					<option value="shoes" >신발</option>
					<option value="top" >상의</option>
					<option value="pants">바지</option>
				</select>
			</div>
			<div class="form-group">
				<label for="goodsPrice">상품가격:</label> <input type="text"
					class="form-control" id="goodsPrice" name="goodsPrice"  placeholder="상품가격">
			</div>
			<div class="form-group">
				<label for="goodsColor">상품색:</label>
					<select name="goodsColor">
					<option value="red" >빨강</option>
					<option value="blue" >파랑</option>
					<option value="green">녹색</option>
				</select>
			</div>
			<div class="form-group">
				<label for="goodsSize">상품사이즈:</label> <input type="text"
					class="form-control" id="goodsSize" name="goodsSize"  placeholder="상품사이즈">
			</div>
			<div class="form-group">
				<label for="goodsAmount">상품수량:</label> <input type="text"
					class="form-control" id="goodsAmount" name="goodsAmount"  placeholder="상품수량">
			</div>
			<div class="form-group">
				<label for="goodsImg">상품이미지:</label> <input type="file"
					class="form-control" id="goodsImg" name="goodsImg"  placeholder="상품이미지">
			</div>
			<div class="form-group">
				<label for="goodsDetail">상세입력:</label> <br />
				<textarea id="goodsDetail" rows="5" cols="30" name="goodsDetail"></textarea>
			</div>

			<button type="submit" id="btn" class="btn btn-default">Submit</button>
		</form>






	</div>



</body>
</html>