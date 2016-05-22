package com.nogluten.mastermind.response;

public class UserResponse {
	
	private ResponseStatus responseStatus;
	
	private Historic historic;
	
	private int numberMoves;

	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public Historic getHistoric() {
		return historic;
	}

	public void setHistoric(Historic historic) {
		this.historic = historic;
	}

	public int getNumberMoves() {
		return numberMoves;
	}

	public void setNumberMoves(int numberMoves) {
		this.numberMoves = numberMoves;
	}

	
}
