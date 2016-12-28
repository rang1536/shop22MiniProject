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
	<center><h1>�ֹ�����</h1></center>
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
						<td>�����ݾ�</td>
						<td><input type="text" name="orderPayFinal" value="${order.orderPayFinal}" readonly /></td>
					</tr>
					<tr>
						<td>����</td>
						<td>
							<input type="text" name="orderColor" value="${order.orderColor}" readonly />
						</td>
					</tr>
					<tr>
						<td>������</td>
						<td><input type="text" name="orderSize" value="${order.orderSize}" readonly /></td>
					</tr>
					<tr>
						<td>�ֹ�����</td>
						<td><input type="text" name="orderAmount" value="${order.orderAmount}" /></td>
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
						<td><input type = "text" name="orderMemberId" value="${order.orderMemberId}" readonly/></td>
					</tr>
					<tr>
						<td>�̸�</td>
						<td><input type = "text" name="orderMemberName" value="${order.orderMemberName}" /></td>
					</tr>
					<tr>
						<td>�ּ�</td>
						<td><input type = "text" name="orderMemberAdd" value="${order.orderMemberAdd}" /></td>
					</tr>
					<tr>
						<td>�ڵ�����ȣ</td>
						<td><input type = "text" name="orderMemberMobile" value="${order.orderMemberMobile}" /></td>
					</tr>
					<tr>
						<td>�ֹ��޸�</td>
						<td><input type="text" name="orderMemo" value="${order.orderMemo}" /></td>
					</tr>
					<tr>
						<td>�������</td>
						<td><input type="text" name="orderTradeType" value="${order.orderTradeType}" /></td>
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