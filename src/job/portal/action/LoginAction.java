package job.portal.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import job.portal.bean.FriendsBean;
import job.portal.bean.JobBean;
import job.portal.bean.UserBean;
import job.portal.dao.FriendsDao;
import job.portal.dao.JobDao;
import job.portal.dao.UserDao;

/**
 * To check if the user is a valid or new user.
 * If it is a valid user, they can see their profile.
 * If not, they need to register first before they can login.
 * @author Riyah
 *
 */

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7993575709024122397L;
	private String msg = "";
	private Map<String, Object> sessionMap;
	private UserBean userBean;
	private UserDao userDao = null;
	private JobDao jobDao = null;
	private FriendsDao friendsDao;
	private JobBean jobBean;
	private FriendsBean friendsBean;
	ResultSet rs = null;
	private boolean noData = false;
	private boolean noDataF = false;
	List<JobBean> jobBeanList = null;
	List<JobBean> jobBeanListAll = null;
	List<FriendsBean> friendsBeanList = null;
	ArrayList<UserBean> userBeanList = null;
	
	String submitType;
	int ctr = 0;
	
	
	@SuppressWarnings("static-access")
	@Override
	public String execute() throws Exception{
		userDao = new UserDao();
		if(userDao.checkLogin(userBean)) {
			sessionMap.put("username", userBean.getUsername());
			
			rs = userDao.fetchUser(userBean);
			if(rs != null) {
				while(rs.next()) {
					userBean.setUsername(rs.getString("username"));
					userBean.setName(rs.getString("name"));
				}
			}
		
		jobBeanList = new ArrayList<JobBean>();
		jobDao = new JobDao();
		rs = jobDao.fetchPost(userBean);
		int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					jobBean = new JobBean();
					jobBean.setJobCode(rs.getInt("jobCode"));
					jobBean.setJobTitle(rs.getString("jobTitle"));
					jobBean.setJobDesc(rs.getString("jobDesc"));
					jobBean.setCountryJob(rs.getString("countryJob"));
					jobBean.setCloseDate(rs.getString("closeDate"));
					jobBeanList.add(jobBean);
				}
			}
			if(i==0) {
				noData = false;
			}
				
			else {
				noData = true;
			}
			
		jobBeanListAll = new ArrayList<JobBean>();
		jobDao = new JobDao();
		rs = jobDao.fetchAllPost();
		int q = 0;
			if (rs != null) {
				while (rs.next()) {
					q++;
								
					jobBean = new JobBean();
					jobBean.setUsername(rs.getString("username"));
					jobBean.setJobCode(rs.getInt("jobCode"));
					jobBean.setJobTitle(rs.getString("jobTitle"));
					jobBean.setJobDesc(rs.getString("jobDesc"));
					jobBean.setCountryJob(rs.getString("countryJob"));
					jobBean.setCloseDate(rs.getString("closeDate"));
					jobBeanListAll.add(jobBean);
				}
			}
			if(q==0) {
				noData = false;
			}
				
			else {
				noData = true;
			}
			
		friendsBeanList = new ArrayList<FriendsBean>();
		friendsDao = new FriendsDao();
		rs = friendsDao.fetchFriends(userBean);
		int f = 0;
			if (rs != null) {
				while (rs.next()) {
					f++;		
					friendsBean = new FriendsBean();
					friendsBean.setUsername(rs.getString("username"));
					friendsBean.setFriendsId(rs.getInt("friendsId"));
					friendsBean.setFriendsName(rs.getString("friendsName"));
					//friendsBean.setName(rs.getString("name"));
					
					friendsBeanList.add(friendsBean);
				}
			}
			if(f==0) {
				noDataF = false;
			}
						
			else {
				noDataF = true;
			}	
			
			return "SUCCESS";
		}
		
		else if(userBean.getUsername().equals("admin") && userBean.getPassword().equals("admin")) {
			
			userBeanList = new ArrayList<UserBean>();
			userDao = new UserDao();
			rs = userDao.fetchAllUser();
			
				if (rs != null) {
					while (rs.next()) {
									
						userBean = new UserBean();
						userBean.setUsername(rs.getString("username"));
						userBean.setFirstName(rs.getString("firstName"));
						userBean.setLastName(rs.getString("lastName"));
						userBean.setEmail(rs.getString("email"));
						userBean.setGender(rs.getString("gender"));
						userBean.setDateOfBirth(rs.getString("dateOfBirth"));
						userBean.setPhoneNum(rs.getString("phoneNum"));
						userBean.setAddrName(rs.getString("addrName"));
						userBean.setStName(rs.getString("stName"));
						userBean.setCountryName(rs.getString("countryName"));
						userBeanList.add(userBean);
					}
				}

			return "SUCCESSADMIN";
		}
		
		else {
			msg = "Please fill up your username & password as it is required!";

			return "ERROR";
		}
		
	}
	
	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public JobDao getJobDao() {
		return jobDao;
	}

	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	public FriendsDao getFriendsDao() {
		return friendsDao;
	}

	public void setFriendsDao(FriendsDao friendsDao) {
		this.friendsDao = friendsDao;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public JobBean getJobBean() {
		return jobBean;
	}

	public void setJobBean(JobBean jobBean) {
		this.jobBean = jobBean;
	}

	public FriendsBean getFriendsBean() {
		return friendsBean;
	}

	public void setFriendsBean(FriendsBean friendsBean) {
		this.friendsBean = friendsBean;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<JobBean> getJobBeanList() {
		return jobBeanList;
	}

	public void setJobBeanList(List<JobBean> jobBeanList) {
		this.jobBeanList = jobBeanList;
	}

	public List<JobBean> getJobBeanListAll() {
		return jobBeanListAll;
	}

	public void setJobBeanListAll(List<JobBean> jobBeanListAll) {
		this.jobBeanListAll = jobBeanListAll;
	}

	public List<FriendsBean> getFriendsBeanList() {
		return friendsBeanList;
	}

	public void setFriendsBeanList(List<FriendsBean> friendsBeanList) {
		this.friendsBeanList = friendsBeanList;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

	public boolean isNoDataF() {
		return noDataF;
	}

	public void setNoDataF(boolean noDataF) {
		this.noDataF = noDataF;
	}

	public ArrayList<UserBean> getUserBeanList() {
		return userBeanList;
	}

	public void setUserBeanList(ArrayList<UserBean> userBeanList) {
		this.userBeanList = userBeanList;
	}
	
}
