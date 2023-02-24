package follows.service;

import java.util.List;

import follows.dao.FollowsDaoImpl;
import follows.dao.IFollowsDao;
import follows.vo.FollowsVO;
import member.vo.MemberVO;

public class FollowsServiceImpl implements IFollowsService {
	
	private static IFollowsService service;
	private IFollowsDao dao;
	
	private FollowsServiceImpl() {
		dao = FollowsDaoImpl.getInstance();
	}
	
	public static IFollowsService getInstance() {
		if(service==null) {
			service = new FollowsServiceImpl();
		}
		return service;
	}
	
	@Override
	public int insertFollows(FollowsVO fv) {
		int cnt = dao.insertFollows(fv);
		return cnt;
	}

	@Override
	public int deleteFollows(FollowsVO fv) {
		int cnt = dao.deleteFollows(fv);
		return cnt;
	}

	@Override
	public FollowsVO findFollows(FollowsVO fv) {
		return dao.findFollows(fv);
	}

	@Override
	public List<FollowsVO> followingList(String follower) {
		List<FollowsVO> followList = dao.followingList(follower);
		return followList;
	}

	@Override
	public List<FollowsVO> followerList(String following) {
		List<FollowsVO> followerList = dao.followerList(following);
		return followerList;
	}

	@Override
	public List<MemberVO> followingNic(String follower) {
		List<MemberVO> followingNic = dao.followingNic(follower);
		return followingNic;
	}

	@Override
	public List<MemberVO> followerNic(String following) {
		List<MemberVO> followerNic = dao.followerNic(following);
		return followerNic;
	}
}
