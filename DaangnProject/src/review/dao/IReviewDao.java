package review.dao;

import java.util.List;

import review.vo.ReviewVO;

public interface IReviewDao {
	
	/**
	 * 구매자(평가자)가 남긴 거래 후기 목록을 조회하는 메서드
	 * @param memId 구매자(평가자) 회원ID
	 * @return 구매자(평가자)가 남긴 거래 후기글을 담고 있는 List 타입의 객체
	 */
//	public List<ReviewVO> getBuyerReview(String memId);
	
	
	/**
	 * 판매자가 받은 거래 후기 목록을 조회하는 메서드
	 * @param memId 판매자 회원ID
	 * @return 판매자가 받은 거래 후기글을 담고 있는 List 타입의 객체
	 */
	public List<ReviewVO> getSellerReview(String sellerId);
	
	public int insertReview(ReviewVO rv);
	

	
}
