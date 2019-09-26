package job.portal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import job.portal.bean.EduBean;
import job.portal.bean.EntityBean;
import job.portal.bean.UserBean;

/**
 * We can insert & update a user.
 * We check for a valid username so to ensure no duplication of username.
 * We check for a valid email for the forget password function.
 * We check for a valid login so only valid user can be see their profile page.
 * We use the user's first name for our search function.
 * @author Riyah
 *
 */

public class UserDao extends DBDao implements Dao{
	
	@Override
	public int insert(EntityBean entity) throws SQLException, Exception {
		UserBean user = (UserBean) entity;
		int i = 0;
		
		try {
			String sql = "INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getDateOfBirth());
			ps.setString(6, user.getPhoneNum());
			ps.setString(7, user.getAddrName());
			ps.setString(8, user.getStName());
			ps.setString(9, user.getCountryName());
			ps.setString(10, user.getUsername());
			ps.setString(11, user.getPassword());
			ps.setString(12, user.getConfirmPass());
			i = ps.executeUpdate();
			
			return i;
				
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	@Override
	public int update(EntityBean entity) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		UserBean user = (UserBean) entity;
		
		try {
			String sql = "UPDATE user SET firstName=?, lastName=?, email=?, gender=?, dateOfBirth=?, phoneNum=?, addrName=?, "
					+ "stName=?, countryName=?, password=?, confirmPass=? WHERE username=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getDateOfBirth());
			ps.setString(6, user.getPhoneNum());
			ps.setString(7, user.getAddrName());
			ps.setString(8, user.getStName());
			ps.setString(9, user.getCountryName());
			ps.setString(10, user.getPassword());
			ps.setString(11, user.getConfirmPass());
			ps.setString(12, user.getUsername());
			i = ps.executeUpdate();

			return i;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	@Override
	public int delete(EntityBean entity) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		UserBean user = (UserBean) entity;
			
		try {
			String sql = "DELETE FROM user WHERE username=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	// To check if username already exist.
	public static boolean checkUsername(EntityBean entity) throws Exception {
		boolean status = false;
		UserBean user = (UserBean) entity;
		
		try {
			String sql = "SELECT username FROM user WHERE username=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				if(rs.getString("username").equals(user.getUsername())) {
					status = true;
				}
				else {
					status = false;
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return status;
	}
	
	// To check if email is valid in DB.
	public static boolean checkEmail(EntityBean entity) throws Exception {
		boolean status = false;
		UserBean user = (UserBean) entity;
		
		try {
			String sql = "SELECT email FROM user WHERE email=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				if(rs.getString("email").equals(user.getEmail())) {
					status = true;
				}
				else {
					status = false;
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return status;
	}
	
	// To update password for forget password.
	public int editPassword(EntityBean entity)
			throws Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		UserBean user = (UserBean) entity;
		
		try {
			String sql = "UPDATE user SET password=?,confirmPass=? WHERE email=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getConfirmPass());
			ps.setString(3, user.getEmail());
			
			i = ps.executeUpdate();
			return i;
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	// Check for valid user login.
	public static boolean checkLogin(EntityBean entity) throws Exception {
		boolean status = false;
		UserBean user = (UserBean) entity;
		
		try {
			String sql = "SELECT username, password FROM user WHERE username=? AND password=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				if(rs.getString("username").equals(user.getUsername()) && rs.getString("password").equals(user.getPassword())) {
					status = true;
				}
				else {
					status = false;
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return status;
	}
	
	public ResultSet fetchUser(EntityBean entity) throws Exception{
		ResultSet rs = null;
		UserBean user = (UserBean) entity;
		
		try {
			String sql = "SELECT *, CONCAT(firstName,' ',lastName) AS name FROM user WHERE username=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			rs = ps.executeQuery();
			
			return rs;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public ResultSet search(EntityBean entity) throws Exception{
		ResultSet rs = null;
		UserBean user = (UserBean) entity;
		
		try {
			String sql = "SELECT *, CONCAT(firstName, ' ', lastName) as name FROM user WHERE firstName LIKE ?";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, '%' + user.getFirstName() + '%');
			rs = ps.executeQuery();
			return rs;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public void sendEmail(String yourEmail, String myPassword, String sendTo, String subject, String emailContent) {   

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); //TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(yourEmail, myPassword);//username, password
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(yourEmail));//my email
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(sendTo));//your email
			message.setSubject(subject);
			message.setText(emailContent);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet fetchAllUser() throws Exception{
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM user";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			
			return rs;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public ResultSet fetchAllEmail() throws Exception{
		ResultSet rs = null;
		
		try {
			String sql = "SELECT email FROM user";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			
			return rs;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}
}
