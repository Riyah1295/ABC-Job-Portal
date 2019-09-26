package job.portal.action;

import job.portal.bean.FriendsBean;
import job.portal.bean.UserBean;
import job.portal.dao.FriendsDao;
import job.portal.dao.UserDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

/**
 * To search for other user by their first name.
 * User can add them as friends.
 * @author Riyah
 *
 */

public class SearchAction extends ActionSupport {

	private static final long serialVersionUID = 8940548536692968972L;
	private FriendsBean friendsBean;
	private UserBean userBean;
	FriendsDao friendsDao = null;
	UserDao userDao = null;
	private String msg="";
	ResultSet rs = null;
	String submitType;
	List<FriendsBean> friendsBeanList = null;
	List<UserBean> userBeanList = null;
	private boolean noData = false;
	int ctr = 0;
	
	@Override
	public String execute() throws Exception{
		userDao = new UserDao();
		if (!userBean.getFirstName().equals("")) {
			userBeanList = new ArrayList<UserBean>();
			rs = userDao.search(userBean);
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					userBean = new UserBean(); 
					userBean.setUsername(rs.getString("username"));
					userBean.setFriendsName(rs.getString("username"));
					userBean.setName(rs.getString("name"));
					userBeanList.add(userBean);	
				}
			}
			if (i == 0) {
				msg = "No such person!";
			}
		}
		else {
			msg = "Please enter a valid search!";
		}
		
		return "SEARCH";
	}
	
	@SuppressWarnings("static-access")
	public String addFriends() {
		friendsDao = new FriendsDao();
		try {
			
			if(friendsDao.checkFriends(friendsBean)) {
				msg = "Friend already added!";
			}
			else {
				ctr = friendsDao.insert(friendsBean);
				if(ctr > 0) {
					msg = "Friend added successfully!";
				}
				else {
					msg = "Failed to add!";
				}	
			}
		}
		catch(Exception e) {
			System.out.println(e);
			//throw e;
			//e.printStackTrace();
		}
		
		return "ADDFREINDS";
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public List<UserBean> getUserBeanList() {
		return userBeanList;
	}

	public void setUserBeanList(List<UserBean> userBeanList) {
		this.userBeanList = userBeanList;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public FriendsBean getFriendsBean() {
		return friendsBean;
	}

	public void setFriendsBean(FriendsBean friendsBean) {
		this.friendsBean = friendsBean;
	}

	public FriendsDao getFriendsDao() {
		return friendsDao;
	}

	public void setFriendsDao(FriendsDao friendsDao) {
		this.friendsDao = friendsDao;
	}

	public List<FriendsBean> getFriendsBeanList() {
		return friendsBeanList;
	}

	public void setFriendsBeanList(List<FriendsBean> friendsBeanList) {
		this.friendsBeanList = friendsBeanList;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}
}
