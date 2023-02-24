package review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import review.vo.ReviewVO;
import trade.service.ItradeService;
import trade.service.TradeServiceImpl;
import trade.vo.TradeVO;

@WebServlet("/review/insert.do")
public class InsertReviewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 값
		String buyId = req.getParameter("buyId");
		System.out.println("buyId: " + buyId);
		
		// 서비스객체 생성
		ItradeService tradeService = TradeServiceImpl.getInstance();
		TradeVO tv = tradeService.selectBuy(buyId);
		
		req.setAttribute("tv", tv);
		req.getRequestDispatcher("/WEB-INF/view/review/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터값 가져오기
		String buyId = req.getParameter("buyId");
		String buyerId = req.getParameter("buyerId");
		int reviewStar = Integer.parseInt(req.getParameter("reviewStar")); 
		String reviewContents = req.getParameter("reviewContents");
		
		System.out.println("buyId: " + buyId);
		System.out.println("buyerId: " + buyerId);
		System.out.println("reviewStar: " + reviewStar);
		System.out.println("reviewContents: " + reviewContents);
		
		// 서비스 객체
		IReviewService reviewService = ReviewServiceImpl.getInstance();
		
		ReviewVO rv = new ReviewVO();
		rv.setReviewContents(reviewContents);
		rv.setReviewScore(reviewStar);
		rv.setBuyerId(buyerId);
		rv.setBuyId(buyId);
		
		reviewService.insertReview(rv);
		
		
		resp.sendRedirect(req.getContextPath() + "/buyList.do");
	
	}

	

}
