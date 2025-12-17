package com.tcs.bank.service;

import org.springframework.stereotype.Service;

import com.tcs.bank.dto.RegisterRequest;
import com.tcs.bank.dto.UserResponse;
import com.tcs.bank.dto.LoginRequest;
@Service
public interface UserService {
    UserResponse register(RegisterRequest request);
    UserResponse login (LoginRequest request);
}
