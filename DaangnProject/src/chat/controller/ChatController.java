package chat.controller;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chat.service.ChatRoomServiceImpl;
import chat.service.IChatRoomService;
import chat.vo.ChatVO;
import member.vo.MemberVO;


@WebServlet("/Chat.do")
public class ChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IChatRoomService iChatRoomService = ChatRoomServiceImpl.getInstance();
	

    public ChatController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardId = request.getParameter("boardId");
		String memIdBuy = request.getParameter("memIdBuy");
		String memIdSell = request.getParameter("memIdSell");
		
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
		System.out.println("로그인한 사람? " + memberVO);
		String loginUser = memberVO.getMemId();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("boardId", boardId);
		map.put("loginUser", loginUser);
		
		//대화목록 방 정보
		List<ChatVO> chatRoomList = this.iChatRoomService.chatRoom();
		System.out.println("chatRoomList : " + chatRoomList);
		
		//대화목록 상세
		List<ChatVO> chatVOList = this.iChatRoomService.chatList(map);
		System.out.println("chatVOList : " + chatVOList);
		
		request.setAttribute("chatRoomList", chatRoomList);
		
		request.setAttribute("chatVOList", chatVOList);
		
		request.getRequestDispatcher("/WEB-INF/view/chat/chat.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
