package review.vo;

import java.util.Date;

public class ReviewVO {

	private String reviewId; // 거래 후기 ID(코드)
	private String reviewContents; // 거래 후기 내용
	private int reviewScore; // 별점
	private Date reviewDate; // 거래 후기 작성 날짜
	private String buyerId; // 평가자 ID
	private String buyId; // 거래 ID
	
	private String sellerId; // 평가받은 회원ID
	
	public ReviewVO() {
		super();
	}

	

	public String getReviewId() {
		return reviewId;
	}



	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}



	public String getReviewContents() {
		return reviewContents;
	}



	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}



	public int getReviewScore() {
		return reviewScore;
	}



	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}



	public Date getReviewDate() {
		return reviewDate;
	}



	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}



	public String getBuyerId() {
		return buyerId;
	}



	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}



	public String getBuyId() {
		return buyId;
	}



	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}



	public String getSellerId() {
		return sellerId;
	}



	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}



	@Override
	public String toString() {
		return "ReviewVO [reviewId=" + reviewId + ", reviewContents=" + reviewContents + ", reviewScore=" + reviewScore
				+ ", reviewDate=" + reviewDate + ", buyerId=" + buyerId + ", buyId=" + buyId + ", sellerId=" + sellerId
				+ "]";
	}



	

	
	
	
	
}