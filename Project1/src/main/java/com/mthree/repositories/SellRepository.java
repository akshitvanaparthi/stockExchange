package com.mthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.model.SellOrder;

@Repository
public interface SellRepository extends JpaRepository<SellOrder,Integer>{
  
	/*@Query("SELECT new com.mthree.model.SellOrder(c.sellId, c.sellShares,c.ask) from SellOrder c")
	public List<SellOrder> findAll();*/
	
	
	
}
