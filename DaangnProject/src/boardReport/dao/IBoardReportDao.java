package boardReport.dao;

import java.util.List;

import boardReport.vo.BoardReportVO;

public interface IBoardReportDao {
	
	/**
	 * DB에 존재하는 전체 신고 게시글을 조회하는 메서드
	 * @return 신고 게시글 정보를 담고 있는 List타입 객체
	 */
	public List<BoardReportVO> selectAllBoardReport();
	
	/**
	 * 주어진 게시글신고ID에 해당하는 신고 상세 내용을 알아내는 메서드
	 * @param boardReportId 확인대상 게시글신고ID 
	 * @return 해당 게시글신고ID에 맞는 신고글 정보
	 */
	public BoardReportVO getBoardReport(String boardReportId);
	
	/**
	 * 주어진 키워드를 포함하는 신고 게시글 목록을 알아내는 메서드
	 * @param brv 키워드를 포함하는 BoardReportVO객체
	 * @return 키워드를 가지고 있는 List타입의 객체
	 */
	public List<BoardReportVO> searchBoardReport(BoardReportVO brv);
	
	

}
