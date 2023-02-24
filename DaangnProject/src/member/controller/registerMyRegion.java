package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@WebServlet("/registerMyRegion.do")
public class registerMyRegion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IMemberService memberService = MemberServiceImpl.getInstance();
//		HttpSession session = req.getSession();   
//		MemberVO mv = (MemberVO)session.getAttribute("memberVO");
		MemberVO mv = new MemberVO();
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=\"UTF-8\"");
		String memId = "asdf";
		String data = req.getParameter("address");
		//System.out.println(data);
		
		mv.setMemId(memId);
		mv.setMemAddr1(data);
		int count = memberService.registerRegion1(mv); //update 처리 확인필요
		System.out.println("--------------" + count);
		
//		req.getRequestDispatcher("/login/signUpIn.html").forward(req, resp);
//		req.getRequestDispatcher("/WEB-INF/view/mypage/mypage.jsp").forward(req, resp);
//		resp.sendRedirect("login/signUpIn.html");
//		resp.sendRedirect(req.getContextPath() + "/login/signUpIn.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
