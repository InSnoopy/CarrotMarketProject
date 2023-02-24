package interest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.vo.BoardVO;
import interest.service.InterestServiceImpl;
import interest.service.iInterestService;
import member.vo.MemberVO;

@WebServlet("/interestList.do")
public class InterestListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//interestList.jsp
		
		HttpSession session = req.getSession();
		iInterestService service = InterestServiceImpl.getInstance();
		MemberVO mv = (MemberVO)session.getAttribute("memberVO");
		
		
		List<BoardVO> boardList = service.interestList(mv.getMemId());
		
		if(boardList.size() == 0) {
			System.out.println("회원정보가 존재하지 않습니다.");
		}else {
			
			for(BoardVO mv2 : boardList) {
				System.out.println(mv2.getBoardId());
			}
		}
		
		req.setAttribute("interestList", boardList);
		
		req.getRequestDispatcher("/WEB-INF/view/mypage/interestList.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
