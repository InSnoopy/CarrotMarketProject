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

@WebServlet("/notice/insert.do")
public class InsertNoticeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		req.getRequestDispatcher("/WEB-INF/view/notice/noticeInsert.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// 파라미터값 가져오기
		String noticeTitle = req.getParameter("noticeTitle");
		String noticeContent = req.getParameter("noticeContent");
		
		// 서비스 객체 생성하기
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		
		NoticeVO nv = new NoticeVO();
		nv.setNoticeTitle(noticeTitle);
		nv.setNoticeContent(noticeContent);
		
		int cnt = noticeService.insertNotice(nv);
		System.out.println(cnt);
		
		resp.sendRedirect(req.getContextPath() + "/notice/list.do");
		
		
		
	}
	
	
}
