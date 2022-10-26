<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	//스크립틀릿
	//from product.jsp
	//to   post방식으로 addCart.jsp?id=P1234
	String id = request.getParameter("id");	//P1234
	
	out.print("id : " + id);
	//trim() : 공백제거
	if(id==null || id.trim().equals("")){
		response.sendRedirect("products.jsp");
		return;
	}
	
	//기본키인 P1234 코드의 상품을 찾아보자
	//싱글톤 패턴으로 객체를 1회 생성
	ProductRepository dao = ProductRepository.getInstance();
	
	//select * from ProductRepository
	//where id='P1234';
	ProductVO product = dao.getProductById(id);	//20줄~27줄 중복
	//상품 결과가 없다면...
	if(product == null){
		//[상품이 없음]예외처리 페이지로 이동
		response.sendRedirect("exceptionNoProductId.jsp");
	}else{
		//out.print("product : " + product.toString());
	}
	
	//장바구니(세션) => 세션명 : cartlist
	ArrayList<ProductVO> list = (ArrayList<ProductVO>)session.getAttribute("cartlist");
	
	//장바구니가 없다면 생성
	if(list == null){
		//list는 null이므로 여기서 리스트를 생성해줘야 함
		list = new ArrayList<ProductVO>();
		//cartlist라는 세션명으로 생성
		session.setAttribute("cartlist", list);
	}
	
	//장바구니가 있다면 다음을 실행
	int cnt = 0;
	//1)장바구니에 P1234 상품이 이미 들어있는 경우
	// 	private int quantity;	//상품을 장바구니에 담은 개수
	//	quantity를 1 증가
	//2)장바구니에 P1234 상품이 없는 경우
	//  장바구니에 상품을 넣어주고
	//	quantity를 1로 처리
	//list : 장바구니에 들어있는 상품 목록
	for(int i=0;i<list.size();i++){
		//list는 장바구니(P1234,P1235,P1236)
		//list.get(0).getProductId().equals("P1234")
		if(list.get(i).getProductId().equals(id)){
	cnt++;
	//장바구니에 상품이 이미 들어있다면 장바구니에 담은 개수만 1 증가
	list.get(i).setQuantity(list.get(i).getQuantity()+1);
		}
	}
	//장바구니에 해당 상품이 없다면
	if(cnt == 0){
		product.setQuantity(1);
		//최종목표 : 장바구니(list)에 상품을 추가
		list.add(product);
	}
	
	//장바구니 확인
// 	for(Product pd : list){
// 		out.print("pd : " + pd.toString() 
// 			+ "<br /><hr />");
// 	}
	
	response.sendRedirect("product.jsp?id=" + id);
%>















