package board.service;

import java.util.List;
import java.util.Map;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	
	private static IBoardService boardService;
	
	private IBoardDao boardDao;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}
	
	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = boardDao.insertBoard(bv);
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = boardDao.updateBoard(bv);
		return cnt;
	}

	@Override
	public int deleteBoard(String boardId) {
		int cnt = boardDao.deleteBoard(boardId);
		return cnt;
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> boardList = boardDao.selectAllBoard();
		return boardList;
	}

	@Override
	public BoardVO selectBoard(String boardId) {
		BoardVO boardVO = boardDao.selectBoard(boardId);
		return boardVO;
	}

	@Override
	public List<BoardVO> selectMemBoard(String memId) {
		List<BoardVO> boardMemList = boardDao.selectMemBoard(memId);
		return boardMemList;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		List<BoardVO> searchBoardList = boardDao.searchBoard(bv);
		return searchBoardList;
	}

	@Override
	public List<BoardVO> categoryList(String category) {
		List<BoardVO> cateList = boardDao.categoryList(category);
		return cateList;
	}

	@Override
	public int updateBoardStatus(BoardVO bv) {
		int cnt = boardDao.updateBoardStatus(bv);
		return cnt;
	}

	@Override
	public List<BoardVO> boardPaging(Map<String, Object> bv) {
		return boardDao.boardPaging(bv);
	}

	@Override
	public int boardCount() {
		return boardDao.boardCount();
	}
}
