package de.adesso.beanvalidation.service;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.adesso.beanvalidation.model.User;
import de.adesso.beanvalidation.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRespository;

	@Override
	public List<User> getAllUsers() {
		return userRespository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRespository.findById(id).get();
	}

	@Override
	public User addUser(User user) {
		return userRespository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRespository.save(user);
	}

	public void deleteUser(Long id){
		userRespository.deleteById(id);
	}
}
