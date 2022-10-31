<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
      $("#aSubmit").on("click",function(){
         $("#frm").submit();
      });
});
</script>
<div class="card shadow mb-4">
	<!-- Card Header - Accordion -->
	<a href="#collapseCardExample" class="d-block card-header py-3"
		data-toggle="collapse" role="button" aria-expanded="true"
		aria-controls="collapseCardExample">
		<h6 class="m-0 font-weight-bold text-primary">Collapsable Card
			Example</h6>
	</a>
	<!-- Card Content - Collapse -->
	<div class="collapse show" id="collapseCardExample">
		<div class="card-body">
			<form id="frm" action="/register/register05" method="post">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">userId
				</label> <input type="text" class="form-control" name="userId" id="userId"
					placeholder="userId">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">password
				</label> <input type="text" class="form-control" name="password"
					id="password" placeholder="password">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">coin
				</label> <input type="text" class="form-control" name="coin" id="coin"
					placeholder="coin">
			</div>

			<div class="mb-3">
				<a href="#" id="aSubmit" class="btn btn-primary btn-icon-split">
					<span class="icon text-white-50"> <i class="fas fa-flag"></i>
				</span> <span class="text">요청파라미터Go</span>
				</a>
			</div>
			</form>
		</div>
	</div>