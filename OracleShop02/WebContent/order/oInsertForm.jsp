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
<title>ORDER</title>
</head>
<body>
<div class="container">
	<center><h1>�ֹ��ϱ�</h1></center>
	<br/>
		
		<form action="<c:url value='/OInsertAction.ord'/>" method="post">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>�̹���</th>
						<th>&nbsp;</th>
						<th>�Ǹ��ڸ�</th>
						<th>${goods.goodsMemberId}</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2" rowspan="19"><img src="<c:url value='/imgFile/'/>${goods.goodsImg}"></td>
						<td>��ǰ��ȣ</td>
						<td><input type="text" name="goodsNum" value="${goods.goodsNum}" readonly /></td>
					</tr>
					<tr>
						<td>��ǰ��</td>
						<td><input type="text" name="goodsName" value="${goods.goodsName}" readonly /></td>
					</tr>
					<tr>
						<td>����(�ǸŰ��� 10%�� ���ϸ����� �����˴ϴ�)</td>
						<td><input type="text" name="goodsPrice" value="${goods.goodsPrice}" readonly /></td>
					</tr>
					<tr>
						<td>����</td>
						<td>
							<select name="orderGoodsColor">
								<c:forEach var="goodsColor" items="${goodsColor}">
									<option value="${goodsColor.goodsColorName}">${goodsColor.goodsColorName}</option>
								</c:forEach>	
							</select>
						</td>
					</tr>
					<tr>
						<td>������</td>
						<td><select name="orderGoodsSize">
								<c:forEach var="goodsSize" items="${goodsSize}">
									<option value="${goodsSize.goodsSizeName}">${goodsSize.goodsSizeName}</option>
								</c:forEach>	
							</select>
						</td>
					</tr>
					<tr>
						<td>�ֹ�����</td>
						<td><input type="text" name="goodsAmount" value="${goods.goodsAmount}" /></td>
					</tr>
					<tr>
						<td rowspan="2">������</td>
					</tr>
					<tr>
						<td rowspan="2" colspan="2"><textarea name="goodsDetail" readonly>${goods.goodsDetail}</textarea></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2">����������</td>
						
					</tr>
					<tr>
						<td>���̵�</td>
						<td><input type = "text" name="orderMemberId" value="${member.memberId}" readonly/></td>
					</tr>
					<tr>
						<td>�̸�</td>
						<td><input type = "text" name="orderMemberName" value="${member.memberName}" /></td>
					</tr>
					<tr>
						<td>�����ȣ</td>
						<td><input type = "text" name="orderMemberAddn" value="${member.memberAddn}" /></td>
					</tr>
					<tr>
						<td>�ּ�</td>
						<td><input type = "text" name="orderMemberAdd" value="${member.memberAdd}" /></td>
					</tr>
					<tr>
						<td>���ּ�</td>
						<td><input type = "text" name="orderMemberAdds" value="${member.memberAdds}" /></td>
					</tr>
					<tr>
						<td>�ڵ�����ȣ</td>
						<td><input type = "text" name="orderMemberMobile" value="${member.memberMobile}" /></td>
					</tr>
					<tr>
						<td>�ֹ��޸�</td>
						<td><input type="text" name="orderMemo" placeholder="�ֹ��� �ʿ��� �޸� �����ּ���" /></td>
					</tr>
					<tr>
						<td>�������</td>
						<td>
							<select name="tradeType">
								<option value="ī�����">ī�����</option>
								<option value="�������Ա�">�������Ա�</option>
								<option value="�޴�������">�޴�������</option>
							</select> 
						</td>
					</tr>
					<tr>
						<td>���ϸ��� ��뿩��üũ</td>
						<td>
							<select name="choiceMileage">
								<option value="����">���ϸ�����������</option>
								<option value="����">���ϸ�������</option>
							</select> 
						</td>
					</tr>
				</tbody>
			</table>
			<div class="form-group" align="center">
				<input type="submit" value="�����ϱ�" id="payBtn" class="btn btn-primary"/>
				<a href="<c:url value='/GList.goo'/>" class="btn btn-primary" >����Ʈ���ư���</a>
			</div>
		</form>
	</div>
</body>
</html>