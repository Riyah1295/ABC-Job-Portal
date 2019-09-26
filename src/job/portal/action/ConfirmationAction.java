package job.portal.action;

import job.portal.bean.UserBean;
import job.portal.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * To insert into database once the user click on submit.
 * @author Riyah
 *
 */

public class ConfirmationAction extends ActionSupport{
	
	private static final long serialVersionUID = -5066432198890677359L;
	private String msg = "";
	UserDao userDao = new UserDao();
	private UserBean userBean;
	int ctr = 0;

	@Override
	public String execute() throws Exception{
		// To insert into database.
		try {
			ctr = userDao.insert(userBean);
			if (ctr > 0) {
				userDao.fetchUser(userBean);
				String subject = "Test single email";
				String content = "Dear " + userBean.getFirstName() + " " + userBean.getLastName() + ","
						+ "\n\n Thank you for registering with ABC job portal!"
						+ "\n We are delighted to have you with us and hope to provide the services"
						+ "\n needed in the website."
						+ "\n\n Regards"
						+ "\n ABC job portal team";
				userDao.sendEmail("systemsC307@gmail.com", "c307system", userBean.getEmail(), subject, content);
				msg = "Registration successful!";
			}
			else {
				msg = "Registration fail!";
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "CONFIRM";
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

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}		
}