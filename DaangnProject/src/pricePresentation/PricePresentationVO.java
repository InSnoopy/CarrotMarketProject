package pricePresentation;

import java.util.Date;

public class PricePresentationVO {
	
	private int pricePresentationId;
	private String memId;
	private int boardId;
	private int prePrice;
	private String acceptStatus;
	private Date creationDate;
	
	public PricePresentationVO() {
		super();
	}
	public int getPricePresentationId() {
		return pricePresentationId;
	}
	public void setPricePresentationId(int pricePresentationId) {
		this.pricePresentationId = pricePresentationId;
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
	public int getPrePrice() {
		return prePrice;
	}
	public void setPrePrice(int prePrice) {
		this.prePrice = prePrice;
	}
	public String getAcceptStatus() {
		return acceptStatus;
	}
	public void setAcceptStatus(String acceptStatus) {
		this.acceptStatus = acceptStatus;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "PricePresentationVO [pricePresentationId=" + pricePresentationId + ", memId=" + memId + ", boardId="
				+ boardId + ", prePrice=" + prePrice + ", acceptStatus=" + acceptStatus + ", creationDate="
				+ creationDate + "]";
	}
	
	

}
