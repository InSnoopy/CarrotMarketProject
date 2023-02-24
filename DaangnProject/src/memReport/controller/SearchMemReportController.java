package memReport.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memReport.service.IMemReportService;
import memReport.service.MemReportServiceImpl;
import memReport.vo.MemReportVO;

@WebServlet("/memReport/search.do")
public class SearchMemReportController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String keyword = req.getParameter("keyword");
		
		IMemReportService memReportService = MemReportServiceImpl.getInstance();
		MemReportVO mrv = new MemReportVO();
		mrv.setKeyword(keyword);
		
		List<MemReportVO> searchList = memReportService.searchMemReport(mrv);
		
		req.setAttribute("searchList", searchList);
		
		req.getRequestDispatcher("/WEB-INF/view/memReport/memReportSearchList.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
	
	
	
	
	

}
