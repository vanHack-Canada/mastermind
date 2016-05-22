package com.nogluten.mastermind.json;

import com.google.gson.JsonObject;
import com.nogluten.mastermind.game.singleplayer.GameSinglePlayer;

public class JsonSinglePlayerConverterResponse extends JsonAbstractConverterResponse{
	
	public JsonSinglePlayerConverterResponse(GameSinglePlayer gameSinglePlayer) {
		this.createResponse(gameSinglePlayer);
	}

	private void createResponse(GameSinglePlayer gameSinglePlayer) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(JsonPropertiesCostant.GAME_STATUS, gameSinglePlayer.getGameSinglePlayerStatus().toString());
		jsonObject.addProperty(JsonPropertiesCostant.NUMBER_MOVES, gameSinglePlayer.getNumberMoves());
		jsonObject.add(JsonPropertiesCostant.TIP, this.createTipResponse(gameSinglePlayer.getTip()));
		this.response = jsonObject.toString();
	}

}
