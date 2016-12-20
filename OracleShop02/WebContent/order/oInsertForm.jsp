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
	<center><h1>주문하기</h1></center>
	<br/>
		
		<form action="<c:url value='/OInsertAction.ord'/>" method="post">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>이미지</th>
						<th>&nbsp;</th>
						<th>판매자명</th>
						<th>${goods.goodsMemberId}</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2" rowspan="16">${goods.goodsImg}</td>
						<td>상품번호</td>
						<td><input type="text" name="goodsNum" value="${goods.goodsNum}" readonly /></td>
					</tr>
					<tr>
						<td>상품명</td>
						<td><input type="text" name="goodsNum" value="${goods.goodsName}" readonly /></td>
					</tr>
					<tr>
						<td>가격</td>
						<td><input type="text" name="goodsNum" value="${goods.goodsPrice}" readonly /></td>
					</tr>
					<tr>
						<td>색상</td>
						<td>
							<select>
								<c:forEach var="goodsColor" items="${goodsColor}">
									<option value="${goodsColor.goodsColorNum}">${goodsColor.goodsColorName}</option>
								</c:forEach>	
							</select>
						</td>
					</tr>
					<tr>
						<td>사이즈</td>
						<td><select>
								<c:forEach var="goodsSize" items="${goodsSize}">
									<option value="${goodsSize.goodsSizeNum}">${goodsSize.goodsSizeName}</option>
								</c:forEach>	
							</select>
						</td>
					</tr>
					<tr>
						<td>주문수량</td>
						<td><input type="text" name="goodsNum" value="${goods.goodsAmount}" /></td>
					</tr>
					<tr>
						<td rowspan="2">상세정보</td>
					</tr>
					<tr>
						<td rowspan="2" colspan="2"><textarea name="goodsDetail" readonly>${goods.goodsDetail}</textarea></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2">구매자정보</td>
						
					</tr>
					<tr>
						<td>아이디</td>
						<td><input type = "text" name="orderMemberId" value="${member.memberId}" readonly/></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type = "text" name="orderMemberName" value="${member.memberName}" /></td>
					</tr>
					<tr>
						<td>우편번호</td>
						<td><input type = "text" name="orderMemberAddn" value="${member.memberAddn}" /></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type = "text" name="orderMemberAdd" value="${member.memberAdd}" /></td>
					</tr>
					<tr>
						<td>상세주소</td>
						<td><input type = "text" name="orderMemberAdds" value="${member.memberAdds}" /></td>
					</tr>
					<tr>
						<td>핸드폰번호</td>
						<td><input type = "text" name="orderMemberMobile" value="${member.memberMobile}" /></td>
					</tr>
					<tr>
						<td colspan="4" align="center">
							<input type="button" value="결제창바로가기" id="payBtn"/>
							<input type="button" value="취소하기" id="patCencel"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>