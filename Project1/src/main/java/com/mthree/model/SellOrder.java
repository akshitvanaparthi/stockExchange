package com.mthree.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SellOrder {
    @Id
	private int sellId;
	
	private int sellShares;
	private float ask;
	
	
	public SellOrder() {}
	
	
		
		public int getSellId() {
		return sellId;
	}

	public void setSellId(int sellId) {
		this.sellId = sellId;
	}

	public int getSellShares() {
		return sellShares;
	}

	public void setSellShares(int sellShares) {
		this.sellShares = sellShares;
	}

	public float getAsk() {
		return ask;
	}

	public void setAsk(float ask) {
		this.ask = ask;
	}

	public SellOrder(int sellId, int sellShares, float ask) {
		super();
		this.sellId = sellId;
		this.sellShares = sellShares;
		this.ask = ask;
		
	}

	@Override
	public String toString() {
		return "SellOrder [sellId=" + sellId + ", sellShares=" + sellShares + ", ask=" + ask + ", orderbook="
				+ "]";
	}

		
}
