package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.MemberVO;
import trade.service.ItradeService;
import trade.service.TradeServiceImpl;
import trade.vo.TradeVO;

@WebServlet("/chooseBuyer.do")
public class chooseBuyer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chooseBuyer 서블릿에 왓다");
		
		String buyerId = request.getParameter("buyer");
		System.out.println("선택된 구매자 : " + buyerId);
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		System.out.println("insert할 boardId : "+ boardId);
		
		int price = Integer.parseInt(request.getParameter("price"));
		System.out.println("insert할 price : "+ price);
		
		//buy테이블에 인서트하기(buyer로 아이디 값 들여오기)
		
		ItradeService tradeService = TradeServiceImpl.getInstance();
		HttpSession session = request.getSession();
		MemberVO mv = (MemberVO)session.getAttribute("memberVO");
		TradeVO tv = new TradeVO();
		
		
//		String buyerId = "asdf";
//		int boardId = 31;
//		int price = 400;
		
		tv.setBuyerId(buyerId);
		tv.setBoardId(boardId);
		tv.setPrice(price);
		tv.setSellerId(mv.getMemId());
		System.out.println("insert할 tv : " + tv);
		System.out.println("insert직전");
		int cnt = tradeService.insertBuy(tv);
		
		System.out.println("완료여부 : " + cnt);
		System.out.println("인서트 쿼리 실행 이후 : " + tv);
		
		request.getRequestDispatcher("/WEB-INF/view/mypage/mypage.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
