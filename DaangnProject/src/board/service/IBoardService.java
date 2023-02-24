package board.service;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;

public interface IBoardService {
	
	/**
	 * 게시글 등록하기 위한 메서드
	 * @param bv
	 * @return
	 */
	public int insertBoard(BoardVO bv);
	
	/**
	 * 게시글 수정하기 위한 메서드
	 * @param bv
	 * @return
	 */
	public int updateBoard(BoardVO bv);
	
	/**
	 * 게시글ID를 매개변수로 받아서 해당 게시글을 삭제하는 메서드
	 * @param boardId
	 * @return
	 */
	public int deleteBoard(String boardId);
	
	/**
	 * 전체 게시글을 조회하기 위한 메서드
	 * @return
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
	 * 게시글 페이징 메서드
	 * @param bv
	 * @return
	 */
	public List<BoardVO> boardPaging(Map<String, Object> bv);
	
	/**
	 * 게시글 수 조회 메서드
	 * @return
	 */
	public int boardCount();
}
