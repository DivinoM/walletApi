package com.wallet.service.Impl;

import com.wallet.entity.Wallet;
import com.wallet.repository.WalletReporsitory;
import com.wallet.service.WalletService;
import com.wallet.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletReporsitory repository;
	
	public Wallet save(Wallet w) {
		
		return repository.save(w);
	}
}
