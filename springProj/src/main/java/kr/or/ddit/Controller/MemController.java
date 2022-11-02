package kr.or.ddit.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.MemService;
import kr.or.ddit.util.ArticlePage;
import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.CardVO;
import kr.or.ddit.vo.MemVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class MemController {
	@Autowired
	MemService memService;
	
	//요청URI : /board/list?currentPage=2
	//요청 파라미터: currentPage=2
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mav, @RequestParam(defaultValue="1",required=false)int currentPage, @RequestParam Map<String,String> map) {
		
		log.info("currentPage : " + currentPage);
		// /board/list 이렇게 요청되었을 경우의 처리
		String cPage = map.get("currentPage");
		String show = map.get("show");
		String keyword = map.get("keyword");
		if(cPage==null) {
			map.put("currentPage", "1");
		}
		if(show==null) {
			map.put("show", "10");
		}
		if(keyword==null) {
			map.put("keyword", "");
		}
		
		log.info("map : " + map);
		
		List<MemVO> list = this.memService.list(map);
		
		//MEM 테이블의 전체 행 수 구함
		int total = this.memService.getTotal(map);
		
		//한 화면에 보여질 행 수
		int size = Integer.parseInt(map.get("show"));
		
		for(MemVO vo : list) {
			log.info("vo : " + vo.toString());
		}
		
		//forwarding
		mav.setViewName("board/list");
		//(전체 글 수, 현재페이지, 한 화면에 보여질 행 수, select 결과 list)
		mav.addObject("data", new ArticlePage<MemVO>(total, currentPage, size, list));
		
		return mav;
	}
	
//	@RequestMapping(value="/tree",method=RequestMethod.GET)
//	public ModelAndView list(ModelAndView mav){
//		List<MemVO> list = this.memService.list();
//		
//		for(MemVO vo : list) {
//			log.info("vo : " + vo.toString());
//		}
//		
//		//forwarding
//		mav.setViewName("board/tree");
//		//select 결과 목록을 데이터로 넣어줌
//		mav.addObject("data", list);
//		
//		return mav;
//	}

	@GetMapping("/create")
	public String create() {
		return "board/create";
	}
	
	@PostMapping("/create")
	public String createPost(@ModelAttribute MemVO memVO, Model model) {
		
		log.info("나중 memberVO : " + memVO.toString());
		int result = this.memService.memInsert(memVO);
		model.addAttribute("result",result);
		
		//redirect--> controller통해서 감.
		return "redirect:/board/list";
	}
	
//	@RequestMapping(value="/create", method=RequestMethod.GET)
//	public ModelAndView create() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("board/create");
//		return mav;
//	}
//	
//	
//	@RequestMapping(value="/create", method=RequestMethod.POST)
//	public ModelAndView createPost(ModelAndView mav, @ModelAttribute MemVO memVO) {
//		int result = this.memService.memInsert(memVO);
//		
//		if(result < 1) {
//			mav.setViewName("redirect:/create");
//		} else {
//			mav.setViewName("redirect:/board/list");
//		}
//		return mav;
//	}
	
}
