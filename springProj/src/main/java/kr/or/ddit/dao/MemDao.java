package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

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
	//전체 목록
	public List<MemVO> list(Map<String,String> map){
		return this.sqlSessionTemplate.selectList("mem.list",map);
	}
	
	//MEM 전체 행 수 구함 
	//<select id="getTotal" resultType="int">
	public int getTotal(Map<String,String> map) {
		return this.sqlSessionTemplate.selectOne("mem.getTotal",map);
	}
}









