package boardReport.vo;

import java.util.Date;

public class BoardReportVO {
	
	private String boardReportId; // 게시글 신고 ID
	private int boardId; // 게시글 ID
	private String boardReportContent; // 게시글 신고 내용
	private Date boardReportDate; // 게시글 신고일
	private int boardReportManagerCheck; // 관리자 처리 여부
	private String memId; // 회원 ID
	private String keyword; // 게시글 신고 검색 키워드
	
	private String boardTitle; // 신고당한 게시글 제목
	
	public BoardReportVO() {
		super();
	}

	public String getBoardReportId() {
		return boardReportId;
	}

	public void setBoardReportId(String boardReportId) {
		this.boardReportId = boardReportId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardReportContent() {
		return boardReportContent;
	}

	public void setBoardReportContent(String boardReportContent) {
		this.boardReportContent = boardReportContent;
	}

	public Date getBoardReportDate() {
		return boardReportDate;
	}

	public void setBoardReportDate(Date boardReportDate) {
		java.sql.Date sqlDate = new java.sql.Date(boardReportDate.getTime());
		this.boardReportDate = sqlDate;
	}

	public int getBoardReportManagerCheck() {
		return boardReportManagerCheck;
	}

	public void setBoardReportManagerCheck(int boardReportManagerCheck) {
		this.boardReportManagerCheck = boardReportManagerCheck;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	@Override
	public String toString() {
		return "BoardReportVO [boardReportId=" + boardReportId + ", boardId=" + boardId + ", boardReportContent="
				+ boardReportContent + ", boardReportDate=" + boardReportDate + ", boardReportManagerCheck="
				+ boardReportManagerCheck + ", memId=" + memId + ", keyword=" + keyword + ", boardTitle=" + boardTitle
				+ "]";
	}

	
	
	
	
	

}
