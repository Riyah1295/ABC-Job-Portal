package job.portal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import job.portal.bean.EntityBean;
import job.portal.bean.JobBean;
import job.portal.bean.UserBean;

/**
 * We can insert, update & delete job post but only the job post that we create.
 * We fetch all the job post list by all the user. 
 * @author Riyah
 *
 */

public class JobDao extends DBDao implements Dao{

	@Override
	public int insert(EntityBean entity) throws SQLException, Exception {
		int i = 0;
		JobBean userJob = (JobBean) entity;
		try {
			String sql = "INSERT INTO jobAdd VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, userJob.getUsername());
			ps.setInt(2, userJob.getJobCode());
			ps.setString(3, userJob.getJobTitle());
			ps.setString(4, userJob.getJobDesc());
			ps.setString(5, userJob.getCountryJob());
			ps.setString(6, userJob.getCloseDate());
			
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
		JobBean userJob = (JobBean) entity;
		
		try {
			String sql = "UPDATE jobAdd SET jobTitle=?,jobDesc=?,countryJob=?,closeDate=? WHERE jobCode=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, userJob.getJobTitle());
			ps.setString(2, userJob.getJobDesc());
			ps.setString(3, userJob.getCountryJob());
			ps.setString(4, userJob.getCloseDate());
			ps.setInt(5, userJob.getJobCode());
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
		JobBean userJob = (JobBean) entity;
		try {
			String sql = "DELETE FROM jobAdd WHERE jobCode=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userJob.getJobCode());
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
	
	public ResultSet fetchPost(EntityBean entity) throws Exception{
		ResultSet rs = null;
		UserBean userJob = (UserBean) entity;
		//JobBean userJob = (JobBean) entity;
		
		try {
			String sql = "SELECT * FROM jobAdd WHERE username=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, userJob.getUsername());
			rs = ps.executeQuery();
			return rs;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public ResultSet fetchAllPost() throws Exception{
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM jobAdd";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public ResultSet fetchMyPost(EntityBean entity) throws Exception{
		ResultSet rs = null;
		JobBean userJob = (JobBean) entity;
		
		try {
			String sql = "SELECT * FROM jobAdd WHERE jobCode=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userJob.getJobCode());
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
