package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/boardDoneDeal.do")
public class BoardDoneDeal extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//거래상태 값 1로 변경시켜야함
		
		int boardId = Integer.parseInt(req.getParameter("boardId"));
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		BoardVO bv = new BoardVO();
		bv.setBoardId(boardId);
		
		boardService.updateBoardStatus(bv);
		
		
		req.getRequestDispatcher("/WEB-INF/view/mypage/myDeal.jsp").forward(req, resp);
	}
}
