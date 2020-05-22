package com.wallet.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.wallet.entity.Wallet;
import com.wallet.entity.WalletItem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.Test;





@RunWith(SpringRunner.Class)

@SpringBootTest

public class WalletItemRepositoryTest {

	private static final Date DATE = new Date();
	private static final String TYPE = "EN";
	private static final String DESCRIPTION = "Conta de Luz";
	private static final BigDecimal VALUE = BigDecimal.valueOf(65);
	
	
	@Autowired
	WalletItemRepositoryTest repositoy;
	@Autowired
	WalletRepository walletrepository;
	
	
	
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
