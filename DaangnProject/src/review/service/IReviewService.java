package review.service;

import java.util.List;

import review.vo.ReviewVO;

public interface IReviewService {

//	public List<ReviewVO> getBuyerReview(String memId);
	
	public List<ReviewVO> getSellerReview(String sellerId);
	
	public int insertReview(ReviewVO rv);
	
	
}
