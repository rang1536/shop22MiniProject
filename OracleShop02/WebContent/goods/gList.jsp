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
<title>GLIST</title>
<style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
  .carousel-inner img {
      width: 100%; /* Set width to 100% */
      margin: auto;
      min-height:200px;
  }

  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; 
    }
  }
  </style>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.sessionLevel eq '관리자'}">
			<nav class="navbar navbar-inverse">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>                        
			      </button>
			      <a class="navbar-brand" href="#">Shop22</a>
			    </div>
			    <div class="collapse navbar-collapse" id="myNavbar">
			      <ul class="nav navbar-nav">
			        <li class="active"><a href="<c:url value='/index.jsp'/>">Home</a></li>
			        <li><a href="<c:url value='/goods/gList.goo'/>">상품리스트</a></li>
			        <li><a href="<c:url value='/MList.mem'/>">회원목록</a></li>
			        <li><a href="<c:url value='/OList.ord'/>">주문리스트</a></li>
			      </ul>
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="<c:url value='/MLogout.mem'/>"><span class="glyphicon glyphicon-log-in"></span> 로그아웃</a></li>
			      </ul>
			    </div>
			  </div>
			</nav>
			<div class="container"> 
			<h2>상품검색</h2>
				<form class="form-inline" action="<c:url value="/goods/gSearchForm.goo"/>" method="post">
					<div class="form-group">
					
						<label for="goodsCate">카테고리</label> 
						<select name="goodsCate">
							<c:forEach var="goodsCate" items="${goodsCate}">
								<option value="${goodsCate.goodsCateNum}">${goodsCate.goodsCateName}</option>
							</c:forEach>
								
						</select>
					</div>
					<div class="form-group">
						<label for="goodsName">상품명</label> <input type="text"
							class="form-control" id="goodsName" name="goodsName" placeholder="상품명을 입력하세요">
					</div>
			
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
			<div class="container">
				<div>
					<h1>상품리스트</h1>
					<br />
					<form>
						<table class="table">
							<thead>
								<tr>
									<th>이미지</th>
									<th>상품명</th>
									<th>가격</th>
									<th>상품삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="goodsList" items="${goodsList}">
									<tr>
									
										<td><a href="<c:url value='/goods/gDetailForm.goo?goodsNum=${goodsList.goodsNum}'/>">
											<img src="<c:url value='/imgFile/'/>${goodsList.goodsImg}"></a>
										</td>
										<td>${goodsList.goodsName}</td>
										<td>${goodsList.goodsPrice}</td>
										<td><a href="<c:url value="/goods/gDelete.goo?goodsNum=${goodsList.goodsNum}"/>">딜리트</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</form>
				</div>
			</div>
		</c:when>

		<c:when test="${sessionScope.sessionLevel eq '판매자'}">
			<nav class="navbar navbar-inverse">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>                        
			      </button>
			      <a class="navbar-brand" href="#">Shop22</a>
			    </div>
			 
			    <div class="collapse navbar-collapse" id="myNavbar">
			      <ul class="nav navbar-nav">
			      
			      <div class="dropdown">
				    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">상품등록
				    <span class="caret"></span></button>
				    <ul class="dropdown-menu">
				      <li><a href="<c:url value='/goods/gInsert.goo?goodsCate=1'/>">상의</a></li>
				      <li><a href="<c:url value='/goods/gInsert.goo?goodsCate=2'/>">하의</a></li>
				      <li><a href="<c:url value='/goods/gInsert.goo?goodsCate=3'/>">신발</a></li>
				    </ul>
				  </div>
			
			        <li class="active"><a href="<c:url value='/index.jsp'/>">Home</a></li>
			        <li><a href="<c:url value='/goods/gList.goo'/>">상품리스트</a></li>
			        <li><a href="<c:url value='/MList.mem'/>">회원목록</a></li>
			      </ul>
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="<c:url value='/MLogout.mem'/>"><span class="glyphicon glyphicon-log-in"></span> 로그아웃</a></li>
			      </ul>
			    </div>
			  </div>
			</nav>
		<div class="container"> 
		<h2>상품검색</h2>
			<form class="form-inline" action="<c:url value="/goods/gSearchForm.goo"/>" method="post">
				<div class="form-group">
					<label for="goodsCate">카테고리</label> 
					<select name="goodsCate">
						<c:forEach var="goodsCate" items="${goodsCate}">
							<option value="${goodsCate.goodsCateNum}">${goodsCate.goodsCateName}</option>
						</c:forEach>
							
					</select>
				</div>
				<div class="form-group">
					<label for="goodsName">상품명</label> <input type="text"
						class="form-control" id="goodsName" name="goodsName" placeholder="상품명을 입력하세요">
				</div>
		
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
		<div class="container">
			<div class="collapse navbar-collapse" id="myNavbar">
		      <ul class="nav navbar-nav">
		      
		      <div class="dropdown">
			    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">상품등록
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu">
			      <li><a href="<c:url value='/goods/gInsert.goo?goodsCate=1'/>">상의</a></li>
			      <li><a href="<c:url value='/goods/gInsert.goo?goodsCate=2'/>">하의</a></li>
			      <li><a href="<c:url value='/goods/gInsert.goo?goodsCate=3'/>">신발</a></li>
			    </ul>
			  </ul>
			  </div>
			</div>
		</div>
		<div class="container">
				<div>
					<h1>상품리스트</h1>
					<br />
					<form>
						<table class="table">
							<thead>
								<tr>
									<th>이미지</th>
									<th>상품명</th>
									<th>가격</th>
									<th>상품수정</th>
									<th>상품삭제</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="goodsList" items="${goodsList}">
									<tr>
										<td><a href="<c:url value='/goods/gDetailForm.goo?goodsNum=${goodsList.goodsNum}'/>">
											<img src="<c:url value='/imgFile/'/>${goodsList.goodsImg}"></a>
										</td>
										<td>${goodsList.goodsName}</td>
										<td>${goodsList.goodsPrice}</td>
										<td><a href="<c:url value="/goods/GUpdateForm.goo?goodsNum=${goodsList.goodsNum}"/>">업데이트</a></td>
										<td><a href="<c:url value="/goods/gDelete.goo?goodsNum=${goodsList.goodsNum}"/>">딜리트</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</form>
				</div>
			</div>
		</c:when>
		<c:otherwise>
		<div class="container">
			<a href="<c:url value='/OList.ord'/>" class="btn btn-primary">주문확인/주문수정</a>
		</div>
			<div>
				<h1>상품리스트</h1>
				<br />
				<form>
					<table class="table">
						<thead>
							<tr>
								<th>이미지</th>
								<th>상품명</th>
								<th>가격</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="goodsList" items="${goodsList}">
								<tr>
									<td><a href="<c:url value='/goods/gDetailForm.goo?goodsNum=${goodsList.goodsNum}'/>">
										<img src="<c:url value='/imgFile/'/>${goodsList.goodsImg}"></a>
									</td>
									<td>${goodsList.goodsName}</td>
									<td>${goodsList.goodsPrice}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>