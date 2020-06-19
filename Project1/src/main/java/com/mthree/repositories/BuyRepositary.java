package com.mthree.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.model.BuyOrder;

/**
 * Repository for Buy Order table
 * 
 * @author Sahithi
 * @author Saikumar
 * @author Akshit
 *
 */

@Repository
public interface BuyRepositary extends JpaRepository<BuyOrder,Integer>{
  
	
	/**
	 * Select records from BuyOrder
	 */
	@Query("SELECT new com.mthree.model.BuyOrder(c.buyId, c.buyShares,c.bid) from BuyOrder c")
	public List<BuyOrder> findAll();
	
	/**
	 * 
	 * @param priceLimit
	 * @return  List<BuyOrder>
	 */
	@Query(value="SELECT * FROM buy_order s WHERE s.bid>=:priceLimit AND s.buy_shares is NOT NULL ORDER BY s.bid DESC" ,nativeQuery = true)
	public List<BuyOrder> sellOrderMatch(@Param("priceLimit") float priceLimit);
	
	/*@Query("SELECT new com.mthree.dto.OrderBookDTO"
	+ "(e.buyId,e.buyShares,e.bid, u.sellId,u.sellShares,u.ask) from BuyOrder e full join SellOrder u where e.buyId=u.sellId")
	public List<OrderBook> getAllUsersByEventId();*/

	/**
	 * 
	 * @param buy_shares
	 * @return List<BuyOrder>
	 */
	@Query(value="SELECT * FROM buy_order WHERE buy_shares=:buy_shares AND buy_shares is NOT NULL  LIMIT 1"
			,nativeQuery = true)
	public List<BuyOrder> getBuyValues(@Param("buy_shares") int buy_shares);
	
	/**
	 * Insert into a Buy Order table
	 * @param buyerid
	 * @param bid
	 * @param shares
	 */
	
	@Modifying
	@Transactional
	@Query(value="INSERT into buy_order (buy_id,bid,buy_shares) VALUES (:buyerid,:bid,:shares)" ,nativeQuery = true)
	public void insertrowinbuyorder(@Param("buyerid") int buyerid,@Param("bid") float bid, @Param("shares") int shares);
	
	
	/**
	 * Delete records from buy order table
	 * @param buyerid
	 */
	@Modifying
	@Transactional
	@Query(value="DELETE FROM buy_order WHERE buy_id=:buyerid" ,nativeQuery = true)
	public void deleterowfrombuyorder(@Param("buyerid") int buyerid);
	/**
	 * Update a record from Buy order table
	 * @param shares
	 * @param buyerid
	 */
	@Modifying
	@Transactional
	@Query(value="UPDATE buy_order b SET b.buy_shares=:shares WHERE b.buy_id=:buyerid" ,nativeQuery = true)
	public void updaterowfrombuyorder(@Param("shares") int shares,@Param("buyerid") int buyerid);
	
	

	
	
	
}
