package notice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.vo.ManagerVO;
import member.vo.MemberVO;
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import notice.vo.NoticeVO;

@WebServlet("/notice/list2.do")
public class ListNoticeController2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// 서비스 객체 생성
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		
//		// 공지사항 목록 조회
		NoticeVO nv = new NoticeVO();
//		List<NoticeVO> noticeList = noticeService.selectAllNotice();
//		req.setAttribute("noticeList", noticeList);
		
//		System.out.println(noticeList.toString());
		
		
		
		//------ pagination 시작 --------
		// 현재 페이지 값 (default 1 page)
		int currentPage = 1;
		currentPage = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
		
		// 전체 글 개수 가져오기
		int count = noticeService.countNotice();
		// 한 화면에 출력할 페이지 수
		int perPage = 3;
		// 한 페이지에 출력할 글 개수
		int perList = 10;
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
		
		nv.setStart(start);
		nv.setEnd(end);
		List<NoticeVO> noticeList = noticeService.pagingListNotice(nv);
		req.setAttribute("noticeList", noticeList);
		
		System.out.println(noticeList.toString());
		
		req.setAttribute("sPage", startPage);
		req.setAttribute("ePage", endPage);
		req.setAttribute("ttPage", totalPage);
		req.setAttribute("cPage", currentPage);
		req.setAttribute("start", start);
		req.setAttribute("end", end);
		
		
		// ----- pagination 끝 -------
		System.out.println("currentPage: " + currentPage);
		System.out.println("count: " + count);
		System.out.println("startPage: " + startPage);
		System.out.println("endPage: " + endPage);
		System.out.println("totalPage:" + totalPage);
		System.out.println("start:" + start);
		System.out.println("end:" + end);
		
		
		// 세션 가져오기
		
		
		
		// 공지사항 목록 화면 처리하기
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/notice/noticeList2.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
