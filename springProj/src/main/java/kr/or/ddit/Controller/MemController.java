package kr.or.ddit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.ddit.vo.MemVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemController {

	@GetMapping("/board/list")
	public String tables() {
		return "board/list";
	}
	@PostMapping("/register/tables")
	public String tablesPost(MemVO memVO, int coin) {
		log.info("memVO : " + memVO.toString());
		log.info("memId: " + memVO.getMemId());
		log.info("memName: " + memVO.getMemName());
		log.info("memJob: " + memVO.getMemJob());
		log.info("memLike: " + memVO.getMemLike());
		log.info("memSkill: " + memVO.getMemSkill());
		//forwarding
		return "board/success";
	}
}
