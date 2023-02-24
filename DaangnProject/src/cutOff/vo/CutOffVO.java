package cutOff.vo;

public class CutOffVO {
	
	private String memId1;
	private String memId2;
	
	public CutOffVO() {
		super();
	}
	public String getMemId1() {
		return memId1;
	}
	public void setMemId1(String memId1) { //차단한사람
		this.memId1 = memId1;
	}
	public String getMemId2() { //차단당한사람
		return memId2;
	}
	public void setMemId2(String memId2) {
		this.memId2 = memId2;
	}
	@Override
	public String toString() {
		return "CutOffVO [memId1=" + memId1 + ", memId2=" + memId2 + "]";
	}
	
	

}
