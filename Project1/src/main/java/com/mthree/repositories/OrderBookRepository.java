package com.mthree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mthree.model.OrderBook;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook,Integer>{
  
	@Query("SELECT new com.mthree.model.OrderBook(c.orderId, c.buyShares,c.bidPrice,c.askPrice,c.sellShares) from OrderBook c")
	public List<OrderBook> findAll();
	
	@Query(value="SELECT * FROM order_book WHERE bid_price<=ask_price AND sell_shares is NOT NULL ORDER BY bid_price DESC LIMIT 1"
			,nativeQuery = true)
	public List<OrderBook> getValues();
	
	
	
	/*@Query(value = "SELECT * FROM bookings bs WHERE " +
            "EXISTS (SELECT 1 FROM customer c WHERE bs.customer_id = c.id AND c.phone = :phone) " +
            "AND EXISTS (SELECT 1 FROM books b WHERE b.id = bs.book_id AND b.author IN :authors)",
            nativeQuery = true)
   public List<OrderBook> find();*/
	
	/*@Query(value = "SELECT * INTO [OrderBook] FROM  (SELECT * FROM BuyOrder UNION SELECT * FROM SellOrder)",
            nativeQuery = true)
   public List<OrderBook> find();*/
	
	/*@Query("SELECT new com.mthree.model.SellOrder(u.orderId,u.sellId,u.sellShares,u.ask) from OrderBook e inner join e.sellorder u ON e.orderId=u.orderId")
	public List<SellOrder> getAllUsersByEventId();*/

	
	
}
