package member.vo;

import java.util.Date;

/**
 * DB 테이블에 존재하는 컬럼이름을 기준으로 데이터를 객체화한 클래스
 *
 * <p>
 * DB 테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.<br>
 * </p>
 *
 */

public class MemberVO {

	private String memId; // 필수
	private String memPw; // 필수
	private String memNic; // 필수
	private String profile;
	private Date memReg; // 필수
	private String memName; // 필수
	private String memTel; // 필수
	private String memAddr1; // 필수
	private String memAddr2;
	private String memAddr3;
	private int memSanc;
	private double mannersTempNow;
	private String memMail; // 필수
	
	public MemberVO() {
	}
	
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemNic() {
		return memNic;
	}
	public void setMemNic(String memNic) {
		this.memNic = memNic;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Date getMemReg() {
		return memReg;
	}
	public void setMemReg(Date memReg) {
		this.memReg = memReg;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	public String getMemAddr1() {
		return memAddr1;
	}
	public void setMemAddr1(String memAddr1) {
		this.memAddr1 = memAddr1;
	}
	public String getMemAddr2() {
		return memAddr2;
	}
	public void setMemAddr2(String memAddr2) {
		this.memAddr2 = memAddr2;
	}
	public String getMemAddr3() {
		return memAddr3;
	}
	public void setMemAddr3(String memAddr3) {
		this.memAddr3 = memAddr3;
	}
	public int getMemSanc() {
		return memSanc;
	}
	public void setMemSanc(int memSanc) {
		this.memSanc = memSanc;
	}
	public double getMannersTempNow() {
		return mannersTempNow;
	}
	public void setMannersTempNow(double mannersTempNow) {
		this.mannersTempNow = mannersTempNow;
	}
	
	@Override
	public String toString() {
		return String.format(
				"MemberVO [memId=%s, memPw=%s, memNic=%s, profile=%s, memReg=%s, memName=%s, memTel=%s, memAddr1=%s, memAddr2=%s, memAddr3=%s, memSanc=%s, mannersTempNow=%s, memMail=%s]",
				memId, memPw, memNic, profile, memReg, memName, memTel, memAddr1, memAddr2, memAddr3, memSanc,
				mannersTempNow, memMail);
	}
}