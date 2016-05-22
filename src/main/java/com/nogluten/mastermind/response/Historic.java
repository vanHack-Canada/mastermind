package com.nogluten.mastermind.response;

import java.util.ArrayList;
import java.util.List;

public class Historic {
	
	private List<String[]> tips;
	
	private List<String[]> moves;
	
	public Historic() {
		tips = new ArrayList<>();
		moves = new ArrayList<>();		
	}
	
	public void addTip(String[] tip){
		tips.add(tip);
	}
	
	public void addMove(String[] move){
		moves.add(move);
	}
	
	public List<String[]> getTips() {
		return tips;
	}
	
	public List<String[]> getMoves() {
		return moves;
	}
}
