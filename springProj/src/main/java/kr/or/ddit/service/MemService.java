package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.MemVO;


public interface MemService {
	//메소드 시그니처
	//MEMBER, ADDRESS, CARD 동시에 insert
	public int memInsert(MemVO memVO);

	public List<MemVO> list();
}
