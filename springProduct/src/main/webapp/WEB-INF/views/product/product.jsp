<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page errorPage="exceptionNoProductId.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <jsp:useBean id="productDAO" class="kr.or.ddit.dao.ProductRepository" --%>
<%-- scope="session" /> --%>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<title>상품 상세 정보</title>
<script type="text/javascript">
	function addToCart(){
		if(confirm("상품을 장바구니에 추가하시겠습니까?")){
			//addCart.jsp?id=P1234
			document.addForm.submit();
		}else{
			document.addForm.reset();
		}
	}
</script>
</head>
<body>
	<!-- include 액션 태그 -->
	<jsp:include page="menu.jsp" />
	
	<!-- --------------------상품상세 시작-------------------- -->
	<div class="jumbotron">
		<!-- container : 이 안에 내용있다 -->
		<div class="container">
			<h1 class="display-3">상품 정보</h1>
		</div>
	</div>
	<!-- 내용 -->
	<div class="container">
		<!-- 1건의 상품. 1행 -->
		<div class="row">
			<!-- 이미지 div -->
			<div class="col-md-5">
				<img src="/images/${product.filename}" 
				alt="${product.pname}>" title="${product.pname}>" 
				style="width:100%;"/>
			</div>		
			<!-- 6크기의 1열 -->
			<div class="col-md-6">
				<h3>${product.pname}</h3>
				<p>${product.description}</p>
				<p>
					<b>상품 코드 : </b>
					<span class="badge badge-danger">
					${product.productId}
					</span>
				</p>
				<p><b>제조사 : </b>>${product.Manufacturer}</p>
				<p><b>분류 : </b>>${product.Category}</p>
				<p><b>재고 수 : </b>>${product.UnitsInStock}</p>
				<h4>${product.unitPrice}</h4>
				<p>
				<form name="addForm" action="addCart.jsp?id=${product.productId}"
				method="post">
					<a href="#" class="btn btn-info" onclick="addToCart()">상품 주문&raquo;</a>
					<a href="cart.jsp" class="btn btn-warning">장바구니&raquo;</a>
					<a href="products.jsp" class="btn btn-secondary">상품 목록&raquo;</a>
				</form>
				</p>
			</div>
		</div>
	</div>
	<!-- --------------------상품상세 끝-------------------- -->
	
	<jsp:include page="footer.jsp" />
</body>
</html>






