package com.mthree.dto;

public class TimothyAskOrderDTO {
	private int id;

	int userId;

	double price;
	int volume;
	
	int timothyInstrumentId;
	
	int state;

	
	
	
	
	public TimothyAskOrderDTO(int id, int userId, double price, int volume, int timothyInstrumentId, int state) {
		super();
		this.id = id;
		this.userId = userId;
		this.price = price;
		this.volume = volume;
		this.timothyInstrumentId = timothyInstrumentId;
		this.state = state;
	}

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

	public synchronized int getTimothyInstrumentId() {
		return timothyInstrumentId;
	}

	public synchronized void setTimothyInstrumentId(int timothyInstrumentId) {
		this.timothyInstrumentId = timothyInstrumentId;
	}

	public synchronized int getState() {
		return state;
	}

	public synchronized void setState(int state) {
		this.state = state;
	}
	
	
	
}
