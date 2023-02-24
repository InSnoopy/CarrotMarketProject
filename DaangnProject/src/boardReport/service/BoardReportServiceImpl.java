package boardReport.service;

import java.util.List;

import boardReport.dao.BoardReportDaoImpl;
import boardReport.dao.IBoardReportDao;
import boardReport.vo.BoardReportVO;

public class BoardReportServiceImpl implements IBoardReportService {
	
	private static IBoardReportService boardReportService;
	private IBoardReportDao boardReportDao;
	
	private BoardReportServiceImpl() {
		boardReportDao = BoardReportDaoImpl.getInstance();
	}
	
	public static IBoardReportService getInstance() {
		if(boardReportService == null) {
			boardReportService = new BoardReportServiceImpl();
		}
		return boardReportService;
	}

	@Override
	public List<BoardReportVO> selectAllBoardReport() {
		List<BoardReportVO> boardReportList = boardReportDao.selectAllBoardReport();
		return boardReportList;
	}

	@Override
	public BoardReportVO getBoardReport(String boardReportId) {
		return boardReportDao.getBoardReport(boardReportId);
	}

	@Override
	public List<BoardReportVO> searchBoardReport(BoardReportVO brv) {
		List<BoardReportVO> boardReportList = boardReportDao.searchBoardReport(brv);
		return boardReportList;
	} 
	
	
	

}
