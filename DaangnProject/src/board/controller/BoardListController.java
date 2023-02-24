package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/BoardList.do")
public class BoardListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 서비스 객체 생성하기
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		// 게시글 목록 조회
		List<BoardVO> boardList = boardService.selectAllBoard();
		
		req.setAttribute("boardList", boardList);
		
		// 게시글 목록 화면 처리하기
		req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
