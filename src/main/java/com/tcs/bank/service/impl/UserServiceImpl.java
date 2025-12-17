package com.tcs.bank.service.impl;

import org.springframework.stereotype.Service;

import com.tcs.bank.dto.UserResponse;
import com.tcs.bank.entity.User;
import com.tcs.bank.exceptions.InvalidCredentialsException;
import com.tcs.bank.repository.UserRepository;
import com.tcs.bank.service.UserService;
import com.tcs.bank.dto.LoginRequest;
import com.tcs.bank.dto.RegisterRequest;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;
//	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public UserResponse register (RegisterRequest request) { 
		if (userRepository.existsByEmail(request.getEmail())) { 
			throw new RuntimeException("Email already registered!");
		}

	if (userRepository.existsByUsername(request.getUsername())) { 
		throw new RuntimeException("Username already taken!");
	}



	User user =new User();

//	user.setRole(request.getRole());

	user.setName(request.getName());

	user.setEmail(request.getEmail());

	user.setMobile(request.getMobile());

	user.setUsername(request.getUsername());

//	user.setPassword (passwordEncoder.encode(request.getPassword()));
	user.setPassword(request.getPassword());

	User saved = userRepository.save(user);

	return new UserResponse(
			saved.getId(), saved.getName(), saved.getEmail(), 

	saved.getUsername(), saved.getMobile());

	}


	@Override

	public UserResponse login (LoginRequest request) {

	User user = userRepository.findByUsername (
			request.getUsername()) .orElseThrow(()-> new InvalidCredentialsException("Invalid username or password"));

//	if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) { 
//	throw new RuntimeException("Invalid username or password!");
//	}
	
	if(request.getPassword().equals(user.getPassword())) {
		throw new  InvalidCredentialsException("Invalid username or password");
	}


	

	return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getUsername(), user.getMobile());
	
	}
	
}
