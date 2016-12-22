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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		
	});



</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>상품검색</h2>
		
		
		<form class="form-inline" action="<c:url value="/goods/gSearchForm.goo"/>" method="post">
			<div class="form-group">
				<label for="goodsCate">카테고리</label> <input type="text"
					class="form-control" id="goodsCate" name="goodsCate" placeholder="카테고리를 입력하세요">
			</div>
			<div class="form-group">
				<label for="goodsName">상품명</label> <input type="text"
					class="form-control" id="goodsName" name="goodsName" placeholder="상품명을 입력하세요">
			</div>
	
			<button type="submit" class="btn btn-default">Submit</button>
		</form>

	</div>



</body>
</html>