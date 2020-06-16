package com.mthree.dto;

public class OrderBookDTO {
private int orderId;
	
	private int buyShares;
	private double bidPrice;
	private double askPrice;
	private int sellShares;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getBuyShares() {
		return buyShares;
	}
	public void setBuyShares(int buyShares) {
		this.buyShares = buyShares;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public double getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(double askPrice) {
		this.askPrice = askPrice;
	}
	public int getSellShares() {
		return sellShares;
	}
	public void setSellShares(int sellShares) {
		this.sellShares = sellShares;
	}
	public OrderBookDTO() {}
	

}
