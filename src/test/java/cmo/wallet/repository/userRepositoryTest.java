package cmo.wallet.repository;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;
import com.wallet.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@RunWith(SpringRunner.Class)
@SpringBootTest
public class userRepositoryTest {
	
	private static final String EMAIL="email@teste.com";
	
	@Autowired
	UserRepository repository;
	
	@Before
	public void setUp() {
		User u =new User();
		u.setnome("setupUser");
		u.setpassword("senha123");
		u.setemail(EMAIL);
		
		repository.save(u);
		
	}
	
	@After
	public void tearDown() {
	  repository.deleteAll();
	}
	
	@test
	
	public void testesave() {
		User u= new User();
		u.setnome("Teste");
		u.setpassword("123456");
		u.setemail("teste@teste.com");
		
		User response = repository.save(u);
		assertNotNull(response);
	}
	public void testeFindByEmail() {
	 Optional<User> response = repository.findByEmalEquals(EMAIL);
	 assertTrue(response.isPresent());
	 assertEquals(response.get().getEmail(),EMAIL);
	 
	}
}
