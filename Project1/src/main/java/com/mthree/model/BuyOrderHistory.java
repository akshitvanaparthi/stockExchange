package com.mthree.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuyOrderHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	int buyOrderHistoryId;
	
	private int buyShares;
	private float bid;
	
	
	//constructor
	public BuyOrderHistory() {}


	public BuyOrderHistory(int buyOrderHistoryId, int buyShares, float bid) {
		super();
		this.buyOrderHistoryId = buyOrderHistoryId;
		this.buyShares = buyShares;
		this.bid = bid;
	}


	public synchronized int getBuyOrderHistoryId() {
		return buyOrderHistoryId;
	}


	public synchronized void setBuyOrderHistoryId(int buyOrderHistoryId) {
		this.buyOrderHistoryId = buyOrderHistoryId;
	}


	public synchronized int getBuyShares() {
		return buyShares;
	}


	public synchronized void setBuyShares(int buyShares) {
		this.buyShares = buyShares;
	}


	public synchronized float getBid() {
		return bid;
	}


	public synchronized void setBid(float bid) {
		this.bid = bid;
	}
	
	
	
}
