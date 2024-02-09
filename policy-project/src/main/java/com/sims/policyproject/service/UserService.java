package com.sims.policyproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sims.policyproject.entity.User;
import com.sims.policyproject.exception.PolicyException;
import com.sims.policyproject.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getUser(String username) throws PolicyException {

		Optional<User> optionalUser = userRepository.findById(username);
		if(optionalUser.isEmpty()){
			throw new PolicyException("userService.USER_NOT_FOUND");
		}
		User user = optionalUser.get();
		
		return user;
	}
}
