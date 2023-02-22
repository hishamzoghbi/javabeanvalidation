package de.adesso.beanvalidation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import de.adesso.beanvalidation.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import de.adesso.beanvalidation.model.User;
import de.adesso.beanvalidation.service.UserService;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	    @Autowired
		private UserServiceImpl userServiceImpl;
		    @GetMapping("/users")
		    public List<User> getAllUsers() {
			 LOGGER.info("getting users..");
		        return userServiceImpl.getAllUsers();
		    }
		    @GetMapping("/user/{id}")
		    public User getUser(@PathVariable("id") Long id) {
		        return userServiceImpl.getUserById(id);
		    }

		    @PostMapping("/user")
		    public User addUser(@RequestBody User user) {
		        return userServiceImpl.addUser(user);
		    }

		    @PutMapping("/user")
		    public User updateUser(@RequestBody User user) {
		        return userServiceImpl.updateUser(user);
		    }

		    @DeleteMapping("/user/{id}")
		    public void deleteUser(@PathVariable("id") Long id) {
				userServiceImpl.deleteUser(id);
			}

}
