package member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import member.vo.MemberVO;



@WebServlet("/Main.do")
public class Main extends HttpServlet {      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		HttpSession session = request.getSession();
		MemberVO bv = (MemberVO) session.getAttribute("memberVO");
		
		//------ pagination 시작 --------
		// 현재 페이지 값 (default 1 page)
		int currentPage = 1;
		currentPage = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));
		
		// 전체 글 개수 가져오기
		int count = boardService.boardCount();
		// 한 화면에 출력할 페이지 수
		int perPage = 5;
		// 한 페이지에 출력할 글 개수
		int perList = 16;
		// 전체 페이지 수 구하기
		int totalPage = (int) Math.ceil((double)count / perList);
		// 페이지에 표시될 게시글의 start값
		int start = (currentPage - 1) * perList + 1;
		// 페이지에 표시될 게시글의 end값
		int end = start + perList - 1;
		// 전체 글 개수보다 게시글의 끝 값이 더 클 경우
		if (end > count) {
			end = count;
		}
		// 화면에 보여질 페이지 번호 구하기
		int startPage = ((currentPage - 1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		// totalPage보다 endPage의 값이 더 클 경우
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		List<BoardVO> bl = boardService.boardPaging(map);

		request.setAttribute("bl", bl);
		request.setAttribute("sPage", startPage);
		request.setAttribute("ePage", endPage);
		request.setAttribute("ttPage", totalPage);
		request.setAttribute("cPage", currentPage);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		
		// 관리자 로그인
		if(bv.getMemId().equals("admin")) {
			request.getRequestDispatcher("/WEB-INF/view/manager/index2.jsp").forward(request, response);
		// 일반 회원 로그인
		}else {
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		}


	}

}
