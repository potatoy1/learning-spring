<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<title>상품 등록</title>
<script type="text/javascript">
//jQuery 시작!
$(function(){
	$("button").on("click",function(){
		location.href="/list";
	});
});

</script>
</head>
<body>
<h1>상품 등록</h1>
<form action="/createProduct method="post">
	<p>상품 아이디: <input type="text" name="productId" required="required" /></p>
	<p>상품 명: <input type="text" name="pName" required="required" /></p>
	<p>상품 가격: <input type="text" name="unitPrice" required="required" /></p>
	<p>상품 설명: <input type="text" name="description" required="required" /></p>
	<p>제조사: <input type="text" name="manufacturer" required="required" /></p>
	<p>분류: <input type="text" name="category" required="required" /></p>
	<p>재고수: <input type="text" name="unitsInStock" required="required" /></p>
	<p>상품 상태: <input type="text" name="condition" required="required" /></p>
	<p>
		<input type="submit" value="저장" />
		<button type="button">목록</button>
	</p>

</form>
</body>
</html>