package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;


@MultipartConfig
@WebServlet("/member/insert.do")
public class InsertMemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/insertForm.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		req.setCharacterEncoding("UTF-8");

		// 파라미터값 가져오기
		String memId = req.getParameter("memId");
		String memPw = req.getParameter("memName");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String memAddr1 = req.getParameter("memAddr1");
		
		
		
		// 서비스 객체 생성하기
		IMemberService memService = MemberServiceImpl.getInstance();

		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr1(memAddr1);

		int cnt = memService.registMember(mv);

		String msg = "";
		if (cnt > 0) {
			// 성공
			msg = "성공";
		} else {
			// 실패
			msg = "실패";
		}

		req.getSession().setAttribute("msg", msg);

//		req.getRequestDispatcher("/member/list.do")
//			.forward(req, resp);

		// - 클라이언트 입장에서 주소를 적어줘야 함
		resp.sendRedirect(req.getContextPath() + "/member/list.do");

	}
}

