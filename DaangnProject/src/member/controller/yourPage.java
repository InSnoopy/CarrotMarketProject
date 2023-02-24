package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@WebServlet("/yourPage.do")
public class yourPage extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String memId = request.getParameter("name");
		MemberVO mv2 =(MemberVO)session.getAttribute("memberVO");
		
		if(memId.equals(mv2.getMemId())) {
			request.getRequestDispatcher("/WEB-INF/view/mypage/mypage.jsp").forward(request, response);
		} else {
		MemberVO mv = new MemberVO();
		IMemberService memberService = MemberServiceImpl.getInstance();
		mv = memberService.memberInfo(memId);
		
		request.setAttribute("boardMemberVo", mv);
		
		System.out.println(mv);
		
		request.getRequestDispatcher("/WEB-INF/view/mypage/yourPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
