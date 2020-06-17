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
	@JoinColumn(name = "instrumen_id")
	TimothyInstrument instrument;

	int state; // 1: matched, 2: active, 3: pending, 4:cancelled 

	public TimothyBidOrder(int id, User users, double price, int volume, TimothyInstrument instrument, int state) {
		super();
		this.id = id;
		this.users = users;
		this.price = price;
		this.volume = volume;
		this.instrument = instrument;
		this.state = state;
	}

	public TimothyBidOrder() {
		super();
	}

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

	public synchronized TimothyInstrument getInstrument() {
		return instrument;
	}

	public synchronized void setInstrument(TimothyInstrument instrument) {
		this.instrument = instrument;
	}

	public synchronized int getState() {
		return state;
	}

	public synchronized void setState(int state) {
		this.state = state;
	}
	
	

}
