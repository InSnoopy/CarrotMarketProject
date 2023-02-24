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

@WebServlet("/modifyProfile_detail.do")
public class ModifyProfile_detail extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IMemberService memberService = MemberServiceImpl.getInstance();
		HttpSession session = request.getSession();   
		MemberVO mv = (MemberVO)session.getAttribute("memberVO");
		
		
		String memNic = request.getParameter("memNic");
		String memName = request.getParameter("memName");
		String memTel = request.getParameter("memTel");
		String memMail = request.getParameter("memMail");
		String profile = request.getParameter("profile");
		
		System.out.println("들어온 값 => memNic : "+memNic+" memName : "+memName+" memTel : "+memTel+" memMail : "+memMail+ " profile :"+profile);

		mv.setMemNic(memNic);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemMail(memMail);
		mv.setProfile(profile);
		System.out.println("세션 등록 전 변경된 mv 값 => " + mv.toString());
		
		
		//가져온 값으로 할 일 1.세션값 변경하기 2.db에 변경 값 올리기(파라미터타입: MemberVO)
		
		try {
			memberService.modifyMember(mv); //db 수정하고
		} catch(Exception ex) {
			System.out.println("회원정보 수정실패");
			ex.printStackTrace();
		}
		
		session.setAttribute("memberVO", mv); //세션등록
		
		System.out.println("세션 등록 후 변경된 세션 값 => " + mv.toString());
		
		
		request.getRequestDispatcher("/WEB-INF/view/mypage/mypage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}