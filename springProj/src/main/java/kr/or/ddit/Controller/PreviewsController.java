package kr.or.ddit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.service.MemService;
import kr.or.ddit.vo.MemVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/previews")
public class PreviewsController {
	
	@Autowired
	MemService memService;
	
	/**
	//요청URI : /previews/write
	//방식 : get
	//PreviewsController.java(견우) <-  memVO(오작교)  -> write.jsp(직녀)
	*/
	@GetMapping("/write")
	public String write(@ModelAttribute MemVO memVO) {
		//forwarding
		return"previews/write";
	}
	
	/**
	 * 요청URI : /previews/writePost
	 * 방식  : post
	 * request객체에 요청 파라미터가 들어있음 -> Validated -> 요청 파라미터 검증
	 * vo-> 골뱅이ModelAttribute(생략가능)
	 * String, Map, int -> 골뱅이RequestParam
	 * 
	 * 입력값 검증 대상의 도메인 클래스(memVO) 직후에 BindingResult를 정의함
	 * BindingResult에는 요청 파라미터 데이터의 바인딩 에러(멤버변수에 없음)와
	 * 입력값 검증 에러(애너테이션 오류) 정보가 저장됨
	 */
	@PostMapping("/writePost")
	public String writePost(@Validated MemVO memVO, BindingResult result) {
		
		log.info("memVO: " + memVO.toString());
		//입력값 검증 오류 발생시 true 반환/ 오류 없으면 false 반환
		log.info("result.hasErrors() : " + result.hasErrors());
		
		//입력값 검증 후 BindingResult가 제공하는 메서드를 이용하여 검사 결과 확인
		/* 
		 1. hasErrors() : 오류가 발생한 경우 true 반환
		 2. hasGloblaErrors() : 객체 레벨의 오류가 발생한 경우 true 반환
		 3. hasFieldErrors() : 필드(멤버변수) 레벨의 오류가 발생한 경우 true 반환
		 4. hasFieldErrors(String)  : 인수에 지정한 필드에 오류 발생 시  true반환
		 */
		if(result.hasErrors()) {//오류가 있다면
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();//객체 레벨
			List<FieldError> fieldErrors = result.getFieldErrors();//멤버변수 레벨
			
			for(int i=0;i<allErrors.size();i++) {
				ObjectError objectError = allErrors.get(i);
				log.info("allError : " + objectError);
			}
			for(int i=0;i<globalErrors.size();i++) {
				ObjectError objectError = globalErrors.get(i);
				log.info("allError : " + objectError);
			}
			for(int i=0;i<fieldErrors.size();i++) {
				FieldError fieldError = fieldErrors.get(i);
				log.info("allError : " + fieldErrors);
				log.info("fieldError.getDefaultMessage() : " + fieldError.getDefaultMessage());
			}
		}
		
		int rslt = this.memService.memInsert(memVO);
		
		//forwarding
		return "previews/write";
	}
	
	@GetMapping("/list")
	public String memList(Model model) {
		
		List<MemVO> memVOList = this.memService.memList2();
		
		log.info("memVOList: " + memVOList);
		
		model.addAttribute("memVOList", memVOList);
		
		//forwarding
		return "previews/list";
	}
}
