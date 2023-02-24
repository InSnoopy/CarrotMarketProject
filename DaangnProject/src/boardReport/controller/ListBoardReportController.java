package boardReport.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardReport.service.BoardReportServiceImpl;
import boardReport.service.IBoardReportService;
import boardReport.vo.BoardReportVO;

@WebServlet("/boardReport/list.do")
public class ListBoardReportController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IBoardReportService boardReportService = BoardReportServiceImpl.getInstance();
		
		List<BoardReportVO> boardReportList = boardReportService.selectAllBoardReport();
		req.setAttribute("boardReportList", boardReportList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/boardReport/list.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	

}
