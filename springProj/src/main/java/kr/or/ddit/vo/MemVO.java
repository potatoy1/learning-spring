package kr.or.ddit.vo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MemVO {
	private String memId;//회원 아이디
	private String memName;//회원 명
	private String memJob;//직업
	private String memLike;//취미
	private String memSkill;//특기
	private String memHp;
	//MEM테이블에 없어도 사용 가능
	private String userId;
	private String password;
	private MultipartFile picture;
	private MultipartFile picture2;
	//..name="pictureList[0]"
	private List<MultipartFile> pictureList;
	//..name="pictureArray"
	private MultipartFile[] pictureArray;
	
	//기본 생성자
	public MemVO() {}

	//getter/setter메소드
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemJob() {
		return memJob;
	}

	public void setMemJob(String memJob) {
		this.memJob = memJob;
	}

	public String getMemLike() {
		return memLike;
	}

	public void setMemLike(String memLike) {
		this.memLike = memLike;
	}

	public String getMemSkill() {
		return memSkill;
	}

	public void setMemSkill(String memSkill) {
		this.memSkill = memSkill;
	}

	public String getMemHp() {
		return memHp;
	}

	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}

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

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}

	public MultipartFile getPicture2() {
		return picture2;
	}

	public void setPicture2(MultipartFile picture2) {
		this.picture2 = picture2;
	}

	public List<MultipartFile> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<MultipartFile> pictureList) {
		this.pictureList = pictureList;
	}

	public MultipartFile[] getPictureArray() {
		return pictureArray;
	}

	public void setPictureArray(MultipartFile[] pictureArray) {
		this.pictureArray = pictureArray;
	}

	@Override
	public String toString() {
		return "MemVO [memId=" + memId + ", memName=" + memName + ", memJob=" + memJob + ", memLike=" + memLike
				+ ", memSkill=" + memSkill + ", memHp=" + memHp + ", userId=" + userId + ", password=" + password
				+ ", picture=" + picture + ", picture2=" + picture2 + ", pictureList=" + pictureList + ", pictureArray="
				+ Arrays.toString(pictureArray) + "]";
	}





	
	
	
}
