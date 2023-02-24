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

@WebServlet("/BoardSearchListController.do")
public class BoardSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		BoardVO bv = new BoardVO();
		bv.setKeyword(keyword);
		
		List<BoardVO> searchBoard = boardService.searchBoard(bv);
		
		System.out.println(searchBoard.size());
		
		request.setAttribute("searchBoard", searchBoard);
		request.setAttribute("searchKeyword", bv.getKeyword());
		
		request.getRequestDispatcher("/WEB-INF/view/indexSearch.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
