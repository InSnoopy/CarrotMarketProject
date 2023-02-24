package board.dao;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;

public interface IBoardDao {
	
	/**
	 * BoardVO에 담겨진 데이터를 DB에 insert하는 메서드
	 * @param bv DB에 insert할 데이터가 저장된 BoardVO객체
	 * @return DB작업 성공하면 1이상의 값이 반환됨
	 */
	public int insertBoard(BoardVO bv);
	
	/**
	 * BoardVO객체를 이용하여 DB정보를 update하는 메서드
	 * @param bv update할 게시글 정보가 들어있는 BoardVO객체
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int updateBoard(BoardVO bv);
	
	/**
	 * 게시글ID를 입력받아 게시글 정보를 삭제하는 메서드
	 * @param boardId 삭제할 게시글ID
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int deleteBoard(String boardId);
	
	/**
	 * DB에 존재하는 전체 게시글 목록을 조회하는 메서드
	 * @return 게시글 정보를 담고있는 List타입 객체
	 */
	public List<BoardVO> selectAllBoard();
	
	/**
	 * DB에 존재하는 게시글 하나를 조회하는 메서드
	 * @return 게시글 정보를 담고 있는 BoardVO타입 객체
	 */
	public BoardVO selectBoard(String boardId);
	
	/**
	 * 특정 MemId가 작성한 게시글을 조회하는 메서드
	 * @return 게시글 정보를 담고 있는 BoardVO타입 객체
	 */
	public List<BoardVO> selectMemBoard(String memId);

	/**
	 * BoardTitle, BoardContents 내용 안에 있는 내용 검색해서 리스트로 출력
	 * @return 검색한 단어가 들어있는 List<BoardVO>타입 객체
	 */
	public List<BoardVO> searchBoard(BoardVO bv);
	
	public List<BoardVO> categoryList(String category);
	
	/**
	 * 거래상태 업데이트 메서드
	 * @param bv
	 * @return
	 */
	public int updateBoardStatus(BoardVO bv);
	
	/**
	 * 게시글 페이징
	 * @param bv
	 * @return
	 */
	public List<BoardVO> boardPaging(Map<String, Object> bv);
	
	/**
	 * 게시글 수 조회
	 */
	public int boardCount();
	


}
