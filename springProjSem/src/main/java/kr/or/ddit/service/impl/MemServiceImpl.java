package kr.or.ddit.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.MemDao;
import kr.or.ddit.service.MemService;
import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.MemVO;

@Service
public class MemServiceImpl implements MemService {
	
	@Autowired
	MemDao memDao;

	@Override
	public List<MemVO> list(int currentPage) {
		return this.memDao.list(currentPage);
	}
	
	@Override
	public int insert(MemVO memVO) {
		return this.memDao.insert(memVO);
	}
	
}
