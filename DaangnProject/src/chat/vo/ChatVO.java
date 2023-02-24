package chat.vo;

import java.util.Date;

public class ChatVO {
	
	private int chatId;
	private String memId;
	private int boardId;
	private String chatPrice;
	private int chatAccept;
	private String chatContents;
	private Date chatSendDate;
	private int chatCheck;
	private String memNic;
	private String profile;
	private String loginUser;

	public ChatVO() {
		super();
	}


	public ChatVO(String memId, int boardId, String chatContents) {
		this.memId = memId;
		this.boardId = boardId;
		this.chatContents = chatContents;
	}


	public ChatVO(int chatId, String memId, int boardId, String chatPrice, int chatAccept, String chatContent,
			Date chatSendDate, int chatCheck) {
		this.chatId = chatId;
		this.memId = memId;
		this.boardId = boardId;
		this.chatPrice = chatPrice;
		this.chatAccept = chatAccept;
		this.chatContents = chatContents;
		this.chatSendDate = chatSendDate;
		this.chatCheck = chatCheck;
	}


	public int getChatId() {
		return chatId;
	}


	public void setChatId(int chatId) {
		this.chatId = chatId;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public int getBoardId() {
		return boardId;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}


	public String getChatPrice() {
		return chatPrice;
	}


	public void setChatPrice(String chatPrice) {
		this.chatPrice = chatPrice;
	}


	public int getChatAccept() {
		return chatAccept;
	}


	public void setChatAccept(int chatAccept) {
		this.chatAccept = chatAccept;
	}


	public String getChatContents() {
		return chatContents;
	}


	public void setChatContent(String chatContents) {
		this.chatContents = chatContents;
	}


	public Date getChatSendDate() {
		return chatSendDate;
	}


	public void setChatSendDate(Date chatSendDate) {
		this.chatSendDate = chatSendDate;
	}


	public int getChatCheck() {
		return chatCheck;
	}


	public void setChatCheck(int chatCheck) {
		this.chatCheck = chatCheck;
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


	public String getLoginUser() {
		return loginUser;
	}


	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}


	public void setChatContents(String chatContents) {
		this.chatContents = chatContents;
	}


	@Override
	public String toString() {
		return "ChatVO [chatId=" + chatId + ", memId=" + memId + ", boardId=" + boardId + ", chatPrice=" + chatPrice
				+ ", chatAccept=" + chatAccept + ", chatContents=" + chatContents + ", chatSendDate=" + chatSendDate
				+ ", chatCheck=" + chatCheck + ", memNic=" + memNic + ", profile=" + profile + ", loginUser="
				+ loginUser + "]";
	}

	

	
}
