package boardPicture;

public class BoardPictureVO {
	
	private int picId;
	private String picName;
	private int boardId;
	
	public BoardPictureVO() {
		super();
	}
	public int getPicId() {
		return picId;
	}
	public void setPicId(int picId) {
		this.picId = picId;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	@Override
	public String toString() {
		return "BoardPictureVO [picId=" + picId + ", picName=" + picName + ", boardId=" + boardId + "]";
	}
	
	

}
