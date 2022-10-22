package kr.or.ddit.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.vo.ProductVO;

public class ProductDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(ProductVO productVO) {
		return this.sqlSessionTemplate.insert("product.insert",productVO);
	}
}
