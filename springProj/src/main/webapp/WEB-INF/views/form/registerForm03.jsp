<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<title>Spring Form</title>
</head>
<body>
<!-- modelAttribute 속성에 폼 객체의 속성명을 지정함 
	 폼 객체의 속성 명model.addAttribute("member",new MemVO())과 
	 스프링 폼 태그의 modelAttribute 속성값은 일치해야 함-->
<form:form modelAttribute="mamVO" method="post" action="/form/register">
	<table>
		<tr>
			<th><form:label path="memId">유저ID</form:label></th>
			<td>
				<!-- <input type="text" name="memId" id="memId" />  -->
				<form:hidden path="memId"/>
<%-- 				<font color="red"><form:errors path="memId" /></font> --%>
			</td>
		</tr>
		<tr>
			<th><form:label path="memName">이름</form:label></th>
			<td>
				<!-- <input type="text" name="memName" id="memName" />  -->
				<form:input path="memName"/>
				<font color="red"><form:errors path="memName" /></font>
			</td>
		</tr>
		<tr>
			<th><form:label path="password">비밀번호</form:label></th>
			<td>
				<!-- <input type="password" name="password" id="password" />  -->
				<form:password path="password"/>
				<font color="red"><form:errors path="password" /></font>
			</td>
		</tr>
		<tr>
			<th>소개</th>
			<td>
				<form:textarea path="introduction"/>
				<form:errors path="introduction" rows="6" cols="30" />
			</td>
		</tr>
		<tr>
			<th>취미(hobbyList)</th>
			<td>
				<form:checkboxes items="${hobbyMap}" path="hobbyList"/>
			</td>
		</tr>
		<tr>
			<th>개발자여부</th>
			<td>
				<form:checkbox path="developer" value="Y" />
			</td>
		</tr>
		<tr>
			<th>외국인여부</th>
			<td>
				<form:checkbox path="foreigner" value="false" />
			</td>
		</tr>
<!-- 		<tr> -->
<!-- 			<th>성별</th> -->
<!-- 			<td> -->
<!-- 			<!-- private String gender; --> 
<%-- 				<form:radiobuttons path="gender" items="${genderMap}" /> --%>
<!-- 			</td> -->
<!-- 		</tr> -->
		<tr>
			<th>성별</th>
			<td>
			<!-- private String gender; -->
				<form:radiobutton path="gender" value="Male" label="Male" />
				<form:radiobutton path="gender" value="Female" label="Female" />
				<form:radiobutton path="gender" value="Other" label="Other" />
			</td>
		</tr>
<!-- 		<tr> -->
<!-- 			<th>국적</th> -->
<!-- 			<td> -->
<!-- 			<!-- private String nationality; --> 
<%-- 				<form:select path="nationality" items="${nationalityMap}"/> --%>
<!-- 			</td> -->
<!-- 		</tr> -->
		<tr>
			<th>국적</th>
			<td>
				<select id="nationality" name="nationality">
					<option value="Korea">Korea</option>
					<option value="Germany">Germany</option>
					<option value="Australia">Australia</option>
				</select>
			</td>
		</tr>
	</table>
	<form:button name="register">등록</form:button>
</form:form>
<script type="text/javascript">
CKEDITOR.replace("introduction");
</script>
</body>
</html>