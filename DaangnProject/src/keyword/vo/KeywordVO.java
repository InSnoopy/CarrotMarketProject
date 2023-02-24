package keyword.vo;

public class KeywordVO {
	
	private int keywordId;
	private String keyword;
	private String memId;
	
	public KeywordVO() {
		super();
	}
	public int getKeywordId() {
		return keywordId;
	}
	public void setKeywordId(int keywordId) {
		this.keywordId = keywordId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	@Override
	public String toString() {
		return "KeywordVO [keywordId=" + keywordId + ", keyword=" + keyword + ", memId=" + memId + "]";
	}
	
	

}

