package memReport.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memReport.service.IMemReportService;
import memReport.service.MemReportServiceImpl;
import memReport.vo.MemReportVO;

@WebServlet("/memReport/list.do")
public class ListMemReportController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 서비스 객체 생성
		IMemReportService memReportService = MemReportServiceImpl.getInstance();
		
		// 신고 회원 목록 조회
		List<MemReportVO> memReportList = memReportService.selectAllMemReport();
		req.setAttribute("memReportList", memReportList);
		
		// 신고 회원 목록 화면 처리하기
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/memReport/memReportList.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
