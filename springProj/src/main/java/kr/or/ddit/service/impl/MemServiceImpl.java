package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.mapper.MemMapper;
import kr.or.ddit.service.MemService;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.MemVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemServiceImpl implements MemService {
	@Autowired
	MemMapper memMapper;
	
	//회원번호 생성
	@Override
	public int makeUserNo() {
		return this.memMapper.makeUserNo();
	}
	
	//중복 아이디 체크
	@Override
	public int dupChk(MemVO memVO) {
		return this.memMapper.dupChk(memVO);
	}
	
	//회원 및 회원권한 insert. 스프링이 알아서 트랜잭션 처리를 해줌
	@Transactional
	@Override
	public int insert(MemVO memVO) {
		//하나의 트랜잭션에 여러개의 SQL이 실행되고 있음
		//회원테이블(MEM) INSERT
		this.memMapper.insertMem(memVO);
		//첨부파일이 있을 때에만 실행
		if(memVO.getAttachVOList()!=null) {
			//첨부테이블(ATTACH) INSERT (List<AttachVO>) => 선택
			this.memMapper.insertAttach(memVO.getAttachVOList());
		}
		
		//회원 권한 테이블(MEM_AUTH) INSERT => 필수
		return this.memMapper.insertMemAuth(memVO.getMemAuthVOList());
	}
	
	//회원 목록
	@Override
	public List<MemVO> memList(Map<String,String> map){
		return this.memMapper.memList(map);
	}
	
	//회원 전체 수(검색 포함)
	@Transactional
	@Override
	public int memTotal(Map<String,String> map){
		return this.memMapper.memTotal(map);
	}
	
	//새로운 MEM 테이블에 insert
	@Override
	public int memInsert(MemVO memVO) {
		int result = 0;
		//transaction : 데이터베이스를 변경하기 위해 수행되어야 할 논리적 단위
		//				여러개의 SQL로 구성됨
		//MEM테이블 insert(1건)
		result += this.memMapper.memInsert(memVO);
		log.info("result[1]: " + result);
		
		//ATTACH 테이블 insert(N건)
		//insertAttach -> List<AttachVO>
		List<AttachVO> attachVOList = memVO.getAttachVOList();
		
		//attachVOList=[AttachVO(userNo=0, seq=0,filename=attach01, filesize=0, regdate=null]
		//,AttachVO(userNo=0,seq=0,filename=attach02,filesize=0, regdate=null)]
		//데이터 보정 작업
		for(int i=0;i<attachVOList.size();i++) {
			attachVOList.get(i).setUserNo(memVO.getUserId());//a201, a202
			attachVOList.get(i).setSeq(i+1); //1, 2
		}
		
		
		result += this.memMapper.insertAttach(attachVOList);
		log.info("result[2]: " + result);
		
		return result;
	}
	
	//새로운 MEM 테이블 list
	@Override
	public List<MemVO> memList2(){
		return this.memMapper.memList2();
	}
	
	//회원 상세
	@Override
	public MemVO memDetail(String userNo) {
		return this.memMapper.memDetail(userNo);
	}
	
	//비밀번호 체크
	@Override
	public int detailPwCheck(MemVO memVO) {
		return this.memMapper.detailPwCheck(memVO);
	}
	
	//회원정보변경
	@Override
	public int memUpdate(MemVO memVO) {
		return this.memMapper.memUpdate(memVO);
	}
	
	//회원 삭제
	@Override
	public int memDelete(int userNo) {
		return this.memMapper.memDelete(userNo);
	}
}
