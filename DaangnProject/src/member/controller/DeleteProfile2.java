package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;

@WebServlet("/deleteProfile2.do")
public class DeleteProfile2 extends HttpServlet{

private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		
		IMemberService memService = MemberServiceImpl.getInstance();
		
		int cnt = memService.removeMember(memId);
		
		String msg = "";
		if(cnt>0) {
			msg="성공";
			//성공
		}else {
			msg="실패";
			//실패
		}
		req.getSession().setAttribute("msg", msg);
//		req.getRequestDispatcher("/WEB-INF/view/mypage/deleteProfile.jsp").forward(req, resp);
		resp.sendRedirect("/DaangnProject/login/signUpIn.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
