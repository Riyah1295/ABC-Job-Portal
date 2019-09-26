package job.portal.dao;
import java.sql.SQLException;

import job.portal.bean.EntityBean;

/**
 * It defines an abstract API that performs CRUD operations.
 * @author Riyah
 *
 */

public interface Dao {
	public int insert(EntityBean entity) throws SQLException, Exception;
	public int update(EntityBean entity) throws SQLException, Exception;
	public int delete(EntityBean entity) throws SQLException, Exception;
}
