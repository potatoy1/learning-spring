package kr.or.ddit.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//자바빈 클래스
@Data
public class CardVO {
	private String no;
	//2022-11-01(기본 : 2022/11/01)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date validMonth;
	private String userId;
}
