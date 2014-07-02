package org.fabric8.angular.dao;

import org.fabric8.angular.dao.interfaces.UserDao;
import org.fabric8.angular.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SetupDatabase {
	
	private UserDao userDao;

	private PasswordEncoder passwordEncoder;
	
	protected SetupDatabase() {}
	
	public SetupDatabase(UserDao userDao, PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}
	
	public void initDB() {
		User userUser = new User("user", this.passwordEncoder.encode("user"));
		userUser.addRole("user");
		this.userDao.save(userUser);

		User adminUser = new User("admin", this.passwordEncoder.encode("admin"));
		adminUser.addRole("user");
		adminUser.addRole("admin");
		this.userDao.save(adminUser);
	}

}
