package com.mthree.dto;

import com.mthree.model.User;

/**
 * @author tim10N
 *
 */
public class TimothyBidOrderDTO {

	private int id;

	int userId;

	double price;
	int volume;
	
	int imothyInstrumentId;

	public synchronized int getId() {
		return id;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}

	public synchronized int getUserId() {
		return userId;
	}

	public synchronized void setUserId(int userId) {
		this.userId = userId;
	}

	public TimothyBidOrderDTO(int id, int userId) {
		super();
		this.id = id;
		this.userId = userId;
	} 

	
	
	
	
	
	


}