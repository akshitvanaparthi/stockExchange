package com.mthree.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mthree.model.BuyOrder;
import com.mthree.model.BuyOrderHistory;
import com.mthree.model.OrderBook;
import com.mthree.model.SellOrder;
import com.mthree.model.User;
import com.mthree.services.AllServices;

@RestController
@RequestMapping
public class AllController 
{
	
     @Autowired
	public AllServices services;
     
     
     
  // ---- [ Login ] ---
 	//redirect index page
 	@GetMapping("/")
 	public ModelAndView showIndex(HttpServletRequest r) {
 		// Desc: return index page
 		
 		if (r.getSession().getAttribute("username") == null) {
 			return new ModelAndView("login");
 		}
 		return new ModelAndView("index");
 	}
 	
 	
 	@GetMapping("/login")
 	public ModelAndView showLoginPage(HttpServletRequest r) {
 		//Desc: display login page
 		
 		//if set username sessino, then redirect them to index page
 		if (r.getSession().getAttribute("username") != null) {
 			return new ModelAndView("index");
 		}
 		//create a session
 		r.getSession(true);
 		return new ModelAndView("login");
 	}


 	
 	
 	@GetMapping("/logout")
 	public ModelAndView logoutUser(HttpServletRequest r) {
 		//Desc: logout user
 		
 		//clear all session data
 		r.getSession().invalidate();
 		return new ModelAndView("login"); 
 	}
 	
 	
 	@PostMapping("/login")
 	public ModelAndView loginUser(HttpServletRequest r,
 			@RequestParam("username") String username,
 			@RequestParam("password") String password){
 		//Desc: process login POST request from login page

 		//if set username sessino, then redirect them to index page
 		if (r.getSession().getAttribute("username") != null) {
 			return new ModelAndView("index");
 		}
 		
 		
 		//		System.out.println(username);
 		//		System.out.println(password);

 		Optional<User> u = services.loginUser(username, password);
 		if (u.isPresent()) {
 			System.out.println("[O] /login: " + u.get());
 			
 			//add value to session, so user no need to login anymore
 			
 			
 			r.getSession().setAttribute("username",u.get().getUsername());
 			r.getSession().setAttribute("id",u.get().getId());
 			
 			return new ModelAndView("index");
 		}else {
 			//TODO:return error msg to user show them their username and password is incorrect
 			System.out.println("[X] /login: username or password incorrect");
 			return new ModelAndView("login");
 		}
 		
 		
 	}
 	
 	
 	// --- [ register ] -------------
 	@GetMapping("/register")
 	public ModelAndView showRegisterPage() {
 		return new ModelAndView ("register");
 	}
 	
 	
 	
 	@PostMapping("/register")
 	public ModelAndView registerUser(
 			@RequestParam("username") String username,
 			@RequestParam("password") String password) {
 			
 		
 		//Desc: register new user from register page
 		
 		
 		//TODO: add validation later
 		User u = new User(username, password); // this dont have user id
 		User new_u = services.registerUser(u);// this has a user id
 		
// 		System.out.println(new_u);//debug
 		if (new_u.getId() != 0) {
 			return new ModelAndView("index");
 		}else {
 			//TODO: may return what wrongs in the from to user
 			return new ModelAndView("register");
 		}
 		
 	} 
     
 	
 	
   //*********************************************************//  
   // SORT IMPLEMENTATION
     
     
     
 
	
 
     
     
     
     @GetMapping("/getOrderBook")
     public ModelAndView getOrders()
     {
    	 
    	 
    	List<OrderBook> orderBookList = services.loadOrders();
  		
  		ModelAndView mv = new ModelAndView();
  		
  		if(orderBookList.size()>0) {
  		
  		mv.setViewName("orderBook_list");
  		mv.addObject("orderBookList", orderBookList);
  			
  		}
  		else {
  			mv.setViewName("empty");
  		}
  		
  		return mv;
     }
 	
