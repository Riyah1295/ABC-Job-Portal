package job.portal.action;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import job.portal.bean.UserBean;
import job.portal.dao.UserDao;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 4437705683797388210L;

	private UserDao userDao = null;
	ArrayList<UserBean> userBeanList = null;
	ResultSet rs = null;
	private boolean noData = false;
	private String msg = "";
	private UserBean userBean;
	ArrayList<String> emailList;
	
	
	@Override
	public String execute() throws Exception{
		
		try {
			userDao = new UserDao();
			int isDeleted = userDao.delete(userBean);
			
			if (isDeleted > 0) {
				userBeanList = new ArrayList<UserBean>();
				rs = userDao.fetchAllUser();
				int i = 0;
				if (rs != null) {
					while (rs.next()) {
						i++;
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
				if(i==0) {
					noData = false;
				}
				else {
					noData = true;
				}
				msg = "User record deleted successfully!";
			}
			else {
				msg = "User record unable to delete!";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "DELETEUSER";
	}
	
	public String sendBulkEmail() {
		
		
		try {
			userDao = new UserDao();
			userBeanList = new ArrayList<UserBean>();
			
			rs = userDao.fetchAllEmail();
			emailList = new ArrayList<String>();
			if(rs != null) {
				while(rs.next()) {
					
					emailList.add(rs.getString("email"));
					
				}
			}
			System.out.println(emailList);
			StringBuilder sb = new StringBuilder();
			for(String s : emailList) {
				sb.append(s);
				sb.append(",");
			}
			
			System.out.println(sb.toString());
			String subject = "Test bulk email";
			String content = "Dear Recipients,"
			+ "\n\n Thank you for using  ABC job portal!"
			+ "\n We are delighted to have you with us and hope to provide the services"
			+ "\n needed in the website."
			+ "\n\n Regards"
			+ "\n ABC job portal team";
			userDao.sendEmail("systemsC307@gmail.com", "c307system", sb.toString(), subject, content);
			msg = "Registration successful!";
			return "SENDBULKEMAIL";
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			return "ERROREMAIL";
		}
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ArrayList<UserBean> getUserBeanList() {
		return userBeanList;
	}

	public void setUserBeanList(ArrayList<UserBean> userBeanList) {
		this.userBeanList = userBeanList;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public ArrayList<String> getEmailList() {
		return emailList;
	}

	public void setEmailList(ArrayList<String> emailList) {
		this.emailList = emailList;
	}
}
