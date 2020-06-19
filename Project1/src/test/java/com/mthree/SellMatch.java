package com.mthree;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
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
class SellMatch extends Project1ApplicationTests{

	@Autowired
	private SellRepository sell;
	
	
	@Test
	void testSellMatchDelete() {
		SellOrder s=new SellOrder();
		if(sell.deleterowfromsellorder(s.getSellId())==1)
			assertThat(sell.deleterowfromsellorder(s.getSellId())).isEqualTo(1);
		else
			assertThat(sell.deleterowfromsellorder(s.getSellId())).isEqualTo(0);
		
	}
	@Test
	void testSellMatchInsert() {
	Random rand=new Random();
	int id=rand.nextInt(10000);
	assertThat(sell.insertrowinsellorder(id,111,200)).isEqualTo(1);
	
		
	}

}
