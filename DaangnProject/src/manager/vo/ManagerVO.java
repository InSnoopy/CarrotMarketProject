package manager.vo;

public class ManagerVO {

	private String managerId;
	private String managerPw;
	private String managerNic;
	
	public ManagerVO() {
		super();
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerPw() {
		return managerPw;
	}
	public void setManagerPw(String managerPw) {
		this.managerPw = managerPw;
	}
	public String getManagerNic() {
		return managerNic;
	}
	public void setManagerNic(String managerNic) {
		this.managerNic = managerNic;
	}
	@Override
	public String toString() {
		return "ManagerVO [managerId=" + managerId + ", managerPw=" + managerPw + ", managerNic=" + managerNic + "]";
	}
	
}
