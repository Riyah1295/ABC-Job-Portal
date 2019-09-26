package job.portal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import job.portal.bean.EntityBean;
import job.portal.bean.FriendsBean;
import job.portal.bean.UserBean;

/**
 * We can insert & delete user's friends.
 * We fetch the friends list based on the user that are currently login.
 * @author Riyah
 *
 */

public class FriendsDao extends DBDao implements Dao{

	@Override
	public int insert(EntityBean entity) throws SQLException, Exception {
		int i = 0;
		FriendsBean userFriends = (FriendsBean) entity;
		try {
			String sql = "INSERT INTO friends (username, friendsId, friendsName) VALUES (?, ?, ?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, userFriends.getUsername());
			ps.setInt(2, userFriends.getFriendsId());
			ps.setString(3, userFriends.getFriendsName());
			
			i = ps.executeUpdate();
			
			sql = "INSERT INTO friends (username, friendsId, friendsName) VALUES (?, ?, ?)";
			ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, userFriends.getFriendsName());
			ps.setInt(2, userFriends.getFriendsId());
			ps.setString(3, userFriends.getUsername());
			
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(EntityBean entity) throws SQLException, Exception {
		FriendsBean userFriends = (FriendsBean) entity;
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM friends WHERE friendsName=? AND username=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, userFriends.getFriendsName());
			ps.setString(2, userFriends.getUsername());
			i = ps.executeUpdate();
			
			sql = "DELETE FROM friends WHERE friendsName=? AND username=?";
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, userFriends.getUsername());
			ps.setString(2, userFriends.getFriendsName());
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
	
	public int deleteF(EntityBean entity, EntityBean entity2) throws SQLException, Exception {
		FriendsBean userFriends = (FriendsBean) entity;
		UserBean user = (UserBean) entity2;
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM friends WHERE friendsName=? AND username=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, userFriends.getFriendsName());
			ps.setString(2, user.getUsername());
			i = ps.executeUpdate();
			
			sql = "DELETE FROM friends WHERE friendsName=? AND username=?";
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, userFriends.getFriendsName());
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
	
	public ResultSet fetchFriends(EntityBean entity) throws Exception{
		ResultSet rs = null;
		UserBean user = (UserBean) entity;
		//FriendsBean userFriends = (FriendsBean) entity;
		
		try {
			String sql = "SELECT * FROM friends WHERE username=?";
			//String sql = "SELECT f.username, f.friendsId, CONCAT(u.firstName,' ',u.lastName) AS name, f.friendsName FROM user u, friends f WHERE u.username = f.username AND u.username = ?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			//ps.setString(2, user.getUsername());
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
	
	public static boolean checkFriends(EntityBean entity) throws Exception {
		boolean status = false;
		FriendsBean user = (FriendsBean) entity;
		
		try {
			String sql = "SELECT username, friendsName FROM friends WHERE username=? AND friendsName=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFriendsName());
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				if(rs.getString("username").equals(user.getUsername()) && rs.getString("friendsName").equals(user.getFriendsName())) {
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
}
