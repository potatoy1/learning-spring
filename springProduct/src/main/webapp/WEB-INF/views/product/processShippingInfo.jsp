<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%//스크립틀릿
	request.setCharacterEncoding("UTF-8");
	//쿠키 쿠키 뉴~ 큐키 네임 밸류
	//요청 파라미터 정보를 쿠키에 넣음 
	Cookie cartId = 
		new Cookie("Shipping_cartId",
		URLEncoder.encode(request.getParameter("cartId"),"UTF-8"));
	Cookie name = 
			new Cookie("Shipping_name",
			URLEncoder.encode(request.getParameter("name"),"UTF-8"));
	Cookie shippingDate = 
			new Cookie("Shipping_shippingDate",
			URLEncoder.encode(request.getParameter("shippingDate"),"UTF-8"));
	Cookie country = 
			new Cookie("Shipping_country",
			URLEncoder.encode(request.getParameter("country"),"UTF-8"));
	Cookie zipCode = 
			new Cookie("Shipping_zipCode",
			URLEncoder.encode(request.getParameter("zipCode"),"UTF-8"));
	Cookie addressName = 
			new Cookie("Shipping_addressName",
			URLEncoder.encode(request.getParameter("addressName"),"UTF-8"));
	
	//유효 기간 1일로 설정(초단위)
	cartId.setMaxAge(24 * 60 * 60);
	name.setMaxAge(24 * 60 * 60);
	shippingDate.setMaxAge(24 * 60 * 60);
	zipCode.setMaxAge(24 * 60 * 60);
	country.setMaxAge(24 * 60 * 60);
	addressName.setMaxAge(24 * 60 * 60);
	
	//생성된 쿠키를 등록 
	response.addCookie(cartId);
	response.addCookie(name);
	response.addCookie(shippingDate);
	response.addCookie(zipCode);
	response.addCookie(country);
	response.addCookie(addressName);
	
	response.sendRedirect("orderConfirmation.jsp");
%>











