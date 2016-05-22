package com.nogluten.mastermind.game.singleplayer;

import java.util.HashMap;
import java.util.Map;

import com.nogluten.mastermind.MasterMindCore;
import com.nogluten.mastermind.RulesConstants;
import com.nogluten.mastermind.color.COLORS;
import com.nogluten.mastermind.json.JsonSinglePlayerConverterResponse;
import com.nogluten.mastermind.player.Player;
import com.nogluten.mastermind.tip.Tip;

public class GameManagementSinglePlayer {
	
	private static GameManagementSinglePlayer instance;
	
	private static final Map<Long, GameSinglePlayer> GAMES_CACHE = new HashMap<>();
	
	private GameManagementSinglePlayer() { 	}
	
	public static GameManagementSinglePlayer getInstance() {
		if(instance == null){
			instance = new GameManagementSinglePlayer();
		}
		return instance;
	}
	
	public String createNewGame(Player player) {
		GameSinglePlayer game = new GameSinglePlayer(player);
		player.setGame(game);
		game.setGameSinglePlayerStatus(GameSinglePlayerStatus.PLAYING);
		GAMES_CACHE.put(game.getId(), game);
		return getJsonResponse(game);
	}

	public synchronized String executeGuess(COLORS[] guess, Player player) throws Exception {
		GameSinglePlayer game = GAMES_CACHE.get(player.getGame().getId());
		game.addOneMove();
		MasterMindCore masterMindCore = new MasterMindCore();
		Tip tip = masterMindCore.evalueteGuess(player.getCode(), guess);
		game.setTip(tip);
		if(masterMindCore.isGameWin(tip)){
			game.setGameSinglePlayerStatus(GameSinglePlayerStatus.WIN);
		}else if(game.getNumberMoves() == RulesConstants.MAX_NUMBER_MOVES){
			game.setGameSinglePlayerStatus(GameSinglePlayerStatus.LOSE);
		}
		return getJsonResponse(game);
	}
	
	private String getJsonResponse(GameSinglePlayer game){
		return new JsonSinglePlayerConverterResponse(game).getResponse();
	}


}
