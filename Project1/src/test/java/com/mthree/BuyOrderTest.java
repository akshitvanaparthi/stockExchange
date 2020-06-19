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

import com.mthree.model.BuyOrder;
import com.mthree.model.SellOrder;
import com.mthree.repositories.BuyRepositary;
import com.mthree.repositories.BuyerHistoryRepo;
import com.mthree.repositories.SellRepository;
@SpringBootTest
class BuyOrderTest extends Project1ApplicationTests{

	
	@Autowired
	private BuyRepositary buy;
	
	BuyOrder buyorder;
	
	@Autowired
	private BuyerHistoryRepo bhistory;
	
	
	
	@Test
	@Transactional
	public void DeleteById()  throws Exception{
		int count=bhistory.buyhistCount();
        assertThat(bhistory.count()).isEqualTo(count);

    }

}
