<%@page import="kr.or.ddit.vo.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	//스크립틀릿
	// /removeCart.jsp?id=P1234 의 요청 파라미터를 받아서 변수에 저장
	String id = request.getParameter("id"); //P1234
	
	// 만약에 /removeCart.jsp 또는 removeCart.jsp?id=Z1234 
	// products.jsp로 이동
	if(id==null || id.trim().equals("")){
		response.sendRedirect("products.jsp");
		return;
	}
	//상품저장소 클래스 => 싱글톤 객체 생성(메모리에 1회 생성. 공유해서 사용)
	ProductRepository dao = ProductRepository.getInstance();
	//상품검색메소드(select * from productrepository where id='Z1234';)
	ProductVO product = dao.getProductById(id);
	if(product==null){	//해당 상품이 없음
		response.sendRedirect("exceptionNoProductId.jsp");
		return;
	}
		
	// 세션의 장바구니(세션) 목록에서 P1234이 있는지 체크한 후 
	// 만약에 있다면 장바구니에서 제외처리
		//cartlist라는 세션명으로 생성
		//session.setAttribute("cartlist", list);
	ArrayList<ProductVO> cartlist =
	(ArrayList<ProductVO>)session.getAttribute("cartlist");
	
// 	if(cartlist.size()>0){
// 		Product goodsQnt = new Product();	//Object 생성(new)
		
		//향상된 for문
		/*
		1.인덱스를 사용하지 못한다.(일반 for문의 (int i=0;) 할 때 i 같은 인덱스를 말하는 것) 하지만 방법이 있다.
		★ 중요 ★
		2.배열이나 ArrayList 값을 사용할 순 있지만 절대 수정할 수는 없다.
		*/
		for(int i=0;i<cartlist.size();i++){
	//"P1234".equals("P1234") => 해당 상품이 장바구니에 있다면..
// 			goodsQnt = cartlist.get(i);
	if(cartlist.get(i).getProductId().equals(id)){
		//remove(Object)
		cartlist.remove(cartlist.get(i));	//성공
		//cartlist.remove(row);	//실패
	}
		}
// 	}
	response.sendRedirect("cart.jsp");
%>














