package com.nogluten.mastermind.game.multiplayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nogluten.mastermind.game.Game;
import com.nogluten.mastermind.player.Player;

public class GameManagementMultiPlayer {

	 private static GameManagementMultiPlayer instance;
	 
	 private static final Map<Long, Game> GAMES_CACHE = new HashMap<Long, Game>();
	 
   	 private static final List<GameMultiPlayer> gamesMultiPlayerWaitingAnotherPlayer = new ArrayList<>();
	 
	 private GameManagementMultiPlayer() { }
	 
	 public static GameManagementMultiPlayer getInstance(){
		 if(instance == null){
			 instance = new GameManagementMultiPlayer();
		 }
		 return instance;
	 }
	 
	 public void createNewGame(Player player) {
		if(gamesMultiPlayerWaitingAnotherPlayer.isEmpty()){
			GameMultiPlayer game = new GameMultiPlayer();
			game.addPlayerOne(player);
			player.setGame(game);
			game.setGameMultiPlayerStatus(GameMultiPlayerStatus.WAITING_ANOTHER_PLAYER);
			gamesMultiPlayerWaitingAnotherPlayer.add(game); 
		}else{
			GameMultiPlayer game = gamesMultiPlayerWaitingAnotherPlayer.get(0);
			game.addPlayerTwo(player);
			player.setGame(game);
			game.setGameMultiPlayerStatus(GameMultiPlayerStatus.PLAYER_ONE_PLAYING);
			GAMES_CACHE.put(game.getId(), game);
			gamesMultiPlayerWaitingAnotherPlayer.remove(0);
		}
	}
}
