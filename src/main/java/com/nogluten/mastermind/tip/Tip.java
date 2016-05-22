package com.nogluten.mastermind.tip;

import com.nogluten.mastermind.RulesConstants;

public class Tip {
	
	private int pegsWhite = 0;
	
	private int pegsBlack = 0;
	
	public void addBlackPeg() throws Exception{
		if(pegsBlack > RulesConstants.MAX_NUMBER_POSITION)
			throw new Exception("Number black pegs is more larger than max!");
		pegsBlack++;
	}
	
	public void addWhitePeg() throws Exception{
		if(pegsWhite > RulesConstants.MAX_NUMBER_POSITION)
			throw new Exception("Number white pegs is more larger than max!");
		pegsWhite++;
	}
	
	public int getNumberBlackPegs() {
		return pegsBlack;
	}
	
	public int getNumberWhitePegs() {
		return pegsWhite;
	}
}
