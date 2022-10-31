package kr.or.ddit.vo;

public class MemVO {
	private String memId;//회원 아이디
	private String memName;//회원 명
	private String memJob;//직업
	private String memLike;//취미
	private String memSkill;//특기
	
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

	@Override
	public String toString() {
		return "MemVO [memId=" + memId + ", memName=" + memName + ", memJob=" + memJob + ", memLike=" + memLike
				+ ", memSkill=" + memSkill + "]";
	}
	
	
}
