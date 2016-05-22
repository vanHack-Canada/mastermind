package com.nogluten.mastermind.game;

import java.util.HashMap;
import java.util.Map;

import com.nogluten.mastermind.player.Player;

public class GameManagement {
	
	private static GameManagement instance;
	
	private static final Map<Long, Game> GAMES_CACHE = new HashMap<Long, Game>();
	
	private static Game gameMultiPlayerWaitingPlayer;
	
	private GameManagement(){ }
	
	public static GameManagement getInstance(){
		if (instance == null) {
			instance = new GameManagement();
		}
		return instance;
	}
	
	public synchronized void createNewGame(Player player, GameMode gameMode) {
		if(gameMode.equals(GameMode.SINGLE_PLAYER)){
			Game game = new GameSinglePlayer(player);
			player.setGame(game);
			GAMES_CACHE.put(game.getId(), game);
		}else if(gameMode.equals(GameMode.MULTI_PLAYER)){
			
		}
	}
}
