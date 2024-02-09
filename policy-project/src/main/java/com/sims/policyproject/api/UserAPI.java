package com.sims.policyproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sims.policyproject.entity.User;
import com.sims.policyproject.exception.PolicyException;
import com.sims.policyproject.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000/")
@Validated
public class UserAPI {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/get/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username) throws PolicyException{
		
		User user = userService.getUser(username);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
