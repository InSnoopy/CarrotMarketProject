package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import notice.vo.NoticeVO;
	
@WebServlet("/notice/detail.do")
public class DetailNoticeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// 파라미터 값 조회
		String noticeId = req.getParameter("noticeId");
		
		// 서비스 객체 생성
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		NoticeVO nv = noticeService.getNotice(noticeId);
		
		req.setAttribute("nv", nv);
		
		// JSP에게 포워딩 처리
		req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, resp);;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
