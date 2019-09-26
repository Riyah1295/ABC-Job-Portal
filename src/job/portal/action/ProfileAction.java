package job.portal.action;

import job.portal.bean.FriendsBean;
import job.portal.bean.JobBean;
import job.portal.bean.UserBean;
import job.portal.dao.FriendsDao;
import job.portal.dao.JobDao;
import job.portal.dao.UserDao;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

/**
 * To display the user's friends list, list of job advertisement & they can post job advertisement.
 * User can add, update & delete their post.
 * User can add & delete friends.
 * @author Riyah
 *
 */

public class ProfileAction extends ActionSupport{

	private static final long serialVersionUID = -4536904623266819980L;
	private UserDao userDao = null;
	private JobDao jobDao = null;
	private FriendsDao friendsDao;
	private UserBean userBean;
	private JobBean jobBean;
	private FriendsBean friendsBean;
	ResultSet rs = null;
	private boolean noData = false;
	private boolean noDataF = false;
	List<JobBean> jobBeanList = null;
	List<JobBean> jobBeanListAll = null;
	List<FriendsBean> friendsBeanList = null;
	
	private String msg="";
	
	String submitType;
	int ctr = 0;
	
	@Override
	public String execute() throws Exception {
		try {
			//if(submitType.equals("editpost")) {
				userDao = new UserDao();
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
			//}
		}
		catch(Exception e) {
			System.out.println(e);
			//throw e;
			//e.printStackTrace();
		}
		return "FETCHPROFILE";
	}
	
	public String addPost() {
		jobDao = new JobDao();
		try {
			if(jobBean.getJobTitle().equals("") || jobBean.getJobDesc().equals("") ||
					jobBean.getCountryJob().equals("") || jobBean.getCloseDate().equals("")) {
				msg = "All fields cannot be empty!";
			}
			else {
				ctr = jobDao.insert(jobBean);
				if(ctr > 0) {
					userDao = new UserDao();
					rs = userDao.fetchUser(userBean);
					if(rs != null) {
						while(rs.next()) {
							userBean.setUsername(rs.getString("username"));
							userBean.setName(rs.getString("name"));
							
						}
					}
					
					jobBeanList = new ArrayList<JobBean>();
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
						msg = "Post added successfully!";
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
		
		return "ADDPOST";
	}
	
	public String updatePost() {
		jobDao = new JobDao();
		try {
			if(submitType.equals("editpost")) {
				rs = jobDao.fetchMyPost(jobBean);
				if(rs != null) {
					while(rs.next()) {
						jobBean.setUsername(rs.getString("username"));
						jobBean.setJobCode(rs.getInt("jobCode"));
						jobBean.setJobTitle(rs.getString("jobTitle"));
						jobBean.setJobDesc(rs.getString("jobDesc"));
						jobBean.setCountryJob(rs.getString("countryJob"));
						jobBean.setCloseDate(rs.getString("closeDate"));
					}
				}
			}
			else {
				if(jobBean.getJobTitle().equals("")||jobBean.getJobDesc().equals("")||
						jobBean.getCountryJob().equals("")||jobBean.getCloseDate().equals("")) {
					msg = "All fields are mandatory!";
				}
				else {
					ctr = jobDao.update(jobBean);
					if(ctr > 0) {
						userDao = new UserDao();
						rs = userDao.fetchUser(userBean);
						if(rs != null) {
							while(rs.next()) {
								userBean.setUsername(rs.getString("username"));
								userBean.setName(rs.getString("name"));
							}
						}
						
						jobBeanList = new ArrayList<JobBean>();
						rs = jobDao.fetchPost(userBean);
						int i = 0;
						if(rs != null) {
							while(rs.next()) {
								i++;
								jobBean = new JobBean();
								jobBean.setUsername(rs.getString("username"));
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
						msg = "Post updated successfully!";
						return "UPDATEPOST";
					}
					else {
						msg = "Post failed to update!";
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "ERRORPOST";
	}
	
	public String deletePost() {
		try {
			jobDao = new JobDao();
			int isDeleted = jobDao.delete(jobBean);
			if (isDeleted > 0) {
				
				userDao = new UserDao();
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
				msg = "Post record deleted successfully!";
			} else {
				msg = "Post record unable to delete!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "DELETEPOST";
	}
	
	public String deleteFriends() {
		try {
			friendsDao = new FriendsDao();
			int isDeleted = friendsDao.deleteF(friendsBean, userBean);
			if (isDeleted > 0) {
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
				msg = "Friends record deleted successfully!";
			} else {
				msg = "Friends record unable to delete!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETEFRIENDS";
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

	public List<JobBean> getJobBeanList() {
		return jobBeanList;
	}

	public void setJobBeanList(List<JobBean> jobBeanList) {
		this.jobBeanList = jobBeanList;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
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

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

	public List<JobBean> getJobBeanListAll() {
		return jobBeanListAll;
	}

	public void setJobBeanListAll(List<JobBean> jobBeanListAll) {
		this.jobBeanListAll = jobBeanListAll;
	}

	public FriendsBean getFriendsBean() {
		return friendsBean;
	}

	public void setFriendsBean(FriendsBean friendsBean) {
		this.friendsBean = friendsBean;
	}

	public List<FriendsBean> getFriendsBeanList() {
		return friendsBeanList;
	}

	public void setFriendsBeanList(List<FriendsBean> friendsBeanList) {
		this.friendsBeanList = friendsBeanList;
	}

	public FriendsDao getFriendsDao() {
		return friendsDao;
	}

	public void setFriendsDao(FriendsDao friendsDao) {
		this.friendsDao = friendsDao;
	}

	public boolean isNoDataF() {
		return noDataF;
	}

	public void setNoDataF(boolean noDataF) {
		this.noDataF = noDataF;
	}
}
