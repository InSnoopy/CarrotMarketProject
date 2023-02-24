package review.service;

import java.util.List;

import review.dao.IReviewDao;
import review.dao.ReviewDaoImpl;
import review.vo.ReviewVO;

public class ReviewServiceImpl implements IReviewService {

	private static IReviewService reviewService;
	private IReviewDao reviewDao;
	
	private ReviewServiceImpl() {
		reviewDao = ReviewDaoImpl.getInstance();
	}
	
	public static IReviewService getInstance() {
		if(reviewService == null) {
			reviewService = new ReviewServiceImpl();
		}
		return reviewService;
	}

//	@Override
//	public List<ReviewVO> getBuyerReview(String memId) {
//		return reviewDao.getBuyerReview(memId);
//	}
	
	@Override
	public List<ReviewVO> getSellerReview(String sellerId) {
		return reviewDao.getSellerReview(sellerId);
	}
	
	@Override
	public int insertReview(ReviewVO rv) {
		return reviewDao.insertReview(rv);
	}

	
	

	
}
