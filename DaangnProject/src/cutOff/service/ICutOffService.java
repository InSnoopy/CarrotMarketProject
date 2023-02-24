package cutOff.service;

import java.util.List;

import cutOff.vo.CutOffVO;
import member.vo.MemberVO;


/**
 * 컨트롤러의 요청을 받아 처리하는 서비스의 Interface.
 */
public interface ICutOffService {

	
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
	
	
	public List<MemberVO> cutoffmemNic(String cutoffmem);//차단 당한사람
	
	public List<MemberVO> covNic(String cov);//차단한사람
}
