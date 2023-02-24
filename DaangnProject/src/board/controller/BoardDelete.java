package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import chat.service.ChatRoomServiceImpl;
import chat.service.IChatRoomService;


@WebServlet("/BoardDelete")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardId = request.getParameter("boardId");
		IBoardService boardService = BoardServiceImpl.getInstance();
		IChatRoomService chatRoomService = ChatRoomServiceImpl.getInstance();
		
		int cnt = chatRoomService.deleteChat(boardId);
		
		
		if(cnt==0) {
			boardService.deleteBoard(boardId);
			response.sendRedirect(request.getContextPath() + "/Main.do");
		}else {
			boardService.deleteBoard(boardId);
			response.sendRedirect(request.getContextPath() + "/Main.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
