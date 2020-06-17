package com.mthree.controller;

import java.util.List;

import com.mthree.dto.TimothyBidOrderDTO;
import com.mthree.model.TimothyBidOrder;
import com.mthree.model.TimothyInstrument;
import com.mthree.services.TimothyService;



public class TimothyOrderBook {

	TimothyService timothyService;
	
	int instrumentId;
	
	TimothyInstrument timothyInstrument;
	
	List<TimothyBidOrder> bidOrders;
	
	public TimothyOrderBook(){}
	

	public TimothyOrderBook( int instrumentId, TimothyService timothyService) {
		super();
		this.instrumentId = instrumentId;
		System.out.println(timothyService);
		this.timothyService = timothyService;
		
		
		
		//get instrument obj
		if (timothyService.getInstrumentById(instrumentId).isPresent())
		setTimothyInstrument(
				timothyService.getInstrumentById(instrumentId).get()
				);
		
		//find Instrument bid orders
		System.out.println(timothyService.getBidOrdersByInstrument(timothyInstrument));
		setBidOrders(timothyService.getBidOrdersByInstrument(timothyInstrument)); //work but also getthe username and password
	
		
//		System.out.println(timothyService.getBidOrdersByInstrument2(timothyInstrument));
	
		System.out.println(timothyService.getBidOrdersByInstrument3(timothyInstrument).get(0));
		
		setTimothyBidOrderDTOs(timothyService.getBidOrdersByInstrument3(timothyInstrument)); 
		
	}

//	List<TimothyBidOrderDTO> timothyUserDTO;
	
	List<TimothyBidOrderDTO[]> timothyBidOrderDTOs;
	

	public synchronized List<TimothyBidOrderDTO[]> getTimothyBidOrderDTOs() {
		return timothyBidOrderDTOs;
	}


	public synchronized void setTimothyBidOrderDTOs(List<TimothyBidOrderDTO[]> timothyBidOrderDTOs) {
		this.timothyBidOrderDTOs = timothyBidOrderDTOs;
	}


	public synchronized List<TimothyBidOrder> getBidOrders() {
		return bidOrders;
	}


	public synchronized void setBidOrders(List<TimothyBidOrder> bidOrders) {
		this.bidOrders = bidOrders;
	}


	public synchronized TimothyService getTimothyService() {
		return timothyService;
	}


	public synchronized void setTimothyService(TimothyService timothyService) {
		this.timothyService = timothyService;
	}


	public synchronized int getInstrumentId() {
		return instrumentId;
	}


	public synchronized void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}


	public synchronized TimothyInstrument getTimothyInstrument() {
		return timothyInstrument;
	}


	public synchronized void setTimothyInstrument(TimothyInstrument timothyInstrument) {
		this.timothyInstrument = timothyInstrument;
	}
	
	
	
	
}
