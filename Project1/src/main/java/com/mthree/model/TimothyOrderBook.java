package com.mthree.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.repositories.TimothyAskOrderRepo;
import com.mthree.repositories.TimothyBidOrderRepo;
import com.mthree.services.TimothyService;



public class TimothyOrderBook {

	@Autowired
	TimothyAskOrderRepo timothyAskOrderRepo;
	
	@Autowired
	TimothyService timothyService;
//	@Autowired
//	TimothyBidOrderRepo timothyBidOrderRepo ;
	
//	@Autowired
//	TimothyBidOrderService timothyBidOrderService;
	
	int instrumentId;

	
	
	
	//TODO change this method name later, since it is only get that order 
	public List<TimothyBidOrder> getBidOrder() {
//		List<TimothyBidOrder>
		System.out.println("[timothyBidOrderRepo] finding all");
		
//		System.out.println(timothyBidOrderRepo.findAll());
		System.out.println(timothyService.getBidOrder());
//		System.out.println(timothyBidOrderRepo.findById(1));
//		System.out.println(timothyBidOrderService.getBidOrder());
//		System.out.println("[timothyBidOrderRepo] finding enddddddddd all");
//		return timothyBidOrderRepo.findAll();
		return null;
	}

	public TimothyOrderBook(int instrumentId) {
		super();
		this.instrumentId = instrumentId;
	}
	
	
	
}
//@Service
//class TimothyBidOrderService{
//	@Autowired
//	TimothyBidOrderRepo timothyBidOrderRepo ;
//	public List<TimothyBidOrder> getBidOrder() {
//		return timothyBidOrderRepo.findAll();
//	}
//	
//	
//	
//}

