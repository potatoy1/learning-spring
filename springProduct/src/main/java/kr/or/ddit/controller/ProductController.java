package kr.or.ddit.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.ProductService;
import kr.or.ddit.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView products(ModelAndView mav,
			@RequestParam(value="keyword", required=false) String keyword) {
		// Model
		List<ProductVO> list = this.productService.list(keyword);
		
		for (ProductVO vo : list) {
			log.info("vo : " + vo.toString());
		}
		
		mav.setViewName("product/products");
		mav.addObject("data", list);
		
		return mav;
		
	}
	
	//URI : /addProduct
	//파라미터 : none
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("product/addProduct");
		//forwarding
		return mav;
		
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProductPost(ModelAndView mav, @ModelAttribute ProductVO productVO) {
		log.info("ProductVO : " + productVO.toString());
		log.info("여기는 옴");
		//PRODUCT 테이블에 insert
		//result > 0 => insert 성공, result == 0 => 실패
		int result = this.productService.insertProduct(productVO);
		
		log.info("result : " + result);
		
		if(result > 0) {//입력 성공
			mav.setViewName("redirect:/detail?productId=" + productVO.getProductId());
		}else {//입력 실패
			mav.setViewName("redirect:/addproduct");
		}
		
		return mav;
		
	}
	
	//요청URI : http://localhost:8090/detail?productId=P1236
	//요청URL : http://localhost:8090/detail
	//요청파라미터 : productId=P1236
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(ModelAndView mav, ProductVO productVO) {
//		ProductVO [productId=P1236, pname=null, unitPrice=0, description=null, 
		//manufacturer=null, category=null, unitInStock=0, condition=null, filename=null, quantity=0]
		log.info("productVO : " + productVO.toString());
		//스프링은 인터페이스를 좋아해
		ProductVO data = this.productService.selectDetail(productVO);
		//뷰 경로
		//forwarding
		mav.setViewName("product/product");
		mav.addObject("data",data);
		mav.addObject("productId", data.getProductId());	//P1236
		return mav;
	}
	
	//요청URI : http://localhost:8090/update?productId=P1236
	//요청URL : http://localhost:8090/update
	//요청파라미터 : productId=P1236
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(ModelAndView mav, ProductVO productVO) {
		
		ProductVO data = this.productService.selectDetail(productVO); 
		
		mav.addObject("data", data);
		
		mav.setViewName("product/update");			
		
		return mav;
		
	}
	
	//상품 정보 변경
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePost(ModelAndView mav, ProductVO productVO) {
		log.info("updatePost => productVO : " + productVO.toString());
		
		//0또는 1이상
		int result = this.productService.update(productVO); 
		
		if(result > 0) {	//변경 성공
			mav.setViewName("redirect:/detail?productId=" + productVO.getProductId());						
		}else {//변경 없음
			mav.setViewName("redirect:/update?productId=" + productVO.getProductId());
		}
		
		return mav;
		
	}
	
	//상품 삭제
	//파라미터 받는 방법 => VO는 골뱅이ModelAttribute / String/int는 골뱅이RequestParam
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(ModelAndView mav, @RequestParam String productId,
				@ModelAttribute ProductVO productVO,
				Map<String,String> map) {
		log.info("productId : " + productId);
		log.info("productVO : " + productVO.toString());
		log.info("map : " + map);
		
		int result = this.productService.delete(productId);
		
		// redirect => detail 메소드를 다시 실행함
		if(result > 0) { // 삭제 성공	
			mav.setViewName("redirect:/products");
		}else {//삭제 실패
			mav.setViewName("redirect:/detail?productId=" + productId);
		}
		
		return mav;
	}
	
	//요청URI : /addCart
	//요청파라미터: ("productId":"P1235"}
	//장바구니(=세션(cartlist))에 해당 상품을 넣음
	//spring에서 요청파라미터를 매개변수로 받을 수 있다
	@RequestMapping(value="/addCart", method=RequestMethod.POST)
	public String addCart(@RequestParam String productId, Model model, 
			@ModelAttribute ProductVO productVO, HttpServletRequest request) {
		log.info("productId: " + productId);
		log.info("productVO: " + productVO.toString());
		
		//장바구니에 넣을 상품이 없다면...
		if(productId==null) {
			return "redirect:/detail?productId="+productId;
		}
		
		//장바구니에 넣을 상품을 검색해보자
		ProductVO vo = this.productService.selectDetail(productVO);
		log.info("vo : " + vo);
		
		if(vo==null) {
			//[상품없음] 예외처리 페이지로 이동
			return "redirect:/exceptionNoProductId";
		}
		//장바구니(세션) => 세션명 : cartlist
		HttpSession session = request.getSession();
		//세션에 cartlist가 있는가...
		ArrayList<ProductVO> list =	(ArrayList<ProductVO>)session.getAttribute("cartlist");
		//장바구니가 없다면 생성해보자
		if(list==null) {
			//list는 null이므로 여기서 리스트를 생성해줘야함
			list = new ArrayList<ProductVO>();
			//cartlist라는 세션명으로 생성
			session.setAttribute("cartlist", list);
		}
		
		//장바구니가 있으면 다음을 실행
		int cnt = 0; //장바구니에 상품이 담긴 개수
		
		for(int i=0;i<list.size();i++) {
			//list는 session 장바구니(P1234,P1235,P1236)
			//list.get(0) => P1234상품 1행
			//list.get(0).getProductId() => P1234
			if(list.get(i).getProductId().equals(productId)) {
				cnt++;
				//장바구니에 상품이 이미 들어있다면 장바구니에 담은 개수만 1 증가
				list.get(i).setQuantity(list.get(i).getQuantity()+1);
			}
		}
		
		//장바구니구니에 해당 상품이 없다면
		if(cnt==0) {
			vo.setQuantity(1);
			//최종목표 : 장바구니에 상품을 추가
			list.add(vo);
		}
		//장바구니 확인
		for(ProductVO pv : list) {
			log.info("pv : " + pv.toString());
		}
		
		return "redirect:/detail?productId=" + productId;
	}
	
	//요청URI : /cart
	@RequestMapping(value="/cart",method = RequestMethod.GET)
	public String cart() {
		return "product/cart";
	}
	
	@RequestMapping(value="/removeCart",method = RequestMethod.GET)
	public String removeCart(@RequestParam String productId, Model model, 
			@ModelAttribute ProductVO productVO, HttpServletRequest request) {
			log.info("productId : " + productId);
			
			HttpSession session = request.getSession();
			ArrayList<ProductVO> cartlist =
			(ArrayList<ProductVO>)session.getAttribute("cartlist");
				for(int i=0;i<cartlist.size();i++){
			if(cartlist.get(i).getProductId().equals(productId)){
				cartlist.remove(cartlist.get(i));
			}
				}
			return  "product/cart";
	}

	@RequestMapping(value="/deleteCart", method=RequestMethod.GET)
	public String deleteCart(@RequestParam String productId, Model model, 
			@ModelAttribute ProductVO productVO, HttpServletRequest request) {
		log.info("productId: " + productId);
		HttpSession session = request.getSession();
		session.invalidate();
		return  "product/cart";
	}
	
	@RequestMapping(value="/shippingInfo",method = RequestMethod.GET)
	public String shippingInfo(HttpServletRequest request) {
		return "product/shippingInfo";
	
	}
	
	@RequestMapping(value="/processShippingInfo",method = RequestMethod.POST)
	public String processShippingInfo(
			 HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
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
		
		return "redirect:/product/orderConfirmation";
		
	}
	@RequestMapping(value="/orderConfirmation",method = RequestMethod.GET)
	public String orderConfirmation() {
		return "product/cart";
		
	}
}




