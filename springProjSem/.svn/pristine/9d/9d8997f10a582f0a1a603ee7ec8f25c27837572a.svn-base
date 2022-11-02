<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">

</script>
<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="row">
					<div class="col-sm-12 col-md-6">
						<div class="dataTables_length" id="dataTable_length">
							<label>Show <select name="dataTable_length"
								aria-controls="dataTable"
								class="custom-select custom-select-sm form-control form-control-sm"><option
										value="10">10</option>
									<option value="25">25</option>
									<option value="50">50</option>
									<option value="100">100</option></select> entries
							</label>
						</div>
					</div>
					<div class="col-sm-12 col-md-6">
						<div id="dataTable_filter" class="dataTables_filter">
							<label>Search:<input type="search"
								class="form-control form-control-sm" placeholder=""
								aria-controls="dataTable"></label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered dataTable" id="dataTable"
							width="100%" cellspacing="0" role="grid"
							aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting sorting_asc" tabindex="0"
										aria-controls="dataTable" rowspan="1" colspan="1"
										aria-sort="ascending"
										aria-label="Name: activate to sort column descending"
										style="width: 123.422px;">회원아이디</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1"
										aria-label="Position: activate to sort column ascending"
										style="width: 214.953px;">회원명</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1"
										aria-label="Office: activate to sort column ascending"
										style="width: 86.5938px;">직업</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1"
										aria-label="Age: activate to sort column ascending"
										style="width: 35.3281px;">취미</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1"
										aria-label="Start date: activate to sort column ascending"
										style="width: 83.0938px;">전화번호</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="row" items="${data}" varStatus="stat">
								<tr class="odd">
									<td class="sorting_1">${row.memId}</td>
									<td>${row.memName}</td>
									<td>${row.memJob}</td>
									<td>${row.memLike}</td>
									<td>${row.memHp}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row" style="justify-content:space-between;">
					<div class="col-sm-12 col-md-5">
						<div class="dataTables_info" id="dataTable_info" role="status"
							aria-live="polite">Showing 1 to 10 of 57 entries</div>
					</div>
					<a href="/create2" class="btn btn-warning btn-icon-split">
                        <span class="icon text-white-50">
                            <i class="fas fa-exclamation-triangle"></i>
                        </span>
                        <span class="text">add member</span>
                    </a>
					<div class="col-sm-12 col-md-7">
						<div class="dataTables_paginate paging_simple_numbers"
							id="dataTable_paginate">
							<ul class="pagination">
								<li class="paginate_button page-item previous disabled"
									id="dataTable_previous"><a href="#"
									aria-controls="dataTable" data-dt-idx="0" tabindex="0"
									class="page-link">Previous</a></li>
								<li class="paginate_button page-item active">
									<a href="/board/list?currentPage=1"
									aria-controls="dataTable" data-dt-idx="1" tabindex="0"
									class="page-link">1</a></li>
								<li class="paginate_button page-item ">
									<a href="/board/list?currentPage=2"
									aria-controls="dataTable" data-dt-idx="2" tabindex="0"
									class="page-link">2</a></li>
								<li class="paginate_button page-item ">
									<a href="/board/list?currentPage=3"
									aria-controls="dataTable" data-dt-idx="3" tabindex="0"
									class="page-link">3</a></li>
								<li class="paginate_button page-item ">
									<a href="/board/list?currentPage=4"
									aria-controls="dataTable" data-dt-idx="4" tabindex="0"
									class="page-link">4</a></li>
								<li class="paginate_button page-item ">
									<a href="/board/list?currentPage=5"
									aria-controls="dataTable" data-dt-idx="5" tabindex="0"
									class="page-link">5</a></li>
								<li class="paginate_button page-item next" id="dataTable_next"><a
									href="#" aria-controls="dataTable" data-dt-idx="7" tabindex="0"
									class="page-link">Next</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>