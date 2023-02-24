package follows.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import follows.service.FollowsServiceImpl;
import follows.service.IFollowsService;
import follows.vo.FollowsVO;
import member.vo.MemberVO;

@WebServlet("/followerList.do")
public class FollowerListController extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//대상의 팔로워 목록
		HttpSession session = request.getSession();
		IFollowsService followsService = FollowsServiceImpl.getInstance();
//		IMemberService memberService = MemberServiceImpl.getInstance();
		MemberVO mv = (MemberVO)session.getAttribute("memberVO");
		
		String yf = request.getParameter("yf");
		String following;
		
		if(yf!=null) {
			following = yf;
		}else {
			following = mv.getMemId(); //session에서 가져오기
		}
		
		System.out.println("following : " + following);
		
//		List<FollowsVO> followList = followsService.followerList(following);
		List<MemberVO> followList = followsService.followingNic(following);
		
		if(followList.size() == 0) {
			System.out.println("팔로워 존재하지 않음");
		}else {
			for(MemberVO mv2 : followList) {
				System.out.println(mv2.getMemNic());
			}
		}
		
		request.setAttribute("followerList", followList); 
		
		request.getRequestDispatcher("/WEB-INF/view/mypage/followerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
