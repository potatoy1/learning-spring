<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/validation.js"></script>
<title>회원 등록하기</title>
<style>
.abc {
	display: flex;
	justify-content: flex-start;
}

.form-control {
	width: 50%;
}
</style>

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
			<form id="frm" name="frm" action="/board/create" method="post" enctype="multipart/form-data">
				<label for="exampleFormControlInput1" class="form-label">memId</label>
				<div class="mb-3 abc">
					<input type="text" class="form-control" id="memId" name="memId"
						required="required" placeholder="memId" value="${memVO.memId}" readonly>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">memName
					</label> <input type="text" class="form-control" name="memName"
						id="memName" placeholder="memName" value="${memVO.memName}">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">memJob
					</label> <input type="text" class="form-control" name="memJob" id="memJob"
						placeholder="memJob" value="${memVO.memJob}" >
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">memLike
					</label> <input type="text" class="form-control" name="memLike"
						id="memLike" placeholder="memLike" value="${memVO.memLike}">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">memHp</label>
					<input type="text" class="form-control" name="memHp" id="memHp"
						placeholder="memHp" value="${memVO.memHp}" required />
				</div>
				<div class="mb-3">
					<label for="formFileMultiple" class="form-label">증명사진</label> <input
						class="form-control" type="file" id="productImage"
						name="pictureArray" multiple style="display:none;" />
				</div>
				<div class="mb-3">
					<div class="imgs_wrap">
					<!-- MemController에서 직접 옴 -->
					<c:forEach var="attachVO" items="${attachVOList}">
						<img src="/resources/upload${attachVO.attachName}" />
					</c:forEach>
					<!-- memVO 객체의 멤버변수를 끄집어냄 -->
					<c:forEach var="attachVO" items="${memVO.attachVOList}">
						<img src="/resources/upload${attachVO.attachName}" />
					</c:forEach>
					</div>
				</div>
				<div class="mb-3">
					<button type="button" onclick="CheckAddMem()" id="btnSubmit"
						class="btn btn-primary btn-icon-split" disabled>
						<span class="icon text-white-50"> <i class="fas fa-flag"></i>
						</span> <span class="text">등록</span>
					</button>
					<a href="/board/list" type="button"
						class="btn btn-secondary btn-icon-split" >
						<span class="icon text-white-50"> <i class="fas fa-flag"></i>
						</span> <span class="text">취소</span>
					</a>
				</div>
			</form>
		</div>
	</div>