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
<div class="container">
<center><h1>ȸ������</h1></center>
<center><h5>(*�� �ʼ��Է� �����Դϴ�.)</h5></center>
	<form action="<c:url value='/mInsertAction.mem' />" method="post" >
		<div class="form-group">
			<label> *���̵� : </label>
			<input type="text" name="memberId" class="form-control"/>
		</div>
		<div class="form-group">
			<label> *��  �� : </label>
			<input type="password" name="memberPw" class="form-control" />
		</div>
		<div class="form-group">
			<label> *��  �� : </label>
			<input type="text" name="memberName" class="form-control" />
		</div>
		<div class="form-group">
			<label> *��  �� : </label><br/>
			<label class="radio-inline">
				<input type="radio" name="memberLevel" value="������" />������
			</label>
			<label class="radio-inline">
				<input type="radio" name="memberLevel" value="������"/>������
			</label>
			<label class="radio-inline">	
				<input type="radio" name="memberLevel" value="�Ǹ���"/>�Ǹ���
			</label>
		</div>
		<div class="form-group">
			<label> *��  �� : </label><br/>
			<label class="radio-inline">
				<input type="radio" name="memberSex" value="����"/>����
			</label>
			<label class="radio-inline">
				<input type="radio" name="memberSex" value="����"/>����
			</label>
		</div>
		<div class="form-group">
			<label> *�����ȣ : </label>
			<input type="text" name="memberAddn" class="form-control"/>
		</div>
		<div class="form-group">
			<label> *��  �� : </label>
			<input type="text" name="memberAdd" class="form-control"/>
		</div>
		<div class="form-group">
			<label> *���ּ� : </label>
			<input type="text" name="memberAdds" class="form-control"/>
		</div>
		<div class="form-group">
			<label> *�̸��� : </label>
			<input type="text" name="memberEmail" class="form-control"/>
		</div>
		<div class="form-group">
			<label> ��ȭ��ȣ : </label>
			<input type="text" name="memberPhone" class="form-control"/>
		</div>
		<div class="form-group">
			<label> *�ڵ��� : </label>
			<input type="text" name="memberMobile" class="form-control"/>
		</div>
		<div class="form-group">
			<label> ���ϸ��� : </label>
			<input type="text" name="memberMileage" class="form-control"/>
		</div>
		<div class="form-group">
			<input type="submit" value = "ȸ������" class="btn btn-info"/>
			<input type="reset" value = "�ٽ��ۼ�" class="btn btn-info" />
		</div>
	</form>
</div>
<body>
</body>
</html>