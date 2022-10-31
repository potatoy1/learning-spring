package kr.or.ddit.vo;

import java.util.Date;

//자바빈 클래스
public class MemberVO {
	//회원 아이디
	private String userId = "gaeddongi";
	//비밀번호
	private String password = "java";
	//보유 코인
	private int coin = 100;
	//생일
	private Date birth;
	//기본 생성자
	public MemberVO() {}
	//getter/setter메소드
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", password=" + password + ", coin=" + coin + ", birth=" + birth + "]";
	}

	
	
}
