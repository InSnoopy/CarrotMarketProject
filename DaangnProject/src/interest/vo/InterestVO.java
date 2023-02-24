package interest.vo;

public class InterestVO {
	
	private int boardId;
	private String memId;
	
	public InterestVO() {
		super();
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	@Override
	public String toString() {
		return "InterestVO [boardId=" + boardId + ", memId=" + memId + "]";
	}
}
