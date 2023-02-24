package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import notice.vo.NoticeVO;

@WebServlet("/notice/search2.do")
public class SearchNoticeController2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 값 조회
		String keyword = req.getParameter("keyword");

		// 서비스 객체 생성
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		NoticeVO nv = new NoticeVO();
		nv.setKeyword(keyword);
//		System.out.println(keyword);
		
		// 목록 조회
		List<NoticeVO> searchList = noticeService.searchNotice(nv);
		
//		System.out.println(searchList.toString());
		req.setAttribute("searchList", searchList);
		
		// 화면 처리
		req.getRequestDispatcher("/WEB-INF/view/notice/noticeSearchList2.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
