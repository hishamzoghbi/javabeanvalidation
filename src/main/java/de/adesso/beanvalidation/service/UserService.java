package de.adesso.beanvalidation.service;

import java.util.List;
import java.util.Optional;

import de.adesso.beanvalidation.model.User;

public interface UserService {
    List<User> getAllUsers();
	
	User getUserById(Long id);
	
	User addUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(Long id);

}
