package job.portal.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This is to create a connection to the database with the JDBC Driver.
 * @author Riyah
 *
 */

public abstract class DBDao {
	// method for create connection
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/abc_job_ad", "root", "R1295@snsd");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}
}
