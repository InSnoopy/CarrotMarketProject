package notice.vo;

//import java.sql.Date;

import java.util.Date;

public class NoticeVO {
	
	private String noticeId; // 공지사항 ID
	private String noticeTitle; // 공지사항 제목
	private String noticeContent; // 공지사항 내용
	private Date noticeDate; // 공지사항 등록일
	private String managerId; // 관리자ID
	
	private String keyword; // 공지사항 검색 키워드
	private int start; // 페이지에 표시될 게시글의 start
	private int end; // 페이지에 표시될 게시글의 end
	
	private int rnum; // rownum
	
	public NoticeVO() {
	}

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		java.sql.Date sqlDate = new java.sql.Date(noticeDate.getTime());
		this.noticeDate = sqlDate;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
		
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	@Override
	public String toString() {
		return "NoticeVO [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeDate=" + noticeDate + ", managerId=" + managerId + ", keyword=" + keyword + ", start="
				+ start + ", end=" + end + ", rnum=" + rnum + "]";
	}

	
	
	

	
	
}
