package com.nogluten.mastermind;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.nogluten.mastermind.color.COLORS;
import com.nogluten.mastermind.tip.Tip;

public class MasterMindCoreTest {

	private MasterMindCore masterMindCore;
	
	@Before
	public void setup(){
		masterMindCore = new MasterMindCore();
	}
	
	@Test
	public void shouldReturnCodeSizeEight(){
		COLORS[] code = createCode();
		Assert.assertEquals(8, code.length);
	}

	@Test
	public void printCode(){
		COLORS[] code = createCode();
		for(COLORS color : code){
			System.out.println(color);
		}
	}
	
	@Test
	public void shouldReturnTwoBlackPegsAndTwoWhitePegs() throws Exception{
		COLORS[] codeCorrect = new COLORS[]{COLORS.BLUE, COLORS.BROWN, COLORS.GREEN, COLORS.GRAY, COLORS.ORANGE, COLORS.RED, COLORS.PINK, COLORS.RED};
		COLORS[] codeGuess = new COLORS[]{COLORS.BLUE, COLORS.BROWN, COLORS.YELLOW, COLORS.YELLOW, COLORS.GRAY, COLORS.ORANGE, COLORS.YELLOW, COLORS.YELLOW};
		Tip tip = masterMindCore.evalueteGuess(codeCorrect, codeGuess);
		Assert.assertEquals(2, tip.getNumberBlackPegs());
		Assert.assertEquals(2, tip.getNumberWhitePegs());
	}
	
	@Test
	public void shouldReturnFiveBlackPegsAndOneWhitePegs() throws Exception{
		COLORS[] codeCorrect = new COLORS[]{COLORS.BLUE, COLORS.BROWN, COLORS.GREEN, COLORS.GRAY, COLORS.ORANGE, COLORS.RED, COLORS.PINK, COLORS.RED};
		COLORS[] codeGuess = new COLORS[]{COLORS.BLUE, COLORS.BROWN, COLORS.YELLOW, COLORS.YELLOW, COLORS.ORANGE, COLORS.ORANGE, COLORS.PINK, COLORS.RED};
		Tip tip = masterMindCore.evalueteGuess(codeCorrect, codeGuess);
		Assert.assertEquals(5, tip.getNumberBlackPegs());
		Assert.assertEquals(1, tip.getNumberWhitePegs());
	}
	
	@Test
	public void shouldWinGame() throws Exception{
		COLORS[] codeCorrect = new COLORS[]{COLORS.BLUE, COLORS.BROWN, COLORS.GREEN, COLORS.GRAY, COLORS.ORANGE, COLORS.RED, COLORS.PINK, COLORS.RED};
		COLORS[] codeGuess = new COLORS[]{COLORS.BLUE, COLORS.BROWN, COLORS.GREEN, COLORS.GRAY, COLORS.ORANGE, COLORS.RED, COLORS.PINK, COLORS.RED};
		Tip tip = masterMindCore.evalueteGuess(codeCorrect, codeGuess);
		Assert.assertTrue(masterMindCore.isGameWin(tip));
	}
	
	private COLORS[] createCode() {
		COLORS[] key = MasterMindCore.createRandomCode();
		return key;
	}
	
}
