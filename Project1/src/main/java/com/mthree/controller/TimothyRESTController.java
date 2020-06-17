package com.mthree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.dto.TimothyBidOrderDTO;
import com.mthree.model.TimothyBidOrder;
import com.mthree.services.TimothyService;






@RestController
public class TimothyRESTController {

	@Autowired
	TimothyService timothyService;
	
	
	@GetMapping("/instrument/{instrumentId}")
	public List<TimothyBidOrder> getOneOrderBook(@PathVariable int instrumentId){
//		System.out.println(timothyService);
//		System.out.println(timothyService.getAllInstrument());
//		System.out.println(timothyService.getInstrumentById(1).get());
		
		TimothyOrderBook orderBook = new TimothyOrderBook(instrumentId,timothyService);
		return orderBook.getBidOrders();
//		return null;

	}
	
	
	@GetMapping("/instrumentDTO/{instrumentId}")
	public List<TimothyBidOrderDTO[]> getOneOrderBookDTO(@PathVariable int instrumentId){
		TimothyOrderBook orderBook = new TimothyOrderBook(instrumentId,timothyService);
		return orderBook.getTimothyBidOrderDTOs();
//		return null;
		
	}
	
	


	
}
