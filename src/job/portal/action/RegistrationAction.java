package job.portal.action;

import com.opensymphony.xwork2.ActionSupport;

import job.portal.bean.UserBean;
import job.portal.dao.UserDao;

/**
 * Validation of the registration form.
 * Invalid format would be prompted with error message.
 * @author Riyah
 *
 */

public class RegistrationAction extends ActionSupport{
	
	// Declarations of variables.
	private static final long serialVersionUID = 2139116285823340125L;
	private String msg;
	UserDao userDao = new UserDao();
	private UserBean userBean;

	@SuppressWarnings("static-access")
	@Override
	public String execute() throws Exception{
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
		
		// To check with the database whether the given username already exist.
		else if(userDao.checkUsername(userBean)) {
			msg = "Username is already taken!";
		}
		
		// To check if the given confirm password is the same as the password.
		else if(!userBean.getPassword().equals(userBean.getConfirmPass())) {
			msg = "Password does not match!";
		}
		
		// Else proceed to confirmation page.
		else {
			
			return "CONFIRM";
		}
		return "REGISTER";
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
}
