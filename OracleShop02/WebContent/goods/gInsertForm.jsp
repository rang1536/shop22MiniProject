<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Insert Goods</title>
</head>
<body>
	<div class="container">

		<h2>��ǰ�Է�</h2>
		<form class="form-inline" action="<c:url value="/goods/gInsertAction.goo"/>" method="post"
			enctype="multipart/form-data">
			<div class="form-group">
				<label for="goodsMemberId">����ڸ�:</label> 
				<input type="text" class="form-control" id="goodsMemberId" name="goodsMemberId" value="${sessionScope.sessionId}" readony/>
					
			</div>
			<div class="form-group">
				<label for="goodsName">��ǰ��:</label> 
				<input type="text" class="form-control" id="goodsName" name="goodsName" placeholder="��ǰ��">
			</div>
			<div class="form-group">
				<label for="goodsCate">��ǰ�з�:</label>
				<select name="goodsCate">
					<c:forEach var="cate" items="${cate}">
						<option value="${cate.goodsCateNum}" >${cate.goodsCateName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="goodsPrice">��ǰ����:</label> 
				<input type="text" class="form-control" id="goodsPrice" name="goodsPrice"  placeholder="��ǰ����">
			</div>
			<div class="form-group">
				<label for="goodsColor">��ǰ��:</label>
				<select name="goodsColor">
					<c:forEach var="color" items="${color}">
						<option value="${color.goodsColorNum}" >${color.goodsColorName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="goodsSize">��ǰ������:</label> 
				<select name="goodsSize">
					<c:forEach var="size" items="${size}">
						<option value="${size.goodsSizeNum}" >${size.goodsSizeName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="goodsAmount">��ǰ����:</label> 
				<input type="text" class="form-control" id="goodsAmount" name="goodsAmount"  placeholder="��ǰ����">
			</div>
			<div class="form-group">
				<label for="goodsImg">��ǰ�̹���:</label> 
				<input type="file" class="form-control" id="goodsImg" name="goodsImg"  placeholder="��ǰ�̹���">
			</div>
			<div class="form-group">
				<label for="goodsDetail">���Է�:</label> <br />
				<textarea id="goodsDetail" rows="5" cols="30" name="goodsDetail"></textarea>
			</div>
			<div class="form-group">
			<button type="submit" id="btn" class="btn btn-default">��ǰ���</button>
			</div>
		</form>
	</div>
</body>
</html>