package memReport.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memReport.service.IMemReportService;
import memReport.service.MemReportServiceImpl;
import memReport.vo.MemReportVO;

@WebServlet("/memReport/detail.do")
public class DetailMemReportController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memReportId = req.getParameter("memReportId");
		
		IMemReportService memReportService = MemReportServiceImpl.getInstance();
		MemReportVO mrv = memReportService.getMemReport(memReportId);
		
		req.setAttribute("mrv", mrv);
		
		req.getRequestDispatcher("/WEB-INF/view/memReport/detail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
