<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<title>회원 등록하기</title>
<script type="text/javascript">
//jQuery 시작!
$(function(){
	$("#aSubmit").on("click", function() {
		$("#frm").submit();
	});
});
</script>
</head>
<div class="card shadow mb-4">
	<!-- Card Header - Accordion -->
	<a href="#collapseCardExample" class="d-block card-header py-3"
		data-toggle="collapse" role="button" aria-expanded="true"
		aria-controls="collapseCardExample">
		<h6 class="m-0 font-weight-bold text-primary">회원등록</h6>
	</a>
	<!-- Card Content - Collapse -->
	<div class="collapse show" id="collapseCardExample">
		<div class="card-body">
			<form id="frm" action="/board/create" method="post">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">memId
					</label> <input type="text" class="form-control" name="memId" id="memId"
						placeholder="memId" value="a001">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">memName
					</label> <input type="text" class="form-control" name="memName"
						id="memName" placeholder="memName" value="java">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">memJob
					</label> <input type="text" class="form-control" name="memJob" id="memJob"
						placeholder="memJob" value="100">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">memLike
					</label> <input type="text" class="form-control" name="memLike" id="memLike"
						placeholder="memLike" value="100">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">memSkill
					</label> <input type="text" class="form-control" name="memSkill" id="memSkill"
						placeholder="memSkill" value="100">
				</div>
			<div class="mb-3">
					<a id="aSubmit" class="btn btn-primary btn-icon-split">
						<span class="icon text-white-50"> <i class="fas fa-flag"></i>
					</span> <span class="text">요청파라미터Go</span>
					</a>
				</div>
			</form>
		</div>
	</div>