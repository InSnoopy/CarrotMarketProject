package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;


@WebServlet("/BoardDetail.do")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardId = request.getParameter("boardId");
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		BoardVO boardVO = boardService.selectBoard(boardId);
		
		String memId = boardVO.getMemId();
		List<BoardVO> boardMemList = boardService.selectMemBoard(memId);
		
		request.setAttribute("boardVO", boardVO);
		request.setAttribute("boardMemList", boardMemList);
		
		System.out.println(boardId);
		System.out.println(boardMemList);
		
		// JSP에게 포워딩 처리
		request.getRequestDispatcher("/WEB-INF/view/board/boardDetail.jsp").forward(request, response);

	}

}
