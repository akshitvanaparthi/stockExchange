package com.mthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mthree.model.BuyOrderHistory;

public interface BuyOrderHistoryRepository extends JpaRepository<BuyOrderHistory, Integer> {
	

	
}
