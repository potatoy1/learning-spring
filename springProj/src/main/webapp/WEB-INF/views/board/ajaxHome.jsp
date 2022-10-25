<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<title>Headers 매핑</title>
<script type="text/javascript">
//document가 로딩이 완료 되면 실행
$(function(){
	$("button").on("click",function(){
		let boardNoVal="7"
		//
		let boardObject = {
			"boardNo":"7",
			"title":"개똥이 수리남가다",
			"content" : "식사?",
			"writer" : "개똥이"
		};
		console.log("boardObject: " + JSON.stringify(boardObject));
		//비동기
		//아작났어유.. PC다탔어.
		//contentType => 보내는 타입
		//dataType => 응답 타입
		$.ajax({
			url:"/board/" + boardNoVal,
			contentType:"applicatioin/json;charset=utf-8",
			data:JSON.stringify(boardObject),
			type:"put",
			success:function(result){
				//result : success
				console.log("result: " + result);
			}
		});
	});
	$("input[name='btnAccept']").on("click",function(){
		let boardNo = $("#boardNo").val(); //7
		
		console.log("boardNo: " + boardNo);
		
		//get방식으로 /board/7 URI를 요청하면
		//JSON 데이터로 비동기 응답이 되겠구나.
		$.get("/board/" + boardNo,function(data){
			//data : JSON데이터
			console.log(JSON.stringify(data))
		});
	});
	$("input[name='btnJson']").on("click",function(){
		let boardNo = $("#boardNo").val();
		console.log("boardNo: " +boardNo);
		let data ={
			"boardNo" : boardNo	
		};
		//아작났어유~pc다탔어ㅠ
		$.ajax({
			url:"/board/getBook",
			contentType:"Application/json;charset:utf-8",
			data:JSON.stringify(data),
			type:"post",
			success:function(result){
				//result는 bookVO 데이터임 => JSON으로 변환됨
				console.log(JSON.stringify(result));
			}
		});
	});
});
</script>
</head>
<body>
<h2>Headers 매핑</h2>
<button type="button">초라기</button>
<h2>7.Accept 매핑</h2>
<p><input type="text" name="boardNo" id="boardNo" value="7" /></p>
<p><input type="button" name="btnAccept" value="실행"></p>
<p><input type="button" name="btnJson" value="ajax로실행"></p>
</body>
</html>