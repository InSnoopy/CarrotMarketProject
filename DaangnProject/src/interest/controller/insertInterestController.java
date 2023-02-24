package interest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interest.service.InterestServiceImpl;
import interest.service.iInterestService;
import interest.vo.InterestVO;
import member.vo.MemberVO;

@WebServlet("/insertInterest.do")
public class insertInterestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("관심상품추가");
		
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO)session.getAttribute("memberVO");
		InterestVO iv = new InterestVO();
		iInterestService service = InterestServiceImpl.getInstance();
		
		int boardId = Integer.parseInt(req.getParameter("boardId"));
		String memId = mv.getMemId();
		iv.setBoardId(boardId);
		iv.setMemId(memId);
		
		int cnt = service.insertInterest(iv);
		System.out.println(cnt);
		
		
//		req.getRequestDispatcher("/WEB-INF/view/board/boardDetail.jsp").forward(req, resp);
		resp.sendRedirect(req.getContextPath() + "/BoardDetail.do?boardId=" + req.getParameter("boardId"));
//		req.getRequestDispatcher("/WEB-INF/view/mypage/mypage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
