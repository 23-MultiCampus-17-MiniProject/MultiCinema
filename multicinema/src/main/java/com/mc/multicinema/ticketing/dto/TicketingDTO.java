package com.mc.multicinema.ticketing.dto;

public class TicketingDTO {
	
	int ticketing_num;
	int user_key;
	String seat_id;
	
	public int getTicketing_num() {
		return ticketing_num;
	}
	public void setTicketing_num(int ticketing_num) {
		this.ticketing_num = ticketing_num;
	}
	public int getUser_key() {
		return user_key;
	}
	public void setUser_key(int user_key) {
		this.user_key = user_key;
	}
	public String getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}
	
	
}
