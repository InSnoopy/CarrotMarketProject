package trade.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/buyList.do")
public class BuyListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ItradeService tradeService = TradeServiceImpl.getInstance();
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("memberVO");
		
		String buyerId = mv.getMemId();
		
		System.out.println("buyerId: " + buyerId);
		
		List<TradeVO> tradeList = tradeService.selectAllBuy(buyerId);
		System.out.println(mv.toString());
		System.out.println(tradeList.toString());
		req.setAttribute("tradeList", tradeList);
//		req.setAttribute("memberVO", mv);
		session.setAttribute("memberVO", mv);
		
		req.getRequestDispatcher("/WEB-INF/view/mypage/buylist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
