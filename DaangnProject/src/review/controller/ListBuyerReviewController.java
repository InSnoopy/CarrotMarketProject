package review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import review.vo.ReviewVO;

@WebServlet("/review/buyerlist.do")
public class ListBuyerReviewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sellerId = req.getParameter("memId");
		
		IReviewService reviewService = ReviewServiceImpl.getInstance();
		
		ReviewVO rv = new ReviewVO();
		rv.setSellerId(sellerId);
		
//		List<ReviewVO> reviewList = reviewService.getBuyerReview(memId);
		req.getRequestDispatcher("/WEB-INF/view/review/buyerlist.jsp").forward(req, resp);;
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
