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

@WebServlet("/findId.do") 
public class FindId extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IMemberService memberService = MemberServiceImpl.getInstance();
		
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		System.out.println("getParameter : " + memName + "/" + memTel);

		MemberVO mv = new MemberVO();
		mv.setMemName(memName);
		mv.setMemTel(memTel);

		mv = memberService.findId(mv);
		if(mv==null){
			System.out.println("mv=null");
		}
		
//		MemberVO mv = (MemberVO) req.getAttribute("memberVO");
//		
//		String memMail = req.getParameter("memMail");
//		String memId = memberService.findId(memMail);
//		req.setAttribute("memId", memId);
//		
//		System.out.println("들어온 값 => memName : "+memName+"이메일의 ID값 => memTel : "+memTel);
		req.setAttribute("mv", mv);
		
		req.getRequestDispatcher("/login/findIdResult.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
