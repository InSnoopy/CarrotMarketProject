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

@WebServlet("/notice/update.do")
public class UpdateNoticeController extends HttpServlet {

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
		
		// JSP로 포워딩 처리
		req.getRequestDispatcher("/WEB-INF/view/notice/noticeUpdate.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// 파라미터값 가져오기
		String noticeId = req.getParameter("noticeId");
		String noticeTitle = req.getParameter("noticeTitle");
		String noticeContent = req.getParameter("noticeContent");
		
		// 서비스 객체 생성하기
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		
		NoticeVO nv = new NoticeVO();
		nv.setNoticeId(noticeId);
		nv.setNoticeTitle(noticeTitle);
		nv.setNoticeContent(noticeContent);
		
		int cnt = noticeService.updateNotice(nv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/notice/list.do");
		
		
	}
	
}
