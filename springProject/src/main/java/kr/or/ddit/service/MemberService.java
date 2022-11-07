package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.CardVO;
import kr.or.ddit.vo.MemberVO;

public interface MemberService {
	//메소드 시그니처
	//MEMBER, ADDRESS, CARD 동시에 insert
	public int memberInsert(MemberVO memberVO);


}
