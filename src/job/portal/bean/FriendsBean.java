package job.portal.bean;

/**
 * Setter & getter variables of user's friends.
 * @author Riyah
 *
 */

public class FriendsBean extends EntityBean {
	private int friendsId;
	private String friendsName, name;
	
	public int getFriendsId() {
		return friendsId;
	}
	public void setFriendsId(int friendsId) {
		this.friendsId = friendsId;
	}
	public String getFriendsName() {
		return friendsName;
	}
	public void setFriendsName(String friendsName) {
		this.friendsName = friendsName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
