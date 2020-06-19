package com.mthree;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mthree.model.BuyOrder;
import com.mthree.model.SellOrder;
import com.mthree.repositories.BuyRepositary;
import com.mthree.repositories.SellRepository;
@SpringBootTest
class BuyMatch {

	@Autowired
	private BuyRepositary buy;
	
	
	@Test
	void testBuyMatchDelete() {
		BuyOrder s=new BuyOrder();
		if(buy.deleterowfrombuyorder(s.getBuyId())==1)
			assertThat(buy.deleterowfrombuyorder(s.getBuyId())).isEqualTo(1);
		else
			assertThat(buy.deleterowfrombuyorder(s.getBuyId())).isEqualTo(0);
		
	}
	@Test
	void testSellMatchInsert() {
	Random rand=new Random();
	int id=rand.nextInt(10000);
	assertThat(buy.insertrowinbuyorder(id,111,200)).isEqualTo(1);
	
		
	}


}
