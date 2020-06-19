package com.mthree.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Buyer History Entity
 * @author Sahithi
 *
 */
@Entity
public class BuyerHistory {

	private int buyerId;
	
	@Id
	private int sellerId;
	
	private int volume;
	private float tradedPrice;
	
	public BuyerHistory() {}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public float getTradedPrice() {
		return tradedPrice;
	}
	public void setTradedPrice(float tradedPrice) {
		this.tradedPrice = tradedPrice;
	}
	@Override
	public String toString() {
		return "BuyerHistory [buyerId=" + buyerId + ", sellerId=" + sellerId + ", volume=" + volume + ", tradedPrice="
				+ tradedPrice + "]";
	}
	public BuyerHistory(int buyerId, int sellerId, int volume, float tradedPrice) {
		super();
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.volume = volume;
		this.tradedPrice = tradedPrice;
	}
	
	
	
	
}
