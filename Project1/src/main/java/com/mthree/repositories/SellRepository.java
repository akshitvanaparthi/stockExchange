package com.mthree.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.model.SellOrder;

@Repository
public interface SellRepository extends JpaRepository<SellOrder,Integer>
{
  
	@Query("SELECT new com.mthree.model.SellOrder(c.sellId, c.sellShares,c.ask) from SellOrder c")
	public List<SellOrder> findAll();
	
	
	
	@Query(value="SELECT s.sell_id,s.sell_shares,s.ask FROM sell_order s WHERE s.ask<=:priceLimit AND s.sell_shares is NOT NULL ORDER BY s.ask" ,nativeQuery = true)
	public List<SellOrder> buyOrderMatch(@Param("priceLimit") float priceLimit);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM sell_order WHERE sell_id=:sellerid" ,nativeQuery = true)
	public void deleterowfromsellorder(@Param("sellerid") int sellerid);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE sell_order s SET s.sell_shares=:shares WHERE s.sell_id=:sellerid" ,nativeQuery = true)
	public void updaterowfromsellorder(@Param("shares") int shares,@Param("sellerid") int sellerid);
	
	
	@Modifying
	@Transactional
	@Query(value="INSERT into sell_order (sell_id,ask,sell_shares) VALUES (:sellerid,:ask,:shares)" ,nativeQuery = true)
	public void insertrowinsellorder(@Param("sellerid") int sellerid,@Param("ask") float ask, @Param("shares") int shares);
	
	
}
