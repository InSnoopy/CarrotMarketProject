package review.dao;

import java.util.List;

import comm.dao.MyBatisDAO;
import review.vo.ReviewVO;

public class ReviewDaoImpl extends MyBatisDAO implements IReviewDao {
	
	private static IReviewDao reviewDao;
	
	private ReviewDaoImpl() {
	}
	
	public static IReviewDao getInstance() {
		if(reviewDao == null) {
			reviewDao = new ReviewDaoImpl();
		}
		return reviewDao;
	}

//	@Override
//	public List<ReviewVO> getBuyerReview(String memId) {
//		return selectList("review.getBuyerReview", memId);
//	}

	@Override
	public List<ReviewVO> getSellerReview(String sellerId) {
		return selectList("review.getSellerReview", sellerId);
	}
	
	@Override
	public int insertReview(ReviewVO rv) {
		return insert("review.insertReview", rv);
	}

	
	
	
	

}
