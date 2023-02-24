package cutOff.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cutOff.service.CutOffServiceImpl;
import cutOff.service.ICutOffService;
import member.vo.MemberVO;

@WebServlet("/cutOffList.do")
public class CutOffListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//대상의 팔로잉 목록
		HttpSession session = req.getSession();
		ICutOffService cutoffservice = CutOffServiceImpl.getInstance();
		MemberVO mv = (MemberVO)session.getAttribute("memberVO");
		
		String cm = req.getParameter("cm");
		String cov; //차단한사람
		
		if(cm!=null) {
			cov = cm;
		}else {
			cov = mv.getMemId(); //session에서 가져오기
		}
		System.out.println("cov : " + cov);
		
		List<MemberVO> cutoffList = cutoffservice.covNic(cov);
		
		if(cutoffList.size() == 0) {
			System.out.println("차단멤버 존재하지 않음");
		}else {
			for(MemberVO mv2 : cutoffList) {
				System.out.println(mv2.getMemNic());
			}
		}
		
		req.setAttribute("cutoffList", cutoffList);
		
		req.getRequestDispatcher("/WEB-INF/view/mypage/cutOffList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
