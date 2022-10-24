<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 
BookController로 부터 넘어오는 정보 2가지
1) mav.addobject("data",data); => bookVO 객체
1) mav.addobject("bookId",data.getBookId()); => 기본키 데이터(int 타입)
 -->
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<title>책 등록하기</title>
<script type="text/javascript">

</script>
</head>
<body>
<!-- 
JSTL (JSP Standard Tag Library) : 개발자가 자주 사용하는 패턴을 모아놓은 집합
=>BookController에서 보내준 데이터를 View에 표현하도록 도와줌
JSTL은 maven에서 설정되어 있음. => pom.xml => jstl
 -->
<h1>책 상세</h1>
	<p>제목: ${data.title}</p>
	<p>카테고리: ${data.category}</p>
	<p>가격: <fmt:formatNumber type="number" maxFractionDigits="3" value="${data.price}" /></p>
	<p>입력일: <fmt:formatDate value="${data.insertDate}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
	<p>
		<a href="/update?bookId=${bookId}">수정폼</a>
	</p>
<!-- method
1) GET  :  데이터를 변경하지 않을 때. 목록/상세보기
2) POST :  데이터를 변경할 때. 입력/수정/삭제
-->
	<form action="/delete" method="post">
		<input type="hidden" name="bookId" value="${bookId}" />
		<input type="submit" value="삭제" />
	</form>
	<p><a href="/list">목록으로 이동</a></p>
</body>
</html>