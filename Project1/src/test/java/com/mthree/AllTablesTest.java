package com.mthree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.mthree.model.BuyOrder;
import com.mthree.model.BuyerHistory;
import com.mthree.model.SellOrder;
import com.mthree.model.SellerHistory;
import com.mthree.repositories.BuyRepositary;
import com.mthree.repositories.BuyerHistoryRepo;
import com.mthree.repositories.SellRepository;
import com.mthree.repositories.SellerHistoryRepo;

@SpringBootTest
class AllTablesTest  extends Project1ApplicationTests{


	@Autowired
	private BuyRepositary buy;

	@Autowired
	private SellRepository sell;

	@Autowired
	private BuyerHistoryRepo bhistory;

	@Autowired
	private SellerHistoryRepo shistory;
	
	Random rand = new Random(); 
	int shares=rand.nextInt(1000);
	int price=rand.nextInt(1000);
	
	@Test
	void BuyerTable() {
		int shares=rand.nextInt(1000);
		int price=rand.nextInt(1000);
		int Id = rand.nextInt(10000);
		BuyOrder a=new BuyOrder(Id,shares,price);
		buy.save(a);
	}
	@Test
	void SellerTable() {
		int shares=rand.nextInt(1000);
		int price=rand.nextInt(1000);
		int Id = rand.nextInt(10000);
		SellOrder b=new SellOrder(Id,shares,price);
		sell.save(b);
	}
	
}
