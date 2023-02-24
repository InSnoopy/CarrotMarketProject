package interest.service;

import java.util.List;

import board.vo.BoardVO;
import interest.vo.InterestVO;

public interface iInterestService {
	
	public int insertInterest(InterestVO interestVO);
	
	public int deleteInterest(InterestVO interestVO);

	public List<BoardVO> interestList(String memId);
	
	public int selectOneInter(InterestVO iv);
}
