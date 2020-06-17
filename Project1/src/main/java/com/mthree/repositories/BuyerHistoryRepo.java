package com.mthree.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.model.BuyerHistory;

@Repository
public interface BuyerHistoryRepo extends JpaRepository<BuyerHistory,Integer>
{
	@Modifying
	@Transactional
	@Query(value="INSERT into buyer_history (buyer_id,seller_id,volume,traded_price) VALUES (:buyerid,:sellerid,:shares,:ask)" ,nativeQuery = true)
	public void insertRowinBuyHistory(@Param("buyerid") int buyerid,@Param("sellerid") int sellerid, @Param("shares") int shares,@Param("ask") float ask);
	

}
