package com.mthree.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mthree.repositories.TimothyAskOrderRepo;
import com.mthree.repositories.TimothyBidOrderRepo;
import com.mthree.repositories.TimothyInstrumentRepo;
import com.mthree.services.TimothyService;



public class TimothyOrderBook {

	int instrumentId;
	
	
	/*
	 * // not use this moment, still createing BidOrder // @Autowired //
	 * TimothyAskOrderRepo timothyAskOrderRepo;
	 */	
	
	//want to not use at all
	@Autowired
	TimothyService timothyService;
	
	
	TimothyInstrument timothyInstrument; 

	public TimothyOrderBook(int instrumentId) {
		super();
		this.instrumentId = instrumentId;
		System.out.println("search id: " + instrumentId);
		
		
//		if (timothyService.getInstrumentById(instrumentId).isPresent()) {
////			this.timothyInstrument = timothyInstrumentRepo.findById(instrumentId).get();
//		}
	}
	
	
	public List<TimothyBidOrder> getBidOrder() {
		System.out.println(timothyService.getAllInstrument());
		return null;
	}
			
		
//		if (timothyInstrumentRepo.findById(instrumentId).isPresent()) {
//			
//			System.out.println("got Instrument: " + timothyInstrumentRepo.findById(instrumentId).get());
//			timothyInstrument = timothyInstrumentRepo.findById(instrumentId).get();
//		}else {
//			System.err.println("cannot find that ins id");
//		}
//		if (timothyService.getInstrumentById(1).isPresent()) {
//			
//			System.out.println(timothyService.getInstrumentById(1).get());
//		}else {
//			System.out.println("faied to search that id");
//		}
	

	
	
	
	
	
	
	
	
	
	
	//setter and getter
	public synchronized TimothyInstrument getTimothyInstrument() {
		return timothyInstrument;
	}

	public synchronized void setTimothyInstrument(TimothyInstrument timothyInstrument) {
		this.timothyInstrument = timothyInstrument;
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

