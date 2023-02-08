package de.adesso.beanvalidation.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import de.adesso.beanvalidation.model.User;
import de.adesso.beanvalidation.service.UserService;

@RestController
public class UserController {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

		@Autowired
		private UserService userService;

		    @GetMapping("/users")
		    public List<User> getAllUsers() {
			 LOGGER.info("getting users..");
		        return userService.getAllUsers();
		    }

		    @GetMapping("/user/{id}")
		    public User getUser(@PathVariable int id) {
		        return userService.getUser(id);
		    }

		    @PostMapping("/users")
		    @ResponseStatus(HttpStatus.CREATED)
		    public User addUser(@RequestBody @Valid User user) {
		        return userService.addUser(user);
		    }

		    @PutMapping("/user")
		    public User updateUser(@RequestBody @Valid User user) {
		        return userService.updateUser(user);
		    }

		    @DeleteMapping("/user/{id}")
		    public User deleteUser(@PathVariable int id) {
		        return userService.deleteUser(id);
		    }	

}
