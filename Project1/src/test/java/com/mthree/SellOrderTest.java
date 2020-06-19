package com.mthree;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.mthree.model.SellOrder;
import com.mthree.repositories.BuyerHistoryRepo;
import com.mthree.repositories.SellRepository;
import com.mthree.repositories.SellerHistoryRepo;
@SpringBootTest
class SellOrderTest extends Project1ApplicationTests{

	@Autowired
	private SellRepository sell;
	
	SellOrder sellorder;
	
	@Autowired
	private SellerHistoryRepo shistory;
	
	
	
	@Test
	@Transactional
	public void DeleteById() throws Exception{
		int count=shistory.sellhistCount();
        assertThat(shistory.count()).isEqualTo(count);
    }

}
