package com.wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wallet.entity.User;

public interface UserRepository extends jpaRepository<User,Long> {

Optional<User> findByEmalEquals(String email);

void deleteAll();

User save(User u);

}
