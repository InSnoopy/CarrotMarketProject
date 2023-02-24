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
import comm.service.AtchFileServiceImpl;
import comm.service.IAtchFileService;
import comm.vo.AtchFileVO;

/**
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/BoardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String xxx = request.getParameter("x");
		System.out.println(xxx);
		
		String boardTitle = request.getParameter("boardTitle");
		int price = Integer.parseInt(request.getParameter("price"));
		int boardStatus = Integer.parseInt(request.getParameter("boardStatus"));
		String boardContents = request.getParameter("boardContents");
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		System.out.println(boardTitle + "," + price + "," + boardContents + "," + boardId);
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		AtchFileVO atchFileVO = new AtchFileVO();
		atchFileVO = fileService.saveAtchFileList(request);
		
		
		BoardVO bv = new BoardVO();
		bv.setBoardId(boardId);
		bv.setBoardTitle(boardTitle);
		bv.setPrice(price);
		bv.setBoardStatus(boardStatus);
		bv.setBoardContents(boardContents);
		bv.setFileStreCours(atchFileVO.getFileStreCours());
		
		System.out.println("bv insoo : " + bv);
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		int cnt = boardService.updateBoard(bv);
		if(cnt>0) {
			request.setAttribute("msg", "글 수정 완료");
			response.sendRedirect(request.getContextPath() + "/member/login.do");
		}else {			
			request.setAttribute("msg", "글 수정 실패");
			response.sendRedirect(request.getContextPath() + "/member/login.do");		
		}
		
	}

}
