package kr.or.ddit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dao.MemberDao;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.vo.CardVO;
import kr.or.ddit.vo.MemberVO;

@Service
public class MemberServieceImpl implements MemberService {
	//DI(의존성 주입)
	@Inject
	MemberDao memberDao;
	
	//메소드 골뱅이 어노테이션(@Transactional)을 부여
	/*
	 회원 정보를 저장하다가 실패하거나 주소 정보를 저장하다가 실패하거나
	 카드정보를 저장하다가 실패하면 모두 저장이 되지 않고 rollback이 됨
	 */
	@Transactional
	@Override
	public int memberInsert(MemberVO memberVO) {
		//MEMBER 테이블에 insert
		this.memberDao.memberInsert(memberVO);
		//ADDRESS 테이블에 insert
		this.memberDao.addressInsert(memberVO);
		//CARD 테이블에 insert
		List<CardVO> cardVOList = memberVO.getCardVOList();//userId가 null
		List<CardVO> cardVOList2 = new ArrayList<CardVO>();//userId가 채워짐
		
		for(CardVO vo : cardVOList) {
			vo.setUserId(memberVO.getUserId());
			cardVOList2.add(vo);
		}
		
		return this.memberDao.insertCard(cardVOList);
	}

}
