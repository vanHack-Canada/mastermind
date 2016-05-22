package com.nogluten.mastermind.rest;

public class UserResponse {
	
	private Long id;
	
	private String[] tip;
	
	private int numberTry;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String[] getTip() {
		return tip;
	}

	public void setTip(String[] tip) {
		this.tip = tip;
	}

	public int getNumberTry() {
		return numberTry;
	}

	public void setNumberTry(int numberTry) {
		this.numberTry = numberTry;
	}
}
