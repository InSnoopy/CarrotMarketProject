package cutOff.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cutOff.service.CutOffServiceImpl;
import cutOff.service.ICutOffService;
import cutOff.vo.CutOffVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@WebServlet("/cutOff.do")
public class CutOffInsertController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		ICutOffService cos = CutOffServiceImpl.getInstance();
		IMemberService memberService = MemberServiceImpl.getInstance();
		
		MemberVO mv = (MemberVO)session.getAttribute("memberVO");
		String cov = mv.getMemId(); //session에서 가져오기
		String cutoffmem = req.getParameter("cutoff");//yourpage에서 가져오기
		
		System.out.println("cov : " + cov);
		System.out.println("cutoffmem : " + cutoffmem);
		
		CutOffVO com = new CutOffVO();
		com.setMemId1(cov); //차단한사람
		com.setMemId2(cutoffmem); //차단 당한사람
		
		//차단이 이미 되어있으면?
		int cnt = cos.insertCutOffMem(com);
		System.out.println(cnt);
		
		MemberVO cm = memberService.memberInfo(cutoffmem);
		
		req.setAttribute("boardMemberVo", cm);
		
		req.getRequestDispatcher("/WEB-INF/view/mypage/cutOff.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}