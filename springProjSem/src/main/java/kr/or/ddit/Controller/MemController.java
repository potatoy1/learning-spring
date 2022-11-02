package kr.or.ddit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.MemService;
import kr.or.ddit.vo.MemVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemController {
	
	@Autowired
	MemService memService;
	
	//요청 URI : /board/list?currentPage=2
	//요청 파라미터 : currentPage=2
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mav, int currentPage) {
		
		log.info("currentPage : " + currentPage);
		
		List<MemVO> list = this.memService.list(currentPage);
		
		for(MemVO vo : list) {
			log.info("vo : " + vo.toString());
		}
		mav.setViewName("board/list");
		mav.addObject("data", list);
		return mav;
	}
	
	@RequestMapping(value="/create2", method=RequestMethod.GET)
	public ModelAndView create2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/create2");
		return mav;
	}
	
	
	@RequestMapping(value="/create2", method=RequestMethod.POST)
	public ModelAndView create2Post(ModelAndView mav, @ModelAttribute MemVO memVO) {
		int result = this.memService.insert(memVO);
		
		if(result < 1) {
			mav.setViewName("redirect:/create2");
		} else {
			mav.setViewName("redirect:/board/list");
		}
		return mav;
	}
	
}
