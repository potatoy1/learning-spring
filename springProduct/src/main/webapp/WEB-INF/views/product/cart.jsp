<%@page import="kr.or.ddit.vo.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<title>장바구니</title>
</head>
<body>
	<!-- include 액션 태그 -->
	<jsp:include page="menu.jsp" />
	
	<div class="jumbotron">
		<!-- container : 이 안에 내용있다 -->
		<div class="container">
			<h1 class="display-3">장바구니</h1>
		</div>
	</div>
	
	<!-- ------------장바구니 상세 내용 시작 ------------------- -->
	<div class="container">
		<div class="row">
			<table width="100%">
				<tr>
					<td align="left">
						<a href="deleteCart.jsp?cartId=#{product.cartId}" 
						class="btn btn-danger">삭제하기</a>
					</td>
					<td align="right">
						<a href="shippingInfo.jsp?cartId=#{product.cartId}" 
						class="btn btn-success">주문하기</a>
					</td>
				</tr>
			</table>
		</div>
		<!-- 장바구니 출력 시작 -->
		<!-- padding-top : 영역의 위쪽 여백 50px -->
		<div style="padding-top:50px;">
			<table class="table table-hover">
				<tr>
					<th>상품</th><th>가격</th><th>수량</th>
					<th>금액</th><th>비고</th>
				</tr>
				<tr>
					<td>${product.productId} - ${product.pname}</td>
					<td>${product.unitPrice}</td>
					<td>${product.quantity}</td>
					<td>${product.unitPrice}*${product.quantity}</td>
					<td>
						<a href="removeCart.jsp?id=${product.productId}"
						class="badge badge-danger">삭제</a>
					</td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>총액</th>
					<th>${product.unitPrice}*${product.quantity}</th>
					<th></th>
				</tr>
			</table>
			<a href="products.jsp" class="btn btn-secondary">&laquo;쇼핑 계속하기</a>
		</div>
		<!-- 장바구니 출력 끝 -->
	</div>
	<!-- ------------장바구니 상세 내용 끝 ------------------- -->
	
	<jsp:include page="footer.jsp" />
</body>
</html>





