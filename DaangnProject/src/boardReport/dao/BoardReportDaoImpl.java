package boardReport.dao;

import java.util.List;

import boardReport.vo.BoardReportVO;
import comm.dao.MyBatisDAO;

public class BoardReportDaoImpl extends MyBatisDAO implements IBoardReportDao {
	
	private static IBoardReportDao boardReportDao;
	
	private BoardReportDaoImpl() {
	}
	
	public static IBoardReportDao getInstance() {
		if(boardReportDao == null) {
			boardReportDao = new BoardReportDaoImpl(); 
		}
		return boardReportDao;
	}

	@Override
	public List<BoardReportVO> selectAllBoardReport() {
		return selectList("boardReport.selectAllBoardReport", null);
	}

	@Override
	public BoardReportVO getBoardReport(String boardReportId) {
		return selectOne("boardReport.getBoardReport", boardReportId);
	}

	@Override
	public List<BoardReportVO> searchBoardReport(BoardReportVO brv) {
		return selectList("boardReport.searchBoardReport", brv);
	}
	
	

}
