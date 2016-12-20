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
		$('#memberId').focus();
		$('#insertBtn').click(function(){
			if($('#memberId').val() == ""){
				alert("���̵� �Է��ϼ���");
				$('#memberId').focus();
				return;
			}else if($('#memberPw').val() == ""){
				alert("����� �Է��ϼ���");
				$('#memberPw').focus();
				return;
			}else if($('#memberName').val() == ""){
				alert("�̸��� �Է��ϼ���");
				$('#memberName').focus();
				return;
			}else if($(':input[name=memberLevel]:radio:checked').length == 0){
				alert("������ �����ϼ���");
				return;
			}else if($(':input[name=memberSex]:radio:checked').length ==0){
				alert("������ �����ϼ���");
				return;
			}else if($('#memberAddn').val() == ""){
				alert("�����ȣ�� �Է��ϼ���");
				$('#memberAddn').focus();
				return;
			}else if($('#memberAdd').val() == ""){
				alert("�ּҸ� �Է��ϼ���");
				$('#memberAdd').focus();
				return;
			}else if($('#memberAdds').val() == ""){
				alert("���ּҸ� �Է��ϼ���");
				$('#memberAdds').focus();
				return;
			}else if($('#memberEmail').val() == ""){
				alert("�̸����� �Է��ϼ���");
				$('#memberEmail').focus();
				return;
			}else if($('#memberMobile').val() == ""){
				alert("�ڵ�����ȣ�� �Է��ϼ���");
				$('#memberMobile').focus();
				return;
			}
			$('#insertMember').attr({action:"<c:url value='/mInsertAction.mem'/>",method:"post"}).submit();
		});
	});
</script>
</head>
<body>
<div class="container">
<center><h1>ȸ������</h1></center>
<center><h5>(*�� �ʼ��Է� �����Դϴ�.)</h5></center>
	<form action="<c:url value='/mInsertAction.mem' />" method="post" id="insertMember">
		<div class="form-group">
			<label> *���̵� : </label>
			<input type="text" name="memberId" class="form-control" id="memberId"/>
		</div>
		<div class="form-group">
			<label> *��  �� : </label>
			<input type="password" name="memberPw" class="form-control" id="memberPw" />
		</div>
		<div class="form-group">
			<label> *��  �� : </label>
			<input type="text" name="memberName" class="form-control" id="memberName" />
		</div>
		<div class="form-group">
			<label> *��  �� : </label><br/>
			<label class="radio-inline">
				<input type="radio" name="memberLevel" value="������" id="memberLevel"/>������
			</label>
			<label class="radio-inline">
				<input type="radio" name="memberLevel" value="������" id="memberLevel"/>������
			</label>
			<label class="radio-inline">	
				<input type="radio" name="memberLevel" value="�Ǹ���" id="memberLevel"/>�Ǹ���
			</label>
		</div>
		<div class="form-group">
			<label> *��  �� : </label><br/>
			<label class="radio-inline">
				<input type="radio" name="memberSex" value="����" id="memberSex"/>����
			</label>
			<label class="radio-inline">
				<input type="radio" name="memberSex" value="����" id="memberSex"/>����
			</label>
		</div>
		<div class="form-group">
			<label> *�����ȣ : </label>
			<input type="text" name="memberAddn" class="form-control" id="memberAddn"/>
		</div>
		<div class="form-group">
			<label> *��  �� : </label>
			<input type="text" name="memberAdd" class="form-control" id="memberAdd"/>
		</div>
		<div class="form-group">
			<label> *���ּ� : </label>
			<input type="text" name="memberAdds" class="form-control" id="memberAdds"/>
		</div>
		<div class="form-group">
			<label> *�̸��� : </label>
			<input type="text" name="memberEmail" class="form-control" id="memberEmail"/>
		</div>
		<div class="form-group">
			<label> ��ȭ��ȣ : </label>
			<input type="text" name="memberPhone" class="form-control" />
		</div>
		<div class="form-group">
			<label> *�ڵ��� : </label>
			<input type="text" name="memberMobile" class="form-control" id="memberMobile"/>
		</div>
		<div class="form-group">
			<label> ���ϸ��� : </label>
			<input type="text" name="memberMileage" class="form-control" />
		</div>
		<div class="form-group">
			<input type="button" value="ȸ������" class="btn btn-info" id="insertBtn"/>
			<input type="reset" value = "�ٽ��ۼ�" class="btn btn-info" />
		</div>
	</form>
</div>
<body>
</body>
</html>