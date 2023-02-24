package boardReport.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardReport.service.BoardReportServiceImpl;
import boardReport.service.IBoardReportService;
import boardReport.vo.BoardReportVO;

@WebServlet("/boardReport/search.do")
public class SearchBoardReportController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String keyword = req.getParameter("keyword");
		
		IBoardReportService boardReportService = BoardReportServiceImpl.getInstance();
		BoardReportVO brv = new BoardReportVO();
		brv.setKeyword(keyword);
		
		List<BoardReportVO> searchList = boardReportService.searchBoardReport(brv);
		
		req.setAttribute("searchList", searchList);
		
		req.getRequestDispatcher("/WEB-INF/view/boardReport/searchList.jsp").forward(req, resp);
		
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
	

}
