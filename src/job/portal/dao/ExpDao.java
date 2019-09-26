package job.portal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import job.portal.bean.EntityBean;
import job.portal.bean.ExpBean;

/**
 * We can insert, update & delete user's experience.
 * We fetch the experience list based on the user that are currently login.
 * @author Riyah
 *
 */

public class ExpDao extends DBDao implements Dao{

	@Override
	public int insert(EntityBean entity) throws SQLException, Exception {
		int i = 0;
		ExpBean userExp = (ExpBean) entity;
		try {
			String sql = "INSERT INTO experience VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, userExp.getUsername());
			ps.setInt(2, userExp.getExpId());
			ps.setString(3, userExp.getCompName());
			ps.setString(4, userExp.getCompAddr());
			ps.setString(5, userExp.getCountryComp());
			ps.setString(6, userExp.getYearsExp());
			ps.setString(7, userExp.getJobRole());
				
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
				
			return 0;
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
		ExpBean userExp = (ExpBean) entity;
			
		try {
			String sql = "UPDATE experience SET compName=?,compAddr=?,countryComp=?,yearsExp=?,jobRole=? WHERE expId=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, userExp.getCompName());
			ps.setString(2, userExp.getCompAddr());
			ps.setString(3, userExp.getCountryComp());
			ps.setString(4, userExp.getYearsExp());
			ps.setString(5, userExp.getJobRole());
			ps.setInt(6, userExp.getExpId());
				
			
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
		ExpBean userExp = (ExpBean) entity;
			
		try {
			String sql = "DELETE FROM experience WHERE expId=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userExp.getExpId());
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public ResultSet fetchExp(EntityBean entity) throws Exception{
		ResultSet rs = null;
		ExpBean userExp = (ExpBean) entity;
		
		try {
			String sql = "SELECT * FROM experience WHERE username=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, userExp.getUsername());
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
	
	public ResultSet fetchExpEdit(EntityBean entity) throws Exception{
		ResultSet rs = null;
		ExpBean userExp = (ExpBean) entity;
		
		try {
			String sql = "SELECT * FROM experience WHERE expId=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userExp.getExpId());
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
