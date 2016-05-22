package com.nogluten.mastermind.json;

import com.google.gson.JsonObject;
import com.nogluten.mastermind.game.multiplayer.GameMultiPlayer;

public class JsonMultiPlayerConverterResponse extends JsonAbstractConverterResponse {
	
	public JsonMultiPlayerConverterResponse(GameMultiPlayer gameMultiPlayer) {
		this.createResponse(gameMultiPlayer);
	}

	private void createResponse(GameMultiPlayer gameMultiPlayer) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(JsonPropertiesCostant.GAME_STATUS, gameMultiPlayer.getGameMultiPlayerStatus().toString());
		jsonObject.addProperty(JsonPropertiesCostant.NUMBER_MOVES_PLAYER_ONE, gameMultiPlayer.getNumberMovesPlayerOne());
		jsonObject.addProperty(JsonPropertiesCostant.NUMBER_MOVES_PLAYER_TWO, gameMultiPlayer.getNumberMovesPlayerTwo());
		jsonObject.add(JsonPropertiesCostant.TIP_PLAYER_ONE, this.createTipResponse(gameMultiPlayer.getTipPlayerOne()));
		jsonObject.add(JsonPropertiesCostant.TIP_PLAYER_TWO, this.createTipResponse(gameMultiPlayer.getTipPlayerTwo()));
		this.response = jsonObject.toString();
	}

}
