package com.wallet.service;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;
import com.wallet.repository.UserRepository;


@Runwith@SpringRunner.Class)
@SpringBootTest
@ActiveProfile("test")
public class UserServiceTest {
	
	@MockBean
	UserRepository repository;

	@Autowired
	UserService service;
	
	@Before
	
	public void setUp() {
		BDDMockito.given(repository.findByEmalEquals(Mockito.anyString())).willReturn(Optional.of(new User()));
	}
	
	public void testFindByEmail() {
		Optional<User> user = service.findByEmail("email@teste.com");
		assertTrue(user.isPresent());
		
		
	}

	private void AssertTrue(boolean present) {
		// TODO Auto-generated method stub
		
	}
}
