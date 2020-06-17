package com.mthree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.dto.TimothyAskOrderDTO;
import com.mthree.dto.TimothyBidOrderDTO;
import com.mthree.model.TimothyBidOrder;
import com.mthree.services.TimothyService;






@RestController
public class TimothyRESTController {

	@Autowired
	TimothyService timothyService;
	
	
	@GetMapping("/instrument/{instrumentId}")
	public List<TimothyBidOrder> getOneOrderBook(@PathVariable int instrumentId){
		TimothyOrderBook orderBook = new TimothyOrderBook(instrumentId,timothyService);
		return orderBook.getBidOrders();

	}
	
	
	@GetMapping("/instrumentDTO/bidOrders/{instrumentId}")
	public List<TimothyBidOrderDTO> getBidOrdersDTOs(@PathVariable int instrumentId){
		TimothyOrderBook orderBook = new TimothyOrderBook(instrumentId,timothyService);
		return orderBook.getTimothyBidOrderDTOs();
		
	}
	
	
	@GetMapping("/instrumentDTO/bidOrders/{instrumentId}")
	public List<TimothyAskOrderDTO> getAskOrdersDTOs(@PathVariable int instrumentId){
		TimothyOrderBook orderBook = new TimothyOrderBook(instrumentId,timothyService);
		return orderBook.getTimothyAskOrderDTOs();
		
	}
	
	


	
}
