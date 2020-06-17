package com.mthree.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SellerHistory 
{
	private int sellerId;
	
	@Id
	private int buyerId;
	
	private int volume;
	private float tradedPrice;
	
	
	public SellerHistory() {}
	
	public SellerHistory(int sellerId, int buyerId, int volume, float tradedPrice) {
		super();
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.volume = volume;
		this.tradedPrice = tradedPrice;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
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
		return "SellerHistory [sellerId=" + sellerId + ", buyerId=" + buyerId + ", volume=" + volume + ", tradedPrice="
				+ tradedPrice + "]";
	}
	
	

}
