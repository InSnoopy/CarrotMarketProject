package trade.vo;

import java.util.Date;

public class TradeVO {
	
	private String buyId;
	private String buyerId;
	private int boardId;
	private int price;
	private Date tradeDate;
	private String sellerId;
	
	private String boardTitle;
	
	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public TradeVO() {
		super();
	}

	public String getBuyId() {
		return buyId;
	}

	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "TradeVO [buyId=" + buyId + ", buyerId=" + buyerId + ", boardId=" + boardId + ", price=" + price
				+ ", tradeDate=" + tradeDate + ", sellerId=" + sellerId + ", boardTitle=" + boardTitle + "]";
	}

	

}
