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
<script>
	$(document).ready(function(){
		$('#memberPw').focus();
		$('#updateBtn').click(function(){
			if($('#memberPw').val() == ""){
				alert("����� �Է��ϼ���");
				$('#memberPw').focus();
				return;
			}
			$('#updateMember').attr({action:"<c:url value='/MUpdateAction.mem'/>",method:"post"}).submit();
		});
	});
</script>
</head>
<body>
<div class="container">
<center><h1>ȸ������</h1></center>
<center><h5>(*�� �ʼ��Է� �����Դϴ�.)</h5></center>
	<form action="<c:url value='/MUpdateAction.mem' />" method="post" id="updateMember" >
		<div class="form-group">
			<label> *���̵� : </label>
			<input type="text" name="memberId" class="form-control" value="${memberList.memberId}" readonly/>
		</div>
		<div class="form-group">
			<label> *���Ȯ�� : </label>
			<input type="password" name="memberPw" id="memberPw"class="form-control" />
		</div>
		<div class="form-group">
			<label> *��  �� : </label>
			<input type="text" name="memberName" class="form-control" value="${memberList.memberName}"/>
		</div>
		<div class="form-group">
			<label> *��  �� : </label><br/>
			<input type="text" name="memberLevel" class="form-control" value="${memberList.memberLevel}" readonly/>
		</div>
		<div class="form-group">
			<label> *��  �� : </label><br/>
			<input type="text" name="memberSex" class="form-control" value="${memberList.memberSex}" readonly/>
			
		</div>
		<div class="form-group">
			<label> *�����ȣ : </label>
			<input type="text" name="memberAddn" class="form-control" value="${memberList.memberAddn}"/>
		</div>
		<div class="form-group">
			<label> *��  �� : </label>
			<input type="text" name="memberAdd" class="form-control" value="${memberList.memberAdd}"/>
		</div>
		<div class="form-group">
			<label> *���ּ� : </label>
			<input type="text" name="memberAdds" class="form-control" value="${memberList.memberAdds}"/>
		</div>
		<div class="form-group">
			<label> *�̸��� : </label>
			<input type="text" name="memberEmail" class="form-control" value="${memberList.memberEmail}"/>
		</div>
		<div class="form-group">
			<label> ��ȭ��ȣ : </label>
			<input type="text" name="memberPhone" class="form-control" value="${memberList.memberPhone}"/>
		</div>
		<div class="form-group">
			<label> *�ڵ��� : </label>
			<input type="text" name="memberMobile" class="form-control" value="${memberList.memberMobile}"/>
		</div>
		<div class="form-group">
			<label> ���ϸ��� : </label>
			<input type="text" name="memberMileage" class="form-control" value="${memberList.memberMileage}" readonly/>
		</div>
		<div class="form-group">
			<input type="button" value = "ȸ����������" class="btn btn-info" id="updateBtn"/>
			<a href = "<c:url value='/MDelete.mem?memberId=${memberList.memberId}'/>" class="btn btn-info" >ȸ����������</a> 
		</div>
	</form>
</div>
<body>
</body>
</html>