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
import member.vo.MemberVO;

@WebServlet("/followingList.do")
public class FollowingListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//대상의 팔로잉 목록
		HttpSession session = request.getSession();
		IFollowsService followsService = FollowsServiceImpl.getInstance();
//		IMemberService memberService = MemberServiceImpl.getInstance();
		MemberVO mv = (MemberVO)session.getAttribute("memberVO");
		
		String yf = request.getParameter("yf");
		String follower;
		
		if(yf!=null) {
			follower = yf;
		}else {
			follower = mv.getMemId(); //session에서 가져오기
		}
		System.out.println("follower : " + follower);
		
//		List<FollowsVO> followingList = followsService.followingList(follower);
		List<MemberVO> followingList = followsService.followingNic(follower);
		
		if(followingList.size() == 0) {
			System.out.println("팔로잉 존재하지 않음");
		}else {
			for(MemberVO mv2 : followingList) {
				System.out.println(mv2.getMemNic());
			}
		}
		
		request.setAttribute("followingList", followingList);
		
		request.getRequestDispatcher("/WEB-INF/view/mypage/followingList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
