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
		<h2>��ǰ�˻�</h2>
		
		
		<form class="form-inline" action="<c:url value="/goods/gSearchForm.goo"/>" method="post">
			<div class="form-group">
				<label for="goodsCate">ī�װ�</label> <input type="text"
					class="form-control" id="goodsCate" name="goodsCate" placeholder="ī�װ��� �Է��ϼ���">
			</div>
			<div class="form-group">
				<label for="goodsName">��ǰ��</label> <input type="text"
					class="form-control" id="goodsName" name="goodsName" placeholder="��ǰ���� �Է��ϼ���">
			</div>
	
			<button type="submit" class="btn btn-default">Submit</button>
		</form>

	</div>



</body>
</html>