package follows.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import follows.service.FollowsServiceImpl;
import follows.service.IFollowsService;
import follows.vo.FollowsVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@WebServlet("/follows.do")
public class FollowsController extends HttpServlet {
	
private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		IFollowsService followsService = FollowsServiceImpl.getInstance();
		IMemberService memberService = MemberServiceImpl.getInstance();
		
		MemberVO mv = (MemberVO)session.getAttribute("memberVO");
		String follower = mv.getMemId(); //session에서 가져오기
		String following = request.getParameter("following"); //yourpage에서 가져오기
		
		System.out.println("follower : " + follower);
		System.out.println("following : " + following);
		
		FollowsVO fv = new FollowsVO();
		fv.setFollower(follower); //asdf
		fv.setFollowing(following); //p001
		//팔로우가 이미 되어있으면????
		int cnt = followsService.insertFollows(fv);
		System.out.println(cnt);
		
		MemberVO ru = memberService.memberInfo(following);
		
		request.setAttribute("boardMemberVo", ru);
		
		request.getRequestDispatcher("/WEB-INF/view/mypage/yourPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
