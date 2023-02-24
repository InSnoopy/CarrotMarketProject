package memReport.vo;

import java.util.Date;

public class MemReportVO {

	private String memReportId; // 회원 신고글 코드(ID)
	private String memReportContent; // 신고 내용
	private Date memReportDate; // 신고일
	private String memId1; // 신고 회원 ID
	private String memId2; // 피신고 회원 ID
	private int reportResult; // 관리자 처리 여부 
	private String keyword; // 회원 신고글 검색 키워드
	
	public MemReportVO() {
		super();
	}

	public String getMemReportId() {
		return memReportId;
	}

	public void setMemReportId(String memReportId) {
		this.memReportId = memReportId;
	}

	public String getMemReportContent() {
		return memReportContent;
	}

	public void setMemReportContent(String memReportContent) {
		this.memReportContent = memReportContent;
	}

	public Date getMemReportDate() {
		return memReportDate;
	}

	public void setMemReportDate(Date memReportDate) {
		java.sql.Date sqlDate = new java.sql.Date(memReportDate.getTime());
		this.memReportDate = sqlDate;
	}

	public String getMemId1() {
		return memId1;
	}

	public void setMemId1(String memId1) {
		this.memId1 = memId1;
	}

	public String getMemId2() {
		return memId2;
	}

	public void setMemId2(String memId2) {
		this.memId2 = memId2;
	}

	public int getReportResult() {
		return reportResult;
	}

	public void setReportResult(int reportResult) {
		this.reportResult = reportResult;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "MemReportVO [memReportId=" + memReportId + ", memReportContent=" + memReportContent + ", memReportDate="
				+ memReportDate + ", memId1=" + memId1 + ", memId2=" + memId2 + ", reportResult=" + reportResult
				+ ", keyword=" + keyword + "]";
	}

	
	
	
	
}
