package com.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.entity.Wallet;

public interface WalletReporsitory extends JpaRepository<Wallet, Long> {

}
