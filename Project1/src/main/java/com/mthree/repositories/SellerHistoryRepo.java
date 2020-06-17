
package com.mthree.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.model.SellerHistory;

@Repository
public interface SellerHistoryRepo extends JpaRepository<SellerHistory,Integer> 
{
	@Modifying
	@Transactional
	@Query(value="INSERT into seller_history (seller_id,buyer_id,volume,traded_price) VALUES (:sellerid,:buyerid,:shares,:bid)" ,nativeQuery = true)
	public void insertRowinBuyHistory(@Param("sellerid") int sellerid,@Param("buyerid") int buyerid, @Param("shares") int shares,@Param("bid") float bid);

}

