package review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.MemberVO;
import review.service.IReviewService;
import review.service.ReviewServiceImpl;
import review.vo.ReviewVO;

@WebServlet("/reviewList.do")
public class ListReviewController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		IReviewService reviewService = ReviewServiceImpl.getInstance();
		MemberVO mv = (MemberVO) session.getAttribute("memberVO");
		
		String memId = req.getParameter("memId");
		System.out.println("memId: " + memId);

		List<ReviewVO> reviewList = reviewService.getSellerReview(memId);
		
		System.out.println(reviewList.toString());
		
//		req.setAttribute("memberVO", mv);
		req.setAttribute("memId", memId);
		req.setAttribute("reviewList", reviewList);
		req.getRequestDispatcher("/WEB-INF/view/mypage/myReview.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
