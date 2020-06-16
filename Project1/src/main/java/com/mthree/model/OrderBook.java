package com.mthree.model;


import javax.persistence.Entity;
import javax.persistence.Id;
//import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class OrderBook{
	@Id
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
	public int getSellShares() {
		return sellShares;
	}
	public void setSellShares(int sellShares) {
		this.sellShares = sellShares;
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
	
	
	@Override
	public String toString() {
		return "OrderBook [orderId=" + orderId + ", buyShares=" + buyShares + ", bidPrice=" + bidPrice + ", askPrice="
				+ askPrice + ", sellShares=" + sellShares + "]";
	}
	public OrderBook(int orderId, int buyShares, double bidPrice, double askPrice, int sellShares) {
		super();
		this.orderId = orderId;
		this.buyShares = buyShares;
		this.bidPrice = bidPrice;
		this.askPrice = askPrice;
		this.sellShares = sellShares;
	}
	public OrderBook() {}
	
}
