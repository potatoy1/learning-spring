package kr.or.ddit.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.MemService;
import kr.or.ddit.util.ArticlePage;
import kr.or.ddit.util.FileUploadUtil;
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
	
	@Inject
	FileUploadUtil FileUploadUtil;
	
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
	
//	@GetMapping("/create")
//	public String create() {
//		return "board/create";
//	}
//	
//	@PostMapping("/create")
//	public String createPost(@ModelAttribute MemVO memVO, Model model) {
//		
//		log.info("나중 memberVO : " + memVO.toString());
//		int result = this.memService.memInsert(memVO);
//		model.addAttribute("result",result);
//		
//		//redirect--> controller통해서 감.
//		return "redirect:/board/list";
//	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/create");
		return mav;
	}
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createPost(ModelAndView mav, @ModelAttribute MemVO memVO) {
		int result = this.memService.memInsert(memVO);
		
		if(result < 1) {
			mav.setViewName("redirect:/create");
		} else {
			mav.setViewName("redirect:/board/list");
		}
		return mav;
	}
	
	//요청URI : /board/chkDup
	//요청파라미터 : {"memId":"a001"}
	//방식: post
	//JSON데이터로 리턴. 중복이 있으면{"result":"1"}, 중복이 없으면{"result":"0"}
	//String memId/@RequestParam Map<String,String> map=>문제 발생
	//ajax로 요청된 JSON데이터는 무조건 RequestBody로 받자
	@ResponseBody
	@PostMapping("/chkDup")
	public Map<String,String> chkDup(@RequestBody Map<String,String>json) {
		log.info("json: " + json);
		Map<String, String> rsltmap = new HashMap<String, String>();
		int result = this.memService.chkDup(json.get("memId"));
		rsltmap.put("result", result+"");
		return rsltmap;
	}
	
	/* 8.파일업로드 폼 방식 요청처리
	  	파일업로드 폼 파일<input type="file"...요소(=태그)값을
	  	스프링MVC가 지원하는 MultipartFile 매개변수로 처리함
	 */
	@GetMapping("/register06")
	public String register06() {
		return "/board/register06";
	}
	//<input type="file" name="picture" />
	//MultipartFile			   picture
	@PostMapping("/registerFile01")
	public String registerFile01Post(MultipartFile picture) {
		log.info("registerFile01");
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		
		//forwarding
		return "board/success";
	}
	@PostMapping("/registerFile02")
	public String registerFile02Post(String userId, String password,MultipartFile picture) {
		log.info("registerFile02");
		log.info("userId: " + userId);
		log.info("password: " + password);
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		
		//forwarding
		return "board/success";
	}
	@PostMapping("/registerFile03")
	public String registerFile03Post(MemVO memVO,MultipartFile picture) {
		log.info("registerFile03");
		log.info("memVO: " + memVO.toString());
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		
		//forwarding
		return "board/success";
	}
	@PostMapping("/registerFile05")
	public String registerFile05Post(MemVO memVO,MultipartFile picture,MultipartFile picture2) {
		log.info("registerFile05");
		log.info("memVO: " + memVO.toString());
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("size: " + picture.getSize());
		log.info("contentType: " + picture.getContentType());
		log.info("originalName : " + picture2.getOriginalFilename());
		log.info("size: " + picture2.getSize());
		log.info("contentType: " + picture2.getContentType());
		
		//forwarding
		return "board/success";
	}
	@PostMapping("/registerFile06")
	public String registerFile06Post(MemVO memVO,List<MultipartFile> pictureList) {
		log.info("registerFile06");
		log.info("memVO: " + memVO.toString());
		
		for(MultipartFile picture : pictureList) {
			log.info("originalName : " + picture.getOriginalFilename());
			log.info("size: " + picture.getSize());
			log.info("contentType: " + picture.getContentType());
			
		}
		//forwarding
		return "board/success";
	}
	@PostMapping("/registerFile07")
	public String registerFile07Post(MemVO memVO,MultipartFile[] pictures) {
		log.info("registerFile07");
		log.info("memVO: " + memVO.toString());
		
		MultipartFile[] pictureArray = memVO.getPictureArray();
		
		for(MultipartFile picture : pictureArray) {
			log.info("originalName : " + picture.getOriginalFilename());
			log.info("size: " + picture.getSize());
			log.info("contentType: " + picture.getContentType());
			
		}
		//forwarding
		return "board/success";
	}
	
	@GetMapping("/register07")
	public String register07Get() {
		//forwarding
		return "board/register07";
	}
	
	@RequestMapping(value="/uploadAjax", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile[] file){
		String originalFileName = file[0].getOriginalFilename();
		log.info("originalName : " + originalFileName);
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS" + originalFileName,HttpStatus.OK);
		
		UUID uid = UUID.randomUUID();
		
		this.FileUploadUtil.fileUploadAction(file, uid.toString());
		return entity;
	}
	

}
