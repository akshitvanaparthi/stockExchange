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
	
	public Optional<User> loginUser(String username, String password){
		return userRepository.loginUser(username, password);

	}
	
	public User registerUser(User u) {
		return userRepository.save(u);
	}
	
	
	
	//*********************************************
	//SORT Implementation
	
	
	
	public SellOrder registerSellOrder(SellOrder e) 
	{

		return (SellOrder) sell.save(e);
	}
	
    public List<SellOrder> loadSell() 
    {		
    	return sell.findAll();
	}

    public BuyOrder registerBuyOrder(BuyOrder e) 
    {

		return (BuyOrder) buy.save(e);
	}
    
    public List<BuyOrder> loadBuy() 
    {		
    	return buy.findAll();
    }
 
    public List<OrderBook> loadOrders()
    {
    	return order.findAll();
    }

    public void registerOrder(OrderBook orders) {
        order.save(orders);
    }
    public List<OrderBook> loadValues() {		
		return order.getValues();
	}
	  /*  public List<BuyOrder> loadBuyValues(int buy_shares){
	    	return buy.getBuyValues(buy_shares);
	    }*/
    
    
    
    public List<SellOrder> buyOrderMatch(float priceLimit)
    {
		return sell.buyOrderMatch(priceLimit);

	}
    
    public List<BuyOrder> sellOrderMatch(float priceLimit)
    {
		return buy.sellOrderMatch(priceLimit);

	}
    
    
    
    
    public void deleterowfromsellorder(int sellerid)
    {
    	sell.deleterowfromsellorder(sellerid);
    }
    
    public void updaterowfromsellorder(int shares,int sellerid)
    {
    	sell.updaterowfromsellorder(shares,sellerid);
    }
    
    public void insertrowinbuyorder(int buyerid, float bid, int shares)
    {
    	buy.insertrowinbuyorder(buyerid,bid,shares);
    }
    
    
    
    public void deleterowfrombuyorder(int buyerid)
    {
    	buy.deleterowfrombuyorder(buyerid);
    }
    
    public void updaterowfrombuyorder(int shares,int buyerid)
    {
    	buy.updaterowfrombuyorder(shares,buyerid);
    }
    
    public void insertrowinsellorder(int sellerid, float ask, int shares)
    {
    	sell.insertrowinsellorder(sellerid,ask,shares);
    }
    
    
    
    
    //History
    
    public void buyerHistory(int buyerid,int sellerid,int shares, float ask )
    {
    	bhistory.insertRowinBuyHistory(buyerid,sellerid,shares,ask);
    }
    
    
    public void sellerHistory(int sellerid,int buyerid,int shares, float bid )
    {
    	shistory.insertRowinBuyHistory(sellerid,buyerid,shares,bid);
    }

    

    //cancel order
    public void deleterowbyid(int i) {
		 sell.deleteById(i);
	}

	public void deleterowbyid1(int i) {
		buy.deleteById(i);
	}

	public List<BuyerHistory> getAllBuyerHistory() {
		
		return bhistory.findAll();
	}
	public List<SellerHistory> getAllSellerHistory() {
		
		return shistory.findAll();
	}
	

}
