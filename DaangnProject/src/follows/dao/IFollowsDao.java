package follows.dao;

import java.util.List;
import follows.vo.FollowsVO;
import member.vo.MemberVO;

public interface IFollowsDao {
	
	public int insertFollows(FollowsVO fv);
	
	public int deleteFollows(FollowsVO fv);
	
	public FollowsVO findFollows(FollowsVO fv);
	
	public List<FollowsVO> followingList(String follower);
	
	public List<FollowsVO> followerList(String following);
	
	public List<MemberVO> followingNic(String follower);
	
	public List<MemberVO> followerNic(String following);
}
