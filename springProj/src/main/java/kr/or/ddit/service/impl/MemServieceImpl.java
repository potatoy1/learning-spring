package kr.or.ddit.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dao.MemDao;
import kr.or.ddit.service.MemService;
import kr.or.ddit.util.FileUploadUtil;
import kr.or.ddit.vo.MemVO;

@Service
public class MemServieceImpl implements MemService {
	//DI(의존성 주입)
	@Inject
	MemDao memDao;
	
	@Inject
	FileUploadUtil fileUploadUtil;
	
	//메소드 골뱅이 어노테이션(@Transactional)을 부여
	/*
	 회원 정보를 저장하다가 실패하거나 주소 정보를 저장하다가 실패하거나
	 카드정보를 저장하다가 실패하면 모두 저장이 되지 않고 rollback이 됨
	 */
	@Transactional
	@Override
	public int memInsert(MemVO memVO) {
		this.memDao.memInsert(memVO);
		//FileUploadUtil활용 -> 업로드, ATTACH테이블에 insert
		return this.fileUploadUtil.fileUploadAction(memVO.getPictureArray(), memVO.getMemId());
		
		
	}

	//전체 목록
	@Override
	public List<MemVO> list(Map<String,String> map) {
		return this.memDao.list(map);
	}

	//MEM 전체 행 수 구함 
	@Override
	public int getTotal(Map<String,String> map) {
		return this.memDao.getTotal(map);
	}
	
	//아이디 중복체크
	public int chkDup(String memId) {
		return this.memDao.chkDup(memId);
	}
}
