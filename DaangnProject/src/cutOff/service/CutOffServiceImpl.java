package cutOff.service;

import java.util.List;

import cutOff.dao.CutOffDaoImpl;
import cutOff.dao.ICutOffDao;
import cutOff.vo.CutOffVO;
import member.vo.MemberVO;


public class CutOffServiceImpl implements ICutOffService {

	private static ICutOffService service;
	private ICutOffDao dao;
	
	private CutOffServiceImpl() {
		dao = CutOffDaoImpl.getInstance();
	}
	
	public static ICutOffService getInstance() {
		if(service==null) {
			service = new CutOffServiceImpl();
		}
		return service;
	}
	
	//회원차단
	@Override
	public int insertCutOffMem(CutOffVO com) {
		int cnt = dao.insertCutOffMem(com);
		return cnt;
	}

	//회원차단해제
	@Override
	public int deleteCutOffMem(CutOffVO com) {
		int cnt = dao.deleteCutOffMem(com);
		return cnt;
	}

	//차단회원리스트
	@Override
	public List<CutOffVO> cutOffList(String cutoffmem) {
		List<CutOffVO> cutOffList = dao.cutOffList(cutoffmem);
		return cutOffList;
	}
	
	@Override
	public List<MemberVO> cutoffmemNic(String cutoffmem) {
		List<MemberVO> cutoffmemNic = dao.cutoffmemNic(cutoffmem);
		return cutoffmemNic;
	}

	@Override
	public List<MemberVO> covNic(String cov) {
		List<MemberVO> covNic = dao.covNic(cov);
		return covNic;
	}
}
