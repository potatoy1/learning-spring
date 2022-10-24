package kr.or.ddit.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.ProductVO;

@Repository
public class ProductDao {
	//의존성 주입(Dependency Injection-DI)
	//제어의 역전(Inversion of Control - IoC)
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//PRODUCT 테이블에 insert
	public int insertProduct(ProductVO productVO) {
		//.insert("namespace.id",파라미터)
		return sqlSessionTemplate.insert("product.insert", productVO);
	}
	
	//상품 목록
	public List<ProductVO> list(){
		return this.sqlSessionTemplate.selectList("product.list");
	}
	
	//상품 상세보기
	public ProductVO selectDetail(ProductVO productVO) {
		return this.sqlSessionTemplate.selectOne("product.select_detail",productVO);
	}
	
	//상품 목록보기
	public List<ProductVO> list(String keyword){
		//select 결과물 목록으로 받음. selectList("namespace.id",파라미터)
		return this.sqlSessionTemplate.selectList("product.list",keyword);
	}
	
	//상품 수정하기
	//매퍼xml에서 insert/update/delete의 resultType은 생략
	public int update(ProductVO productVO) {
		//.update("namespace.id",parameter)
		return this.sqlSessionTemplate.update("product.update",productVO);
	}
	
	//상품 삭제하기
	public int delete(int productId) {
		//.delete("namespace.id",parameter)
		return this.sqlSessionTemplate.delete("product.delete",productId);
	}
}
