/* 
 * 
 * 
 * This Instrument class is Testing purpose
 * 
 * */

package com.mthree.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TimothyInstrument {

	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int instrumentId;
	
	private String name;

	@OneToMany(mappedBy = "instrument")
	private List<TimothyBidOrder> bidOrders;
	
	@OneToMany(mappedBy = "instrument")
	private List<TimothyAskOrder> askOrders;

	
	double currentStockPrice;
	
	// constructor
	
	public TimothyInstrument() {}

	
	
	
	
	
	public TimothyInstrument(int instrumentId, String name, List<TimothyBidOrder> bidOrders,
			List<TimothyAskOrder> askOrders, double currentStockPrice) {
		super();
		this.instrumentId = instrumentId;
		this.name = name;
		this.bidOrders = bidOrders;
		this.askOrders = askOrders;
		this.currentStockPrice = currentStockPrice;
	}




	public synchronized int getInstrumentId() {
		return instrumentId;
	}

	public synchronized void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized List<TimothyBidOrder> getBidOrders() {
		return bidOrders;
	}

	public synchronized void setBidOrders(List<TimothyBidOrder> bidOrders) {
		this.bidOrders = bidOrders;
	}

	public synchronized List<TimothyAskOrder> getAskOrders() {
		return askOrders;
	}

	public synchronized void setAskOrders(List<TimothyAskOrder> askOrders) {
		this.askOrders = askOrders;
	}

	public synchronized double getCurrentStockPrice() {
		return currentStockPrice;
	}

	public synchronized void setCurrentStockPrice(double currentStockPrice) {
		this.currentStockPrice = currentStockPrice;
	}
	
	


	
}
