package board.dao;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;
import comm.dao.MyBatisDAO;

public class BoardDaoImpl extends MyBatisDAO implements IBoardDao {

	private static IBoardDao boardDao;
	
	private BoardDaoImpl() {
		
	}
	
	public static IBoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}
	
	@Override
	public int insertBoard(BoardVO bv) {
		return insert("board.boardInsert", bv);
	}

	@Override
	public int updateBoard(BoardVO bv) {
		return update("board.boardUpdate",bv);
	}

	@Override
	public int deleteBoard(String boardId) {
		return delete("board.boardDelete", boardId);
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		return selectList("board.boardList", null);
	}

	@Override
	public BoardVO selectBoard(String boardId) {
		return selectOne("board.boardSearch", boardId);
	}

	@Override
	public List<BoardVO> selectMemBoard(String memId) {
		return selectList("board.boardlistMem", memId);
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		return selectList("board.searchBoard", bv);
	}

	@Override
	public List<BoardVO> categoryList(String category) {
		return selectList("board.categoryList",category);
	}

	@Override
	public int updateBoardStatus(BoardVO bv) {
		return update("board.updateBoardStatus", bv);
	}

	@Override
	public List<BoardVO> boardPaging(Map<String, Object> bv) {
		return selectList("board.boardPaging", bv);
	}

	@Override
	public int boardCount() {
		int cnt = selectOne("board.boardCount", null);
		return cnt;
	}
}
