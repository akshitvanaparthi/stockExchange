package com.mthree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.model.TimothyBidOrder;
import com.mthree.model.TimothyInstrument;
import com.mthree.model.TimothyOrderBook;
import com.mthree.services.TimothyService;

@RestController
public class TimothyRESTController {

	@Autowired
	TimothyService timothyService;
	
	@GetMapping("/instrument/{instrumentId}")
	public List<TimothyBidOrder> getOneOrderBook(@PathVariable int instrumentId){
		TimothyOrderBook orderBook = new TimothyOrderBook(1);
//		System.out.println(timothyService.getBidOrder());
		System.out.println(timothyService.getAllInstrument());
//		System.out.println(orderBook.getBidOrder());
//		System.out.println(ti.getBidOrder());
		return null;

	}
	
	
	
}
