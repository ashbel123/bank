package com.tcs.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.bank.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
