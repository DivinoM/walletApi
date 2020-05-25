package com.wallet.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.wallet.entity.Wallet;
import com.wallet.entity.WalletItem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;

import javax.validation.ConstraintViolation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;





@RunWith(SpringRunner.Class)

@SpringBootTest

public class WalletItemRepositoryTest {

	private static final Date DATE = new Date();
	private static final String TYPE = "EN";
	private static final String DESCRIPTION = "Conta de Luz";
	private static final BigDecimal VALUE = BigDecimal.valueOf(65);
	private Long saveWalletItemId;
	private Long saveWalletid;
	
	
	@Autowired
	WalletItemRepositoryTest repository;
	@Autowired
	WalletRepository walletrepository;
	
	
	@Before
	public void setUp() {
		Wallet w = new Wallet();
		w.setName ("Carteira teste");
		w.setvalue(BigDecimal.valueOf(250));
		walletrepository.save(w);
		
	    WalletItem wi =new WalletItem(1L,w, DATE, TYPE,DESCRIPTION,VALUE);
		
		WalletItem response = repository.save(wi);
		
		saveWalletItemId = wi.getId();
		saveWalletid = w.getId();
		
	}
	@After
	public void tearDown() {
		repository.deleteAll();
		walletrepository.deleteAll();
	}
	
	@Test(expected = ConstraintViolation.Class)
	public void testInvalidaWalletItem() {
		 WalletItem wi =new WalletItem(null,null, DATE, null,DESCRIPTION,null);
		 repository.save(wi);
	}
	
	@Test
	public void testUpdate() {
		Optional<WalletItem> wi = repository.findById(saveWalletitemId);
		
		String desciption = "Descrição Alterada";
		
		WalletItem change =wi.get();
		change.setDescription(description);
		
		repository.save(change);
		
		Optional<WalletItem> newWalletItem = repository.findById(saveWalletitemId);
		 assertEquals(desciption,newWalletItem.get().getDescription());
	}
	
	
	@Test
	public void deletewalletItem() {
		Optional<WalletItem> wi = repository.findById(saveWalletitemId);
		WalletItem wi =new WalletItem(null,wallet.get(), DATE, TYPE,DESCRIPTION,VALUE);
		repository.save(wi);
		
		repository.deleteById(wi.getId());
		
		
		
		Optional<WalletItem> newWalletItem = repository.findById(wi.getId());
	
		assertFalse(response.IsPresent());
		
	}
	
	@Test
	public void testSave() {
		
		Wallet w =new Wallet();
		w.setName(BigDecimal.valueOf(500));
		walletrepository.save(w);
		WalletItem wi =new WalletItem(1L,w, DATE, TYPE,DESCRIPTION,VALUE);
		
		WalletItem response = repositoy.save(wi);
		
		assertNotNull(response);
		assertEquals(response.getDescription(),DESCRIPTION);
		assertEquals(response.getTYpe(),TYPE);
		assertEquals(response.getValue(),VALUE);
		assertEquals(response.getWallet().getId(),w.getId());
		
	}
}
