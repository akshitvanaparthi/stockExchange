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
	private List<TimothyAskOrder> bidOrders;

	
	
	// constructor
	public TimothyInstrument(int timothyInstrumentId, String name, List<TimothyAskOrder> bidOrders) {
		super();
		this.instrumentId = timothyInstrumentId;
		this.name = name;
		this.bidOrders = bidOrders;
	}
	
	public TimothyInstrument() {}

	public synchronized int getTimothyInstrumentId() {
		return instrumentId;
	}

	public synchronized void setTimothyInstrumentId(int timothyInstrumentId) {
		this.instrumentId = timothyInstrumentId;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized List<TimothyAskOrder> getBidOrders() {
		return bidOrders;
	}

	public synchronized void setBidOrders(List<TimothyAskOrder> bidOrders) {
		this.bidOrders = bidOrders;
	}

	
	//setter and getter

	
}
