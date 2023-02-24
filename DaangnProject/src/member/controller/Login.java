package member.controller;

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

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import manager.service.IManagerService;
import manager.service.ManagerServiceImpl;
import manager.vo.ManagerVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;


@WebServlet("/Login.do")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	IMemberService memService = MemberServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVO memVo = (MemberVO)session.getAttribute("memberVO");
		MemberVO mv = new MemberVO();
		
		// 입력한 아이디, 비밀번호가 DB에
		// 있다면 mv = 데이터가 있고
		// 없다면 mv = 데이터가 없다.
		if(memVo==null) {
			String memId = request.getParameter("memId");
			String memPw = request.getParameter("memPw");
			mv.setMemId(memId);
			mv.setMemPw(memPw);
			mv = memService.findUser(mv);
		// 세션에 정보가 있다면
		}else {
			mv = memVo;
		}
		
		// 로그인 실패
		if(mv==null) {
			System.out.println("mv=null");
			response.sendRedirect(request.getContextPath() + "/login/signUpIn.html");
		}
		
		// 로그인 성공
		else {
			session.setAttribute("memberVO", mv);
			response.sendRedirect("/DaangnProject/Main.do");
		}

	}
}
