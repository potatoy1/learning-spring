package kr.or.ddit.Controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {

	//요청 파라미터: register?userId=hongkd&passwd=1234
	@GetMapping("/register")
	public String registerByParameter(String userId, String passwd) {
		log.info("registerByParameter에 왔다");
		
		log.info("userId : " + userId);
		log.info("passwd : " + passwd);
		//forwarding
		return "success";
	}
	
	//URL 경로 상의 경로 변수로부터 요청 데이터를 취득
	//경로(path) 변수(Variable)!
	///요청URI : /register/hongkd
	@RequestMapping(value="/register/{userId}", method=RequestMethod.GET)
	public String registerByPath(@PathVariable String userId) {
		log.info("registerByPath에왔다.");
		
		log.info("userId : " + userId);
		//forwarding
		return "success";
	}
	
	// /register => register.jsp 를  forwarding
	@GetMapping("/register01")
	public String register01() {
		return "register";
	}
	
	//URL : /register01
	//요청 파라미터:{"userId":"hongkd","password":"1234","coin":"100"}
	public String register01Post(String userId, String password, String coin) {
		log.info("userId : " + userId);
		log.info("password: " + password);
		log.info("coin : " + coin);
		//forwarding
		return "success";
	}
	@GetMapping("/register/register03")
	public String register03() {
		//forwarding
		return "register/register";
	}
	
	/*
	 요청URL : /register/register03 
	
	 폼 필드 값이 숫자일 경우 컨트롤러 타입을 숫자형으로 작성하여 숫자로 타입변환후
	 요청 데이터를 취득할 수 있음
	 */
	@PostMapping("/register/register03")
	public String register03Post(String userId, String password, int coin){
		log.info("userId : " + userId);
		log.info("password: " + password);
		log.info("coin : " + coin);
		return "register/success";
	}
	
	//골뱅이PathVariable : URL에서 경로 변수 값을 가져오기 위한 애너테이션
	//URL 경로 상의 경로 변수(PathVariable)가 여러 개일 때
	//골뱅이PathVariable 어노테이션을 사용하여 특정한 경로 변수명을 지정
	//요청URI : /register/register03/a001/100
	@RequestMapping(value="/register/register03/{userId}/{coin}")
	public String register03ByPath(@PathVariable("userId")String userId,
			@PathVariable("coin")int coin) {
		log.info("register03ByPath에 왔다.");
		log.info("userId : " + userId);//a001
		log.info("coin : " + coin);//100
		//forwarding
		return "register/success";
	}
	
	@GetMapping("/register/register04")
	public String register04ByParam() {
		return "register/register04";
	}
	
	//요청URL : /register/register04
	//요청 파라미터 : {"userId":"a001","password":"1234","coin":"100"}
	@PostMapping("/register/register04")
	public String register04ByParamPost(@RequestParam("userId") String id,@RequestParam("password")String pw, @RequestParam("coin")String coin) {
		log.info("id : " + id);
		log.info("pw : " + pw);
		log.info("coin : " + coin);
	
		return "register/success";
	}
	
	@GetMapping("/register/register05")
	public String register05ByParam() {
		return "register/register05";
	}
	
	//폼 텍스트 필드 요소의 값을 자바빈즈 매개변수의 정수 타입 매개변수로 처리 됨 
	//요청파라미터 : {"userId":"a001","password":"1234","coin":"100"}
	//MemberVO => private int coin
	@PostMapping("/register/register05")
	public String register05ByBeansPost(MemberVO memberVO, int coin) {
		log.info("memberVO : " + memberVO.toString());
		log.info("coin: " + coin);
		//forwarding
		return "register/success";
	}
	
	//요청URI : /registerByGet01?userId=a001&birth=1234(x)
	//요청URI : /registerByGet01?userId=a001&birth=2022-10-31(x)
	//요청URI : /registerByGet01?userId=a001&birth=20221031(x)
	//요청URI : /registerByGet01?userId=a001&birth=2022/10/31(o)
	@PostMapping("/register/registerByGet01")
	public String registerByGet01(String userId, Date birth) {
		log.info("registerByGet01에왔다");
		log.info("userId : " + userId);
		log.info("birth:" + birth);
		//forwarding
		return "register/success";
	}
	
	//요청URI : /registerByGet02?userId=a001&birth=1234(x)
	//요청URI : /registerByGet02?userId=a001&birth=2022-10-31(x)
	//요청URI : /registerByGet02?userId=a001&birth=20221031(x)
	//요청URI : /registerByGet02?userId=a001&birth=2022/10/31(o)
	@GetMapping("/register/registerByGet02")
	public String registerByGet02(MemberVO memberVO) {
		log.info("registerByGet02에왔다");
		log.info("userId : " + memberVO.getUserId());
		log.info("birth:" + memberVO.getBirth());
		//forwarding
		return "register/success";
	}
}
