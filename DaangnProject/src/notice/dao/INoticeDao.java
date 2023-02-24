package notice.dao;

import java.util.List;

import notice.vo.NoticeVO;

public interface INoticeDao {
	
	/**
	 * NoticeVO에 담긴 데이터를 DB에 insert하는 메서드
	 * @param nv DB에 insert할 데이터가 저장된 NoticeVO객체
	 * @return DB 작업이 성공하면 1 이상의 값이 반환됨
	 */
	public int insertNotice(NoticeVO nv);
	
	/**
	 * 하나의 NoticeVO 객체를 이용하여 DB정보를 update하는 메서드
	 * @param nv update할 공지사항 정보가 들어있는 NoticeVO객체
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int updateNotice(NoticeVO nv);
	
	/**
	 * 공지사항ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * @param noticeId 삭제할 공지사항ID
	 * @return 작업성공: 1, 작업실패: 9
	 */
	public int deleteNotice(String noticeId);
	
	/**
	 * DB에 존재하는 전체 공지사항을 조회하기 위한 메서드
	 * @return 게시글 정보를 담고 있는 List타입의 객체
	 */
	public List<NoticeVO> selectAllNotice();
	
	/**
	 * 주어진 게시글ID에 해당하는 게시글 정보를 알아내기 위한 메서드
	 * @param noticeId 확인대상 게시글ID
	 * @return 해당 게시글ID에 맞는 게시글 정보
	 */
	public NoticeVO getNotice(String noticeId);
	
	/**
	 * 주어진 키워드를 포함하는 게시글 목록을 알아내는 메서드
	 * @param nv 키워드를 포함하는 NoticeVO객체
	 * @return 키워드를 가지고 있는 List타입의 객체
	 */
	public List<NoticeVO> searchNotice(NoticeVO nv);
	
	/**
	 * 전체 게시글의 수 조회하는 메서드
	 * @return 게시글의 전체 개수
	 */
	public int countNotice();
	
	public List<NoticeVO> pagingListNotice(NoticeVO nv);
	
	
	

}
