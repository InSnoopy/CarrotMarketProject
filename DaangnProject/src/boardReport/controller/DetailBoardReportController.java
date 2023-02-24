package boardReport.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardReport.service.BoardReportServiceImpl;
import boardReport.service.IBoardReportService;
import boardReport.vo.BoardReportVO;

@WebServlet("/boardReport/detail.do")
public class DetailBoardReportController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String boardReportId = req.getParameter("boardReportId");
		
		IBoardReportService boardReportService = BoardReportServiceImpl.getInstance();
		BoardReportVO brv = boardReportService.getBoardReport(boardReportId);
		
		req.setAttribute("brv", brv);
		
//		System.out.println(brv.toString());
		
		req.getRequestDispatcher("/WEB-INF/view/boardReport/detail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
