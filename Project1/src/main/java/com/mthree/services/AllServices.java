package com.mthree.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.model.BuyOrder;
import com.mthree.model.BuyerHistory;
import com.mthree.model.OrderBook;
import com.mthree.model.SellOrder;
import com.mthree.model.SellerHistory;
import com.mthree.model.User;
import com.mthree.repositories.BuyRepositary;
import com.mthree.repositories.BuyerHistoryRepo;
import com.mthree.repositories.OrderBookRepository;
import com.mthree.repositories.SellRepository;
import com.mthree.repositories.SellerHistoryRepo;
import com.mthree.repositories.UserRepository;

/**
 * Service layer which acts as bridge between Controller and Repositories
 * 
 * @author Akshit
 * @author Sahithi
 *
 */

@Service
public class AllServices 
{
	
	@Autowired
	private SellRepository sell;
	
	@Autowired
	private BuyRepositary buy;
	
	@Autowired
	private OrderBookRepository order;
	
	
	@Autowired
	private BuyerHistoryRepo bhistory;
	
	@Autowired
	private SellerHistoryRepo shistory;
	
	
	
	//**********************************
	// Login and Registration
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return login user details
	 */
	
	public Optional<User> loginUser(String username, String password){
		return userRepository.loginUser(username, password);

	}
	
	/**
	 * To insert User details into database
	 * @param u User
	 * @return User
	 */
	public User registerUser(User u) {
		return userRepository.save(u);
	}
	
	
	
	//*********************************************
	//SORT Implementation
	
	/**
	 * To insert sell order details
	 * @param e SellOrder
	 * @return SellOrder
	 */
	
	public SellOrder registerSellOrder(SellOrder e) 
	{

		return (SellOrder) sell.save(e);
	}
	
	/**
	 * 
	 * @return List<SellOrder>
	 */
    public List<SellOrder> loadSell() 
    {		
    	return sell.findAll();
	}

    /**
     * Insert buyorder list
     * @param e BuyOrder
     * @return BuyOrder
     */
    public BuyOrder registerBuyOrder(BuyOrder e) 
    {

		return (BuyOrder) buy.save(e);
	}
    
    
    /**
     * 
     * @return List<BuyOrder>
     */
    public List<BuyOrder> loadBuy() 
    {		
    	return buy.findAll();
    }
 
    /**
     * 
     * @return List<OrderBook>
     */
    public List<OrderBook> loadOrders()
    {
    	return order.findAll();
    }

    /**
     * Insert orders
     * @param orders
     */
    public void registerOrder(OrderBook orders) {
        order.save(orders);
    }
    /**
     * 
     * @return List<OrderBook>
     */
    public List<OrderBook> loadValues() {		
		return order.getValues();
	}
	  /*  public List<BuyOrder> loadBuyValues(int buy_shares){
	    	return buy.getBuyValues(buy_shares);
	    }*/
    
    /**
     * 
     * @param priceLimit
     * @return List<SellOrder>
     */
    
    public List<SellOrder> buyOrderMatch(float priceLimit)
    {
		return sell.buyOrderMatch(priceLimit);

	}
    
    /**
     * 
     * @param priceLimit
     * @return List<BuyOrder>
     */
    public List<BuyOrder> sellOrderMatch(float priceLimit)
    {
		return buy.sellOrderMatch(priceLimit);

	}
    
    
    /**
     * To delete a row from sell order
     * @param sellerid
     */
    
    public void deleterowfromsellorder(int sellerid)
    {
    	sell.deleterowfromsellorder(sellerid);
    }
    /**
     * Update sell order row
     * @param shares
     * @param sellerid
     */
    public void updaterowfromsellorder(int shares,int sellerid)
    {
    	sell.updaterowfromsellorder(shares,sellerid);
    }
    
    /**
     * Insert a new record in BuyOrder Table
     * @param buyerid
     * @param bid
     * @param shares
     */
    public void insertrowinbuyorder(int buyerid, float bid, int shares)
    {
    	buy.insertrowinbuyorder(buyerid,bid,shares);
    }
    
    
    /**
     * Delete a row from buy order
     * @param buyerid
     */
    public void deleterowfrombuyorder(int buyerid)
    {
    	buy.deleterowfrombuyorder(buyerid);
    }
    
    /**
     * Update a row from buy order
     * @param shares
     * @param buyerid
     */
    public void updaterowfrombuyorder(int shares,int buyerid)
    {
    	buy.updaterowfrombuyorder(shares,buyerid);
    }
    
    
    /**
     * Insert a row in sell order table
     * @param sellerid
     * @param ask
     * @param shares
     */
    public void insertrowinsellorder(int sellerid, float ask, int shares)
    {
    	sell.insertrowinsellorder(sellerid,ask,shares);
    }
    
    
    
    
    /**
     * Insert record in buy History
     * @param buyerid
     * @param sellerid
     * @param shares
     * @param ask
     */
    
    public void buyerHistory(int buyerid,int sellerid,int shares, float ask )
    {
    	bhistory.insertRowinBuyHistory(buyerid,sellerid,shares,ask);
    }
    
    /**
     * Insert row in seller history table
     * @param sellerid
     * @param buyerid
     * @param shares
     * @param bid
     */
    public void sellerHistory(int sellerid,int buyerid,int shares, float bid )
    {
    	shistory.insertRowinBuyHistory(sellerid,buyerid,shares,bid);
    }

    

    /**
     * delete a row by id
     * @param i
     */
    public void deleterowbyid(int i) {
		 sell.deleteById(i);
	}
    /**
     * Delete a row by id
     * @param i
     */
	public void deleterowbyid1(int i) {
		buy.deleteById(i);
	}
	
	/**
	 * 
	 * @return List<BuyerHistory>
	 */
	public List<BuyerHistory> getAllBuyerHistory() {
		
		return bhistory.findAll();
	}
	/**
	 * 
	 * @return List<SellerHistory>
	 */
	public List<SellerHistory> getAllSellerHistory() {
		
		return shistory.findAll();
	}
	
	
	
	

}
