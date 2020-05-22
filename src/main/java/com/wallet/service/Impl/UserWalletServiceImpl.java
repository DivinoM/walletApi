package com.wallet.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.entity.User;
import com.wallet.entity.UserWallet;
import com.wallet.repository.UserWalletRepository;
import com.wallet.service.UserService;

@Service
public class UserWalletServiceImpl  implements UserService {

	@Autowired
	UserWalletRepository repository;
	@Override
	public UserWallet save(UserWallet uw) {
		return repository.save(uw);
	}

	

}
