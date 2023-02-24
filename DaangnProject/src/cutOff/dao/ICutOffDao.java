package cutOff.dao;

import java.util.List;

import cutOff.vo.CutOffVO;
import member.vo.MemberVO;

public interface ICutOffDao {

	
	////////////////////차단//////////////////////
	/**
	 * 회원차단하기
	 * @param mv
	 * @return
	 */
	public int insertCutOffMem(CutOffVO com);
	
	/**
	 * 차단해제하기
	 * @param mv
	 * @return
	 */
	public int deleteCutOffMem(CutOffVO com);
	
	/**
	 * 차단회원리스트
	 * @param mv
	 * @return
	 */
	public List<CutOffVO> cutOffList(String cutoffmem);

	
	public List<MemberVO> covNic(String cov);

	public List<MemberVO> cutoffmemNic(String cutoffmem);
}
