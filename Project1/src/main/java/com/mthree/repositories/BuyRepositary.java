package com.mthree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.model.BuyOrder;


@Repository
public interface BuyRepositary extends JpaRepository<BuyOrder,Integer>{
  
	@Query("SELECT new com.mthree.model.BuyOrder(c.buyId, c.buyShares,c.bid) from BuyOrder c")
	public List<BuyOrder> findAll();
	
	/*@Query("SELECT new com.mthree.dto.OrderBookDTO"
	+ "(e.buyId,e.buyShares,e.bid, u.sellId,u.sellShares,u.ask) from BuyOrder e full join SellOrder u where e.buyId=u.sellId")
	public List<OrderBook> getAllUsersByEventId();*/

	@Query(value="SELECT * FROM buy_order WHERE buy_shares=:buy_shares AND buy_shares is NOT NULL  LIMIT 1"
			,nativeQuery = true)
	public List<BuyOrder> getBuyValues(@Param("buy_shares") int buy_shares);
	

}
