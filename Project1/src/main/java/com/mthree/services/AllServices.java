package com.mthree.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.model.BuyOrder;
import com.mthree.model.OrderBook;
import com.mthree.model.SellOrder;
import com.mthree.model.User;
import com.mthree.repositories.BuyRepositary;
import com.mthree.repositories.OrderBookRepository;
import com.mthree.repositories.SellRepository;
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
	   

}
