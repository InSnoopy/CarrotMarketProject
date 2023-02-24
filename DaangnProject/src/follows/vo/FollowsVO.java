package follows.vo;

public class FollowsVO {
	
	private String following;
	private String follower;
	
	public FollowsVO() {
		super();
	}
	public String getFollowing() {
		return following;
	}
	public void setFollowing(String following) {
		this.following = following;
	}
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}
	@Override
	public String toString() {
		return "FollowsVO [following=" + following + ", follower=" + follower + "]";
	}
}
