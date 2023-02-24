package follows.dao;

import java.util.List;

import comm.dao.MyBatisDAO;
import follows.vo.FollowsVO;
import member.vo.MemberVO;

public class FollowsDaoImpl extends MyBatisDAO implements IFollowsDao {
	
	private static IFollowsDao dao;
	private FollowsDaoImpl() {}
	public static IFollowsDao getInstance() {
		if(dao == null) {
			dao = new FollowsDaoImpl();
		}
		return dao;
	}

	@Override
	public int insertFollows(FollowsVO fv) {
		return insert("follows.follows",fv);
	}

	@Override
	public int deleteFollows(FollowsVO fv) {
		return delete("follows.cancelFollows",fv);
	}
	@Override
	public FollowsVO findFollows(FollowsVO fv) {
		return selectOne("follows.findFollows", fv);
	}
	@Override
	public List<FollowsVO> followingList(String follower) {
		return selectList("follows.followingList", follower);
	}
	@Override
	public List<FollowsVO> followerList(String following) {
		return selectList("follows.followerList", following);
	}
	@Override
	public List<MemberVO> followingNic(String follower) {
		return selectList("follows.followingNic",follower);
	}
	@Override
	public List<MemberVO> followerNic(String following) {
		return selectList("follows.followerNic",following);
	}
}
