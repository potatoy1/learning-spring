package kr.or.ddit.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.MemVO;


@Repository
public class MemDao {
	

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//MEM 테이블에 insert
	public int memInsert(MemVO memVO) {
		return this.sqlSessionTemplate.insert("mem.memInsert",memVO);
	}
	public List<MemVO> list(){
		return this.sqlSessionTemplate.selectList("mem.list");
	}
	
}









