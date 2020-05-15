package com.wallet.service.Impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.wallet.entity.User;
import com.wallet.repository.UserRepository;

import com.wallet.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@AutoWride
	UserRepository repository;
	
	@Override
	public User save(User u) {
		// TODO Auto-generated method stub
		return repository.save(u);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmalEquals(email);
	}

}
