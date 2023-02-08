package de.adesso.beanvalidation.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import de.adesso.beanvalidation.model.User;

@Repository
public class UserRepository {
	
	 static List<User> userList = new ArrayList<>();
		
		public List<User> getAllUsers(){
			return userList;
		}

		public User getUser(int id) {
	        Optional<User> first = userList.stream()
	                .filter(u -> u.getId()==id)
	                .findFirst();
	        if(first.isPresent()){
	            return first.get();
	        }else{
	            return new User();
	        }
		}
		
		public User addUser(User user) {
			userList.add(user);
			return user;
		}
		
		public User updateUser(User user) {
			for(User firstUser : userList) {
				if(firstUser.getId() == user.getId()) {
					firstUser.setName(user.getName());
					firstUser.setPassword(user.getPassword());
				}
			}
			
			return new User();
		}
		
		public User deleteUser(int id) {
			Optional<User> first = userList.stream()
					.filter(u -> u.getId() == id)
					.findFirst();
			if(first.isPresent()) {
				User user = first.get();
				userList.remove(user);
				return user;
			}
			else {
				return new User();
			}
	 	}

}
