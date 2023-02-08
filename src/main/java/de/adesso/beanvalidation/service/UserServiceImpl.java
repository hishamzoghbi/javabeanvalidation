package de.adesso.beanvalidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.adesso.beanvalidation.model.User;
import de.adesso.beanvalidation.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRespository;

	@Override
	public List<User> getAllUsers() {
		return userRespository.getAllUsers();
	}

	@Override
	public User getUser(int id) {
		return userRespository.getUser(id);
	}

	@Override
	public User addUser(User user) {
		return userRespository.addUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userRespository.updateUser(user);
	}

	@Override
	public User deleteUser(int id) {
		return userRespository.deleteUser(id);
	}

}
