package board.controller;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import comm.service.AtchFileServiceImpl;
import comm.service.IAtchFileService;
import comm.vo.AtchFileVO;
import member.vo.MemberVO;

/**
 * Servlet implementation class BoardUpdatePage
 */
@MultipartConfig
@WebServlet("/BoardUpdatePage.do")
public class BoardUpdatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bI = request.getParameter("boardId");
		request.setAttribute("boardId", bI);
		request.getRequestDispatcher("/WEB-INF/view/board/boardUpdate.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		String result = request.getParameter("result");
		
		HttpSession session = request.getSession();
		MemberVO mv = (MemberVO)session.getAttribute("memberVO");
		String boardTitle = request.getParameter("boardTitle");
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String boardContents = request.getParameter("boardContents");
		int price = Integer.parseInt(request.getParameter("price"));
		int boardStatus = Integer.parseInt(request.getParameter("boardStatus"));
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		BoardVO boardVO = boardService.selectBoard(request.getParameter("boardId"));
		
		System.out.println("상태" + request.getParts());
		System.out.println("hansoo" + boardVO);
		System.out.println(boardTitle + "," + price + "," + boardContents + "," + boardId);
		
		BoardVO bv = new BoardVO();		
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		AtchFileVO atchFileVO = new AtchFileVO();
		atchFileVO = fileService.saveAtchFileList(request);
	
		bv.setBoardTitle(boardTitle);
		bv.setBoardId(boardId);
		bv.setBoardContents(boardContents);
		bv.setPrice(price);
		bv.setBoardStatus(boardStatus);
		
		if(result.equals("no")) {
			bv.setFileStreCours(boardVO.getFileStreCours());
		}else if(result.equals("yes")) {
			bv.setFileStreCours(atchFileVO.getFileStreCours());
		}
		
		bv.setMemId(mv.getMemId());
		
		int cnt = boardService.updateBoard(bv);
		request.setAttribute("thisBoard", bv);

		if(boardStatus==1) {
			request.getRequestDispatcher("/WEB-INF/view/board/chooseBuyer.jsp").forward(request, response);			
		} else {
			if(cnt>0) {
				request.setAttribute("msg", "글 수정 완료");
				response.sendRedirect(request.getContextPath() + "/Main.do");
			}else {			
				request.setAttribute("msg", "글 수정 실패");
				response.sendRedirect(request.getContextPath() + "/Main.do");	
			}
		}
		
	}
	
}
