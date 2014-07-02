package org.fabric8.angular.dao.interfaces;

import org.fabric8.angular.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDao extends Dao<User, Long>, UserDetailsService {
	
	User findByName(String name);

}
