package memReport.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memReport.service.IMemReportService;
import memReport.service.MemReportServiceImpl;

@WebServlet("/memReport/delete.do")
public class DeleteMemReportController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memReportId = req.getParameter("memReportId");
		IMemReportService memReportService = MemReportServiceImpl.getInstance();
		memReportService.deleteMemReport(memReportId);
		resp.sendRedirect(req.getContextPath() + "/memReport/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
