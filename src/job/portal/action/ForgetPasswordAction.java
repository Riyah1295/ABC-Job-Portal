package job.portal.action;

import job.portal.bean.UserBean;
import job.portal.dao.UserDao;

import java.util.Random;
import com.opensymphony.xwork2.ActionSupport;

/**
 * To let the user set a new password.
 * It validates the user's email before they can change their password.
 * @author Riyah
 *
 */

public class ForgetPasswordAction extends ActionSupport {

	private static final long serialVersionUID = 1268185596443187406L;
	
	private String msg="";
	UserDao userDao = new UserDao();
	private UserBean userBean;
	
	private String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private String randomString="";
	private String code="";
	private String userCode="";
	private int length = 5;
	Random rand = new Random();
	
	int ctr = 0;
		
	@SuppressWarnings("static-access")
	@Override
	public String execute() throws Exception{
		
		if(userBean.getEmail().equals("")) {
			msg = "Email field are mandatory!";
			
		}
		
		else if(!userBean.getEmail().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,4}")) {
			msg = "Incorrect email format!";
			
		}
		
		else if(!userDao.checkEmail(userBean)) {
			msg = "No such Email!";
			
		}
		
		else {
			for (int i = 0; i < length; i++) {
				char c = characters.charAt(rand.nextInt(62));
				randomString+=c;
				code=randomString;
			}
			String subject = "Reset password";
			
			String content = "Dear" + code
					+ "\n\n Thank you for code with ABC job portal.!"
					+ "\n We are delighted to have you with us and hope to provide the services"
					+ "\n needed in the website."
					+ "\n\n Regards"
					+ "\n ABC job portal team";
			userDao.sendEmail("systemsC307@gmail.com", "c307system", "nursyazriyah95@gmail.com", subject, content);
			return "SUCCESS";
		}
		return "ERROR";
	}
	
	public String checkCode() {
		if(!userCode.equals(code)) {
			msg = "The code does not match with the given code!";
			for (int i = 0; i < length; i++) {
				char c = characters.charAt(rand.nextInt(62));
				randomString+=c;
				code=randomString;
				userCode="";
			}
			return "ERRORCODE";
		}
		else {
			return "SUCCESSCODE";
		}
	}
	
	public String setPassword() throws Exception {
		
		if(userBean.getPassword().equals("")||userBean.getConfirmPass().equals("")) {
			msg = "All fields are mandatory!";
			return "ERRORSET";
		}
		else if(!userBean.getPassword().equals(userBean.getConfirmPass())) {
			msg = "Password does not match!";
			return "ERRORSET";
		}
		else {
			ctr = userDao.editPassword(userBean);
			if (ctr > 0) {
				msg = "Password updated successfully!";
			}
			else {
				msg = "Failed to update!";
				return "ERRORSET";
			}
		}

		return "SUCCESSSET";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCharacters() {
		return characters;
	}

	public void setCharacters(String characters) {
		this.characters = characters;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getRandomString() {
		return randomString;
	}

	public void setRandomString(String randomString) {
		this.randomString = randomString;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
}
