package kr.or.ddit.mapper;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemVO;

public interface MemMapper {
	//글 목록
	//memList(Map<String,String>map)=>mapper파일의 id(resultType)
	public List<MemVO> list(Map<String,String>map);		
	
	//등록
	public int memInsert(MemVO memVO) ;
	
	//MEM 전체 행 수 구함 
	//<select id="getTotal" resultType="int">
	public int getTotal(Map<String,String> map);
	
	
	//아이디 중복체크
	//<select id="chkDup" parameterType="String">
	public int chkDup(String memId);
	
	//상세보기
	public MemVO detail(String memId);
	
}
