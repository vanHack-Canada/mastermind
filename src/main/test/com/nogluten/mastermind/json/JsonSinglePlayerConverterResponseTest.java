package com.nogluten.mastermind.json;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nogluten.mastermind.game.singleplayer.GameSinglePlayer;
import com.nogluten.mastermind.game.singleplayer.GameSinglePlayerStatus;
import com.nogluten.mastermind.player.Player;
import com.nogluten.mastermind.tip.Tip;

public class JsonSinglePlayerConverterResponseTest {
	
	@Test
	public void shouldReturnResponseStatusPlaying() throws Exception{
		GameSinglePlayer gameSinglePlayer = new GameSinglePlayer(new Player(null, null));
		gameSinglePlayer.setGameSinglePlayerStatus(GameSinglePlayerStatus.PLAYING);
		
		gameSinglePlayer.addOneMove();
		gameSinglePlayer.addOneMove();
		
		Tip tip = new Tip();
		
		tip.addBlackPeg();
		tip.addBlackPeg();
		
		tip.addWhitePeg();
		tip.addWhitePeg();
		
		gameSinglePlayer.setTip(tip);
		
		JsonSinglePlayerConverterResponse jsonSinglePlayerConverterResponse = new JsonSinglePlayerConverterResponse(gameSinglePlayer);
		String response = jsonSinglePlayerConverterResponse.getResponse();
		
		JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
		
		Assert.assertEquals("PLAYING", jsonObject.get(JsonPropertiesCostant.GAME_STATUS).getAsString());
	}
}
