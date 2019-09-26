package job.portal.action;

import job.portal.bean.UserBean;
import job.portal.dao.UserDao;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

/**
 * To display the user's particulars.
 * User can update their particulars.
 * @author Riyah
 *
 */

public class ParticularsAction extends ActionSupport{

	private static final long serialVersionUID = 8857397318380002303L;
	UserDao userDao = null;
	private UserBean userBean;
	private String msg="";
	ResultSet rs = null;
	int ctr = 0;
	String submitType;
	
	@Override
	public String execute() throws Exception{
		try {
			//if(submitType.equals("edituser")) {
				userDao = new UserDao();
				rs = userDao.fetchUser(userBean);
				
				if(rs != null) {
					while(rs.next()) {
						
						userBean.setFirstName(rs.getString("firstName"));
						userBean.setLastName(rs.getString("lastName"));
						userBean.setEmail(rs.getString("email"));
						userBean.setGender(rs.getString("gender"));
						userBean.setDateOfBirth(rs.getString("dateOfBirth"));
						userBean.setPhoneNum(rs.getString("phoneNum"));
						userBean.setAddrName(rs.getString("addrName"));
						userBean.setStName(rs.getString("stName"));
						userBean.setCountryName(rs.getString("countryName"));
						userBean.setUsername(rs.getString("username"));
						userBean.setPassword(rs.getString("password"));
						userBean.setConfirmPass(rs.getString("confirmPass"));
					}
				}
			//}
		}
		catch(Exception e) {
			System.out.println(e);
			//throw e;
			//e.printStackTrace();
		}
		return "FETCHPARTICULARS";
	}
	
	public String loadParticulars() {
		return "LOADPARTICULARS";
	}
	
	public String updateParticulars() {
		userDao = new UserDao();
		try {		
			// To check if all the fields are empty.
			if(userBean.getFirstName().equals("")||userBean.getLastName().equals("")||userBean.getEmail().equals("")||userBean.getGender().equals("")||
					userBean.getDateOfBirth().equals("")||userBean.getPhoneNum().equals("")||userBean.getAddrName().equals("")||userBean.getStName().equals("")||
					userBean.getCountryName().equals("")||userBean.getUsername().equals("")||userBean.getPassword().equals("")||userBean.getConfirmPass().equals("")) {
				msg = "All fields are mandatory!";
			}
			
			// To check if the given email address is in correct format.
			else if(!userBean.getEmail().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,4}")) {
				msg = "Incorrect email format!";
			}
			
			// To check if the given date of birth is in correct format.
			else if(!userBean.getDateOfBirth().matches("(\\d{4})-(\\d{1,2})-(\\d{1,2})")) {
				msg = "Incorrect date format! E.g. 1995-12-31";
			}
			
			// To check if the given phone number is in correct format.
			else if(!userBean.getPhoneNum().matches("^[0-9]*$")||userBean.getPhoneNum().length() > 10) {
				msg = "Incorrect phone number format! Numbers only! Length of phone number is 10!";	
			}
			
			// To check if the given confirm password is the same as the password.
			else if(!userBean.getPassword().equals(userBean.getConfirmPass())) {
				msg = "Password does not match!";
			}
			
			// Else proceed to confirmation page.
			else {
				
				ctr = userDao.update(userBean);
				if(ctr > 0) {
					msg = "Particulars updated successfully!";
					
					rs = userDao.fetchUser(userBean);
					if(rs != null) {
						while(rs.next()) {
							
							userBean.setFirstName(rs.getString("firstName"));
							userBean.setLastName(rs.getString("lastName"));
							userBean.setEmail(rs.getString("email"));
							userBean.setGender(rs.getString("gender"));
							userBean.setDateOfBirth(rs.getString("dateOfBirth"));
							userBean.setPhoneNum(rs.getString("phoneNum"));
							userBean.setAddrName(rs.getString("addrName"));
							userBean.setStName(rs.getString("stName"));
							userBean.setCountryName(rs.getString("countryName"));
							userBean.setPassword(rs.getString("password"));
							userBean.setConfirmPass(rs.getString("confirmPass"));
						}
					}
					return "UPDATEPARTICULARS";
				}
				else {
					msg = "Failed to update!";
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
			//throw e;
			//e.printStackTrace();
		}
		
		 return "ERRORPARTICULARS";
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
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

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
	
}