package member.dao;

import java.util.List;

import board.vo.BoardVO;
import comm.dao.MyBatisDAO;
import member.vo.MemberVO;
import trade.vo.TradeVO;

public class MemberDaoImpl extends MyBatisDAO implements IMemberDao{

	private static IMemberDao memDao;
	
	private MemberDaoImpl() {}
	public static IMemberDao getInstance() {
		if (memDao == null) {
			memDao = new MemberDaoImpl();
		}
		return memDao;
	}
	
	@Override
	public int insertMember(MemberVO mv) {
		return insert("member.insertMember", mv);
	}

	@Override
	public boolean checkMember(String memId) {
		
		boolean isExist = false;
		
		int cnt = (int) selectOne("member.checkMember", memId);
		// TODO Auto-generated method stub
		if(cnt > 0) {
			isExist = true;
		}
		
		return isExist;
	}

	@Override
	public int updateMember(MemberVO mv) {
		return update("member.updateMember", mv);
	}

	@Override
	public int deleteMember(String memId) {
		return delete("member.deleteMember", memId);
	}

	@Override
	public List<MemberVO> listMember(String memId) {
		return selectList("member.listMember", null);
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		
		return selectList("member.searchMember",mv);
	}
	@Override
	public MemberVO getMember(String memId) {

		return selectOne("member.selectMember", memId);
	}
	@Override
	public MemberVO memberInfo(String memId) {

		return selectOne("member.memberInfo", memId);
	}
	@Override
	public int memberLogin(MemberVO mv) {
		return selectOne("member.memberLogin", mv);
	}
	
	//로그인
	@Override
	public MemberVO findUser(MemberVO mv) {
		return selectOne("member.findUser", mv);
	}
	
	@Override
	public int registerRegion1(MemberVO mv) {
		return update("member.registerRegion1",mv);
	}
	
	
	@Override
	public int insertProfile(MemberVO mv) {
		return insert("member.insertProfile", mv);
	}
	
	//아이디 찾기 메소드
	@Override
	public MemberVO findId(MemberVO mv) {
		return selectOne("member.findId", mv);
	}
	
	//비밀번호 찾기 메소드
	@Override
	public MemberVO findPw(MemberVO mv) {
		return selectOne("member.findPw", mv);
	}
	@Override
	public List<BoardVO> sellList(TradeVO tv) {
		return selectList("board.sellList",tv);
	}
	
}