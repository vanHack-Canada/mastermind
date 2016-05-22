package com.nogluten.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nogluten.mastermind.color.COLORS;
import com.nogluten.mastermind.tip.Tip;

public class MasterMindCore {

	public static COLORS[] createRandomCode(){
		COLORS[] code = new COLORS[RulesConstants.MAX_NUMBER_POSITION];
		Random random = new Random();
		for(int i =0; i < RulesConstants.MAX_NUMBER_POSITION; i++){
			COLORS color = COLORS.values()[random.nextInt(RulesConstants.MAX_NUMBER_POSITION)];
			code[i] = color;
		}
		return code;
	}
	
	public Tip evalueteGuess(COLORS[] codeCorrect, COLORS[] codeGuess) throws Exception{
		Tip tip = new Tip();
		List<Integer> pegsProcessed = new ArrayList<Integer>();
		for(int index = 0 ; index < RulesConstants.MAX_NUMBER_POSITION; index++){
			if(codeCorrect[index].equals(codeGuess[index])){
				tip.addBlackPeg();
				pegsProcessed.add(index);
			}else{
				for(int indexGuess = 0; indexGuess < RulesConstants.MAX_NUMBER_POSITION; indexGuess++){
					if(codeCorrect[index].equals(codeGuess[indexGuess]) && !pegsProcessed.contains(indexGuess)){
						tip.addWhitePeg();
						pegsProcessed.add(indexGuess);
						break;
					}
				}
			}
		}
		return tip;
	}
	
	public boolean isGameWin(Tip tip){
		if(tip.getNumberBlackPegs() == RulesConstants.MAX_NUMBER_POSITION)
			return true;
		return false;
	}
}
