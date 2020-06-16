/* 
 * 
 * 
 * This class is Testing purpose
 * 
 * */
package com.mthree.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TimothyBidOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "userId")
	User users;

	double price;
	int volume;
	
	@ManyToOne
	@JoinColumn(name="instrumen_id")
	TimothyInstrument instrument; 


	public TimothyBidOrder() {	}

	public synchronized int getId() {
		return id;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}

	public synchronized User getUsers() {
		return users;
	}

	public synchronized void setUsers(User users) {
		this.users = users;
	}

	public synchronized double getPrice() {
		return price;
	}

	public synchronized void setPrice(double price) {
		this.price = price;
	}

	public synchronized int getVolume() {
		return volume;
	}

	public synchronized void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "TimothyBidOrder [id=" + id + ", users=" + users + ", price=" + price + ", volume=" + volume
				+ ", instrument=" + instrument + "]";
	}
	

}
