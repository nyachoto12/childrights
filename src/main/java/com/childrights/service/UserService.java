/**
 * 
 */
package com.childrights.service;

import java.util.List;
import com.childrights.model.User;

public interface UserService {
	public List<User> getAllUser();
	void saveUser(User User);
	
	void deleteUserById(Long id);

    User findUserById(Long id);
}
