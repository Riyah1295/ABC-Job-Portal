package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import job.portal.dao.UserDao;
import job.portal.bean.UserBean;

/**
 * This is a unit testing test.
 * It is to check if the validation works accordingly for the functions created.
 * @author Riyah
 *
 */

class UserTest {
	
	static UserBean userBean = new UserBean();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		userBean.setUsername("erza");
		userBean.setPassword("erza");
		userBean.setEmail("erza@gmail.com");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void checkUsername() throws Exception {
		assertTrue(UserDao.checkUsername(userBean));
	}
	
	@Test
	void checkEmail() throws Exception {
		assertTrue(UserDao.checkEmail(userBean));
	}
	
	@Test
	void checkLogin() throws Exception {
		assertTrue(UserDao.checkLogin(userBean));
	}
}
