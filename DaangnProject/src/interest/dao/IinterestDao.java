package interest.dao;

import java.util.List;

import board.vo.BoardVO;
import interest.vo.InterestVO;

public interface IinterestDao {
	
	public int insertInterest(InterestVO interestVO);
	
	public int deleteInterest(InterestVO interestVO);
	
	public List<BoardVO> interestList(String memId);
	
	public int selectOneInter(InterestVO iv);
}
