package boardReport.service;

import java.util.List;

import boardReport.vo.BoardReportVO;

public interface IBoardReportService {
	
	public List<BoardReportVO> selectAllBoardReport();
	
	public BoardReportVO getBoardReport(String boardReportId);
	
	public List<BoardReportVO> searchBoardReport(BoardReportVO brv);

}
