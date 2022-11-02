<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/jquery.treeview.css" />
<link rel="stylesheet" href="/resources/css/screen.css" />

<script src="/resources/js/jquery.js" type="text/javascript"></script>
<script src="/resources/js/jquery.cookie.js" type="text/javascript"></script>
<script src="/resources/js/jquery.treeview.js" type="text/javascript"></script>

<script type="text/javascript">
		$(function() {
			$("#tree").treeview({
				collapsed: true,
				animated: "medium",
				control:"#sidetreecontrol",
				persist: "location"
			});
		})
		
	</script>
	
<div id="sidetree">
	<div class="treeheader">&nbsp;</div>

	<div id="sidetreecontrol"><a href="?#">전체 닫기</a> | <a href="?#">전체 열기</a></div>
	<ul id="tree">
		<li>
			<strong>첫번째 메뉴</strong>
			<ul>
				<li><a href="#">서브메뉴</a></li>
			</ul>
		</li>
		<li>
			<strong>두번째 메뉴</strong>
			<ul>
				<li><a href="#">첫번째 서브메뉴</a></li>
			</ul>
			<ul>
				<li>
					<a href="#">두번째 서브메뉴</a>
					<ul>
						<li><a href="#">서브메뉴 속 첫번째 서브메뉴</a></li>
					</ul>
				</li>
			</ul>
		</li>
	</ul>
</div>
	
<!-- <div class="card shadow mb-4"> -->
<!-- 	<div class="card-header py-3"> -->
<!-- 		<h6 class="m-0 font-weight-bold text-primary">tree</h6> -->
<!-- 	</div> -->
<!-- 	<div class="card-body"> -->
<!-- 		<div class="table-responsive"> -->
<!-- 			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4"> -->
<!-- 				<div class="row"> -->
<!-- 					<div class="col-sm-12 col-md-6"> -->
<!-- 						<div class="dataTables_length" id="dataTable_length"> -->
<!-- 							<label>Show <select name="dataTable_length" -->
<!-- 								aria-controls="dataTable" -->
<!-- 								class="custom-select custom-select-sm form-control form-control-sm"><option -->
<!-- 										value="10">10</option> -->
<!-- 									<option value="25">25</option> -->
<!-- 									<option value="50">50</option> -->
<!-- 									<option value="100">100</option></select> entries -->
<!-- 							</label> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-sm-12 col-md-6"> -->
<!-- 						<div id="dataTable_filter" class="dataTables_filter"> -->
<!-- 							<label>Search:<input type="search" -->
<!-- 								class="form-control form-control-sm" placeholder="" -->
<!-- 								aria-controls="dataTable"></label> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="row"> -->
<!-- 					<div class="col-sm-12"> -->
<!-- 						<table class="table table-bordered dataTable" id="dataTable" -->
<!-- 							width="100%" cellspacing="0" role="grid" -->
<!-- 							aria-describedby="dataTable_info" style="width: 100%;"> -->
<!-- 							<thead> -->
<!-- 								<tr role="row"> -->
<!-- 									<th class="sorting sorting_asc" tabindex="0" -->
<!-- 										aria-controls="dataTable" rowspan="1" colspan="1" -->
<!-- 										aria-sort="ascending" -->
<!-- 										aria-label="Name: activate to sort column descending" -->
<!-- 										style="width: 57px;">회원아이디</th> -->
<!-- 									<th class="sorting" tabindex="0" aria-controls="dataTable" -->
<!-- 										rowspan="1" colspan="1" -->
<!-- 										aria-label="Position: activate to sort column ascending" -->
<!-- 										style="width: 61px;">회원명</th> -->
<!-- 									<th class="sorting" tabindex="0" aria-controls="dataTable" -->
<!-- 										rowspan="1" colspan="1" -->
<!-- 										aria-label="Office: activate to sort column ascending" -->
<!-- 										style="width: 49px;">직업</th> -->
<!-- 									<th class="sorting" tabindex="0" aria-controls="dataTable" -->
<!-- 										rowspan="1" colspan="1" -->
<!-- 										aria-label="Age: activate to sort column ascending" -->
<!-- 										style="width: 31px;">취미</th> -->
<!-- 									<th class="sorting" tabindex="0" aria-controls="dataTable" -->
<!-- 										rowspan="1" colspan="1" -->
<!-- 										aria-label="Start date: activate to sort column ascending" -->
<!-- 										style="width: 68px;">특기</th> -->
<!-- 								</tr> -->
<!-- 							</thead> -->
<!-- 							<tbody> -->
<!-- 							before => data : List<MemVO> list / row : MemVO 
<!-- 					   페이징처리 after => data : ArticlePage이므로 -->
<!-- 					   							  data.content 해야지 List<MemVO> list가 나옴 -->
<!-- 							--> -->
<%-- 								<c:forEach var="list" items="${data.content}" varStatus="stat"> --%>
<!-- 									<tr> -->
<%-- 										<td>${list.memId}</td> --%>
<%-- 										<td>${list.memName}</td> --%>
<%-- 										<td>${list.memJob}</td> --%>
<%-- 										<td>${list.memLike}</td> --%>
<%-- 										<td>${list.memSkill}</td> --%>
<!-- 									</tr> -->
<%-- 								</c:forEach> --%>
<!-- 							</tbody> -->
<!-- 						</table> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="row"> -->
<!-- 					<div class="col-sm-12 col-md-5"> -->
<!-- 						<div class="dataTables_info" id="dataTable_info" role="status" -->
<!-- 							aria-live="polite">Showing 1 to 10 of 57 entries</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-sm-12 col-md-7"> -->
<!-- 						<div class="dataTables_paginate paging_simple_numbers" -->
<!-- 							id="dataTable_paginate"> -->
<!-- 							<ul class="pagination"> -->
<%-- 								<li class="paginate_button page-item previous  --%>
<%-- 									<c:if test='${data.startPage lt 6}'>disabled</c:if> --%>
<%-- 								" --%>
<%-- 									id="dataTable_previous"><a href="/board/list?currentPage=${data.startPage-5}" --%>
<!-- 									aria-controls="dataTable" data-dt-idx="0" tabindex="0" -->
<!-- 									class="page-link">Previous</a></li> -->
<%-- 								<c:forEach var="pNo" begin="${data.startPage}" end="${data.endPage}" > --%>
<!-- 								<li class="paginate_button page-item "> -->
<%-- 									<a href="/board/list?currentPage=${pNo}" --%>
<!-- 									aria-controls="dataTable" data-dt-idx="1" tabindex="0" -->
<%-- 									class="page-link">${pNo}</a></li> --%>
<%-- 								</c:forEach> --%>
<%-- 								<li class="paginate_button page-item next --%>
<%-- 									<c:if test='${data.endPage ge data.totalPages}'>disabled </c:if> --%>
<%-- 								" id="dataTable_next"><a --%>
<%-- 									href="/board/list?currentPage=${data.startPage+5}" aria-controls="dataTable" data-dt-idx="7" tabindex="0" --%>
<!-- 									class="page-link">Next</a></li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->
<p>
	<a href="/board/create">회원 등록</a>
</p>
