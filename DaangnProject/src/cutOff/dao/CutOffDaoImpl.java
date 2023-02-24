package cutOff.dao;

import java.util.List;

import comm.dao.MyBatisDAO;
import cutOff.vo.CutOffVO;
import member.vo.MemberVO;

public class CutOffDaoImpl extends MyBatisDAO implements ICutOffDao{

	
	private static ICutOffDao dao;
	private CutOffDaoImpl() {}
	public static ICutOffDao getInstance() {
		if(dao == null) {
			dao = new CutOffDaoImpl();
		}
		return dao;
	}
	//회원차단
	@Override
	public int insertCutOffMem(CutOffVO com) {
		return insert("cutoff.insertCutOffMember",com);
	}
	//회원차단해제
	@Override
	public int deleteCutOffMem(CutOffVO com) {
		return delete("cutoff.cancelCutOffMember",com);
	}
	//차단회원리스트
	@Override
	public List<CutOffVO> cutOffList(String cutoffmem) {
		return selectList("cutoff.cutOffList", cutoffmem);
	}
	@Override
	public List<MemberVO> covNic(String cov) {
		return selectList("cutoff.cutOffList", cov);
	}
	@Override
	public List<MemberVO> cutoffmemNic(String cutoffmem) {
		return selectList("cutoff.cutOffList", cutoffmem);
	}
}
