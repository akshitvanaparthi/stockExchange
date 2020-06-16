package com.mthree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.model.SellOrder;

@Repository
public interface SellRepository extends JpaRepository<SellOrder,Integer>
{
  
	@Query("SELECT new com.mthree.model.SellOrder(c.sellId, c.sellShares,c.ask) from SellOrder c")
	public List<SellOrder> findAll();
	
	
	
	@Query(value="SELECT s.sell_id,s.sell_shares,s.ask FROM sell_order s WHERE (s.ask<=:priceLimit) AND (s.sell_shares>=:noOfShares) ORDER BY s.ask LIMIT 1" ,nativeQuery = true)
	public SellOrder buyOrderMatch(@Param("noOfShares") int noOfShares,@Param("priceLimit") float priceLimit);
	
}
