<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Spring Form</title>
</head>
<body>
<!-- modelAttribute 속성에 폼 객체의 속성명을 지정함 -->
<!-- 폼 객체의 속성 명model.addAttribute("member",new MemVO())과 
	 스프링 폼 태그의 modelAttribute 속성값은 일치해야 함-->
<form:form modelAttribute="member" method="post" action="register">
	<table>
		<tr>
			<th>유저ID</th>
			<td>
				<!-- <input type="text" name="memId" id="memId" />  -->
				<form:input path="memId"/>
				<font color="red"><form:errors path="memId" /></font>
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<!-- <input type="text" name="memName" id="memName" />  -->
				<form:input path="memName"/>
				<font color="red"><form:errors path="memName" /></font>
			</td>
		</tr>
	</table>
	<form:button name="register">등록</form:button>
</form:form>
</body>
</html>