package com.nogluten.mastermind.game;

import com.nogluten.mastermind.color.COLORS;
import com.nogluten.mastermind.game.multiplayer.GameManagementMultiPlayer;
import com.nogluten.mastermind.game.singleplayer.GameManagementSinglePlayer;
import com.nogluten.mastermind.player.Player;

public class GameManagement {
	
	private static GameManagement instance;
	
	private static GameManagementSinglePlayer gameManagementSinglePlayer;
	
	private static GameManagementMultiPlayer gameManagementMultiPlayer;
	
	private GameManagement(){ }
	
	public static GameManagement getInstance(){
		if (instance == null) {
			instance = new GameManagement();
			initializeGameManagementSinglePlayer();
			initializeGameManagementMultiPlayer();
		}
		return instance;
	}
	
	private static void initializeGameManagementMultiPlayer() {
		gameManagementMultiPlayer = GameManagementMultiPlayer.getInstance();
	}

	private static void initializeGameManagementSinglePlayer() {
		 gameManagementSinglePlayer = GameManagementSinglePlayer.getInstance();
	}

	public synchronized String createNewGame(Player player, GameMode gameMode) {
		if(gameMode.equals(GameMode.SINGLE_PLAYER)){
			return gameManagementSinglePlayer.createNewGame(player);
		}else if(gameMode.equals(GameMode.MULTI_PLAYER)){
			gameManagementMultiPlayer.createNewGame(player);
			return null;
		}
		return null;
	}
	
	public String executeGuess(COLORS[] guess, Player player){
		try{
			if(player.getGame().getMode().equals(GameMode.SINGLE_PLAYER)){
				return gameManagementSinglePlayer.executeGuess(guess, player);
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return null;
	}

}