     @GetMapping("/buyOrderOpen")
  	public ModelAndView buyOrderOpen() 
     {
  		
  		return new ModelAndView("buyOrderPage"); 
  	}
     
     
     /*
     //testing POST request with /performBuyMatch","/performAskMatch","/performCancelMatch 
     @PostMapping({"/performBuyMatch","/performAskMatch","/performCancelMatch"})
     public ModelAndView testPostRequest(HttpServletRequest r,
   			@RequestParam("noOfShares") String noOfShares,
   			@RequestParam("priceLimit") String priceLimit) {
    	 	
    	 System.out.printf("noOfShares: %s, priceLimit: %s\n", noOfShares, priceLimit);
    	 	
    	 	
    	 	
	 	//test only: in case you want to redirect to other page,
    	 // you should return sth else here
    	 return new ModelAndView("success");   
     }
     */
     
     public ArrayList<SellOrder> sharesLoop(int shares,float priceLimit)
     {
	   	  //int shareValue=0;
	      List<SellOrder> sharesList= services.buyOrderMatch(priceLimit);
	      
	      ArrayList<SellOrder> matchedList=new ArrayList<SellOrder>();
	      
	  	  for(int i=0;i<sharesList.size();i++)
	  	  {
				if(shares==sharesList.get(i).getSellShares())
				{
					matchedList.add(new SellOrder(sharesList.get(i).getSellId(),sharesList.get(i).getSellShares(),sharesList.get(i).getAsk()));
					break;
				}
				else if(shares>sharesList.get(i).getSellShares())
				{
			        shares=shares-sharesList.get(i).getSellShares();
			        matchedList.add(new SellOrder(sharesList.get(i).getSellId(),sharesList.get(i).getSellShares(),sharesList.get(i).getAsk()));
			        
				}
				else
				{
					matchedList.add(new SellOrder(sharesList.get(i).getSellId(),shares,sharesList.get(i).getAsk()));
					break;
				}
		
	  	  }
	  	  return matchedList;
  	 }
     
  
     @PostMapping("/performBuyMatch")
  	public ModelAndView buyOrderMatch(HttpServletRequest r,
  			@RequestParam("noOfShares") String noOfShares1,
  			@RequestParam("priceLimit") String priceLimit1)
     {
    	 int noOfShares = Integer.parseInt(noOfShares1);
    	 float priceLimit = Integer.parseInt(priceLimit1);
    	 
    	 Random rand = new Random();
    	 
    	int buyerId = rand.nextInt(10000);
    	
    	ArrayList<SellOrder> matchedSellOrder=sharesLoop(noOfShares,priceLimit);
    	
  		//SellOrder matchedSellOrder = services.buyOrderMatch(noOfShares, priceLimit);
  		//System.out.println("hello");
    	
  		ModelAndView mv = new ModelAndView();
  		if(matchedSellOrder.size() > 0) 
  		{
  			
  			BuyOrder matchedBuyOrder=new BuyOrder(buyerId,noOfShares,priceLimit);
  			
  			
  			mv.setViewName("matched_order");
  			mv.addObject("matchedSellOrder", matchedSellOrder);
  			mv.addObject("matchedBuyOrder", matchedBuyOrder);
  				
		}
		else 
		{
			mv.setViewName("empty");	
		}
  			
		
		return mv;
		
  		
  	}
     
     
     
     
     @GetMapping("/getsellorders")
  	public List<SellOrder> getSell()
     {
    	 System.out.println(services.loadSell());
     	return services.loadSell();
  	 }
     
     
     
     
     @GetMapping("/getbuyorders")
   	public List<BuyOrder> getbuy(){
    	 System.out.println(services.loadBuy());
   		return services.loadBuy();
   	} 
      
    
 	@GetMapping("/orders")
    public List<OrderBook> getValues()
    {
        return services.loadValues();
    }
    
   
 	
   /* @PostMapping("/getBuyValues")
    public List<BuyOrder> getBuyValues(int buy_shares){
	    return services.loadBuyValues(buy_shares);
     }*/
     
 	
	//*********************************************
	//Show Buy Order History record
 	
 	@GetMapping("/getAllBuyOrderHistory")
 	public List<BuyOrderHistory> getAllBuyOrderHistory() {
 		return services.getAllBuyOrderHistory();
 	}
 	
    
}
