package interest.service;

import java.util.List;

import board.vo.BoardVO;
import interest.dao.IinterestDao;
import interest.dao.InterestDaoImpl;
import interest.vo.InterestVO;

public class InterestServiceImpl implements iInterestService {

	private static iInterestService service;
	private IinterestDao dao;
	private InterestServiceImpl() {
		dao = InterestDaoImpl.getInstance();
	}
	public static iInterestService getInstance() {
		if(service==null) {
			service = new InterestServiceImpl();
		}
		return service;
	}
	
	@Override
	public int insertInterest(InterestVO iv) {
		int cnt = dao.insertInterest(iv);
		return cnt;
	}

	@Override
	public int deleteInterest(InterestVO iv) {
		int cnt = dao.deleteInterest(iv);
		return cnt;
	}
	
	@Override
	public List<BoardVO> interestList(String memId) {
		List<BoardVO> interList = dao.interestList(memId);
		return interList;
	}
	
	@Override
	public int selectOneInter(InterestVO iv) {
		int cnt = dao.selectOneInter(iv);
		return cnt;
	}
}
