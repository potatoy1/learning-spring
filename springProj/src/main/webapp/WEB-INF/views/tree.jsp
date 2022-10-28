<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>jQuery treeview</title>

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

</head>
<body>

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

</body>

</html>
