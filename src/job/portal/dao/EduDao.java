package job.portal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import job.portal.bean.EduBean;
import job.portal.bean.EntityBean;

/**
 * We can insert, update & delete user's education.
 * We fetch the education list based on the user that are currently login.
 * @author Riyah
 *
 */

public class EduDao extends DBDao implements Dao{

	@Override
	public int insert(EntityBean entity) throws SQLException, Exception {
		int i = 0;
		EduBean userEdu = (EduBean) entity;
			
		try {
			String sql = "INSERT INTO education VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, userEdu.getUsername());
			ps.setInt(2, userEdu.getEduId());
			ps.setString(3, userEdu.getQualification());
			ps.setString(4, userEdu.getInstitute());
			ps.setString(5, userEdu.getCountrySch());
			ps.setString(6, userEdu.getYearGrad());
			ps.setString(7, userEdu.getGrade());
				
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
		EduBean userEdu = (EduBean) entity;
			
		try {
			String sql = "UPDATE education SET qualification=?,institute=?,countrySch=?,yearGrad=?,grade=? WHERE eduId=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
						
			ps.setString(1, userEdu.getQualification());
			ps.setString(2, userEdu.getInstitute());
			ps.setString(3, userEdu.getCountrySch());
			ps.setString(4, userEdu.getYearGrad());
			ps.setString(5, userEdu.getGrade());
			ps.setInt(6, userEdu.getEduId());
						
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
		EduBean userEdu = (EduBean) entity;
			
		try {
			String sql = "DELETE FROM education WHERE eduId=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userEdu.getEduId());
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
	
	public ResultSet fetchEdu(EntityBean entity) throws Exception{
		ResultSet rs = null;
		EduBean userEdu = (EduBean) entity;
		
		try {
			String sql = "SELECT * FROM education WHERE username=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, userEdu.getUsername());
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
	
	public ResultSet fetchEduEdit(EntityBean entity) throws Exception{
		ResultSet rs = null;
		EduBean userEdu = (EduBean) entity;
		
		try {
			String sql = "SELECT * FROM education WHERE eduId=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, userEdu.getEduId());
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
