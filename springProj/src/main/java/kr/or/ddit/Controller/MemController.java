package kr.or.ddit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.MemService;
import kr.or.ddit.vo.MemVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class MemController {
	@Autowired
	MemService memService;
	
	@RequestMapping(value="/list2",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mav) {
		List<MemVO> list = this.memService.list();
		
		for(MemVO vo : list) {
			log.info("vo : " + vo.toString());
		}
		
		//forwarding
		mav.setViewName("board/list2");
		//select 결과 목록을 데이터로 넣어줌
		mav.addObject("data", list);
		
		return mav;
	}
}
