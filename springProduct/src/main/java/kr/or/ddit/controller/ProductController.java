package kr.or.ddit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	//상품 등록
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProductPost(ModelAndView mav, @ModelAttribute ProductVO productVO) {
		log.info("ProductVO : " + productVO.toString());
		//PRODUCT 테이블에 insert
		//result > 0 => insert 성공, result == 0 => 실패
		int result = this.productService.insertProduct(productVO);
		
		log.info("result : " + result);
		
		if(result > 0) {//입력 성공
			mav.setViewName("redirect:/product?productId=" + productVO.getProductId());
		}else {//입력 실패
			mav.setViewName("redirect:/addproduct");
		}
		
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
		
	//상품 상세
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public ModelAndView detail(ModelAndView mav,@ModelAttribute ProductVO productVO) {
		
		log.info("productVO : " + productVO.toString());
		
		ProductVO data = this.productService.selectDetail(productVO);

		mav.setViewName("product/product");
		mav.addObject("data",data);
		mav.addObject("productId",data.getProductId());
		return mav;
	}
	
	//상품 목록
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mav, @RequestParam(value = "keyword", required = false) String keyword){
		
		List<ProductVO> list = this.productService.list(keyword);
		
		for(ProductVO vo : list) {
			log.info("vo:" + vo.toString());
		}

		//forwarding
		mav.setViewName("product/products");
		//select 결과 목록을 데이터로 넣어줌
		mav.addObject("data",list);
		
		return mav;
	}
	
	//상품 수정
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView update(ProductVO productVO, ModelAndView mav) {
		
		
		//책 상세 데이터
		ProductVO data = this.productService.selectDetail(productVO);
		mav.addObject("data", data);
		
		//view : jsp의 경로
		//servlet-context.xml에서 설정한대로..
		// /WEB-INF/views/ + ... + .jsp
		
		//forwarding
		mav.setViewName("product/update");
		
		return mav;
	}
	//상품 변경
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ModelAndView updatePost( @ModelAttribute ProductVO productVO ,ModelAndView mav) {
		log.info("updatePost=>productVO : " +productVO.toString());
		int result = this.productService.update(productVO);
		if(result>0) {	//업데이트 성공-> 상세페이지(product.jsp)로 이동
			mav.setViewName("redirect:/product?productId=" + productVO.getProductId());
		}else {//업데이트 실패=> 업데이트뷰(update.jsp)로 페이지 이동
			mav.setViewName("redirect:/update?productId=" +productVO.getProductId());
		}
		return mav;
	}
	
	//상품 삭제
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView delete(ModelAndView mav, int productId) {
		log.info("productId : " + productId);
		
		//해당 글 삭제
		int result = this.productService.delete(productId);
		if(result > 0) {//삭제 성공
			//목록으로 요청 이동(상세페이지가 없으므로..)
			mav.setViewName("redirect:/products");
		}else {//삭제 실패
		mav.setViewName("redirect:/product?productId="+productId);
		}
		return mav;
		
	}
	
}
