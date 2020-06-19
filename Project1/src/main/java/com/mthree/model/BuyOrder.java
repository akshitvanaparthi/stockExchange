package com.mthree.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Buy Order Entity
 * @author Sahithi
 *
 */
@Entity
public class BuyOrder 
{
	
	    @Id
		private int buyId;
		
		private int buyShares;
		private float bid;
		
		
		public int getBuyId() {
			return buyId;
		}
		public void setBuyId(int buyId) {
			this.buyId = buyId;
		}
		public int getBuyShares() {
			return buyShares;
		}
		public void setBuyShares(int buyShares) {
			this.buyShares = buyShares;
		}
		public float getBid() {
			return bid;
		}
		public void setBid(float bid) {
			this.bid = bid;
		}
		@Override
		public String toString() {
			return "BuyOrder [buyId=" + buyId + ", buyShares=" + buyShares + ", bid=" + bid + "]";
		}
		public BuyOrder(int buyId, int buyShares, float bid) {
			super();
			this.buyId = buyId;
			this.buyShares = buyShares;
			this.bid = bid;
		}
       
		public BuyOrder() {}


}
