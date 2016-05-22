package com.nogluten.mastermind.game;

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

	public synchronized void createNewGame(Player player, GameMode gameMode) {
		if(gameMode.equals(GameMode.SINGLE_PLAYER)){
			gameManagementSinglePlayer.createNewGame(player);
		}else if(gameMode.equals(GameMode.MULTI_PLAYER)){
			gameManagementMultiPlayer.createNewGame(player);
		}
	}

}
