package interest.dao;

import java.util.List;

import board.vo.BoardVO;
import comm.dao.MyBatisDAO;
import interest.vo.InterestVO;

public class InterestDaoImpl extends MyBatisDAO implements IinterestDao {

	private static IinterestDao dao;
	private InterestDaoImpl() {}
	public static IinterestDao getInstance() {
		if(dao==null) {
			dao=new InterestDaoImpl();
		}
		return dao;
	}
	
	@Override
	public int insertInterest(InterestVO iv) {
		return insert("board.insertInterest",iv);
	}

	@Override
	public int deleteInterest(InterestVO iv) {
		return delete("board.deleteInterest",iv);
	}
	
	@Override
	public List<BoardVO> interestList(String memId) {
		return selectList("board.interestList",memId);
	}
	@Override
	public int selectOneInter(InterestVO iv) {
		return (int)selectOne("board.selectOneInter",iv);
	}
}
