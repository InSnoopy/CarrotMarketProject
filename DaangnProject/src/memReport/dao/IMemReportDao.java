package memReport.dao;

import java.util.List;

import memReport.vo.MemReportVO;
import notice.vo.NoticeVO;

public interface IMemReportDao {
	
	/**
	 * DB에 존재하는 전체 신고 회원을 조회하는 메서드
	 * @return 신고 회원 정보를 담고 있는 List타입 객체
	 */
	public List<MemReportVO> selectAllMemReport();
	
	/**
	 * 주어진 회원신고ID에 해당하는 신고 상세 내용을 알아내는 메서드
	 * @param memReportId 확인대상 회원신고ID
	 * @return 해당 회원신고ID에 맞는 신고글 정보
	 */
	public MemReportVO getMemReport(String memReportId);
	
	/**
	 * 회원신고ID를 매개벼수로 해당 회원신고를 삭제하는 메서드
	 * @param memReportId 삭제할 회원신고ID
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int deleteMemReport(String memReportId);
	
	/**
	 * 주어진 키워드를 포함하는 신고 회원 목록을 알아내는 메서드
	 * @param mrv 키워드를 포함하는 MemReportVO객체
	 * @return 키워드를 가지고 있는 List타입의 객체
	 */
	public List<MemReportVO> searchMemReport(MemReportVO mrv);
	

}
