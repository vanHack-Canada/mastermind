package com.nogluten.mastermind.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nogluten.mastermind.RulesConstants;
import com.nogluten.mastermind.game.singleplayer.GameSinglePlayer;
import com.nogluten.mastermind.tip.Tip;
import com.nogluten.mastermind.tip.TipColors;

public class JsonSinglePlayerConverterResponse {
	
	private String response;
	
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

	private JsonArray createTipResponse(Tip tip) {
		JsonArray jsonArray = new JsonArray();
		int index = 0;
		for(int i = 0; i < tip.getNumberBlackPegs(); i++){
		    jsonArray.add(TipColors.BLACK.toString());
		    index++;
		}
		for(int i = 0; i < tip.getNumberWhitePegs(); i++){
		    jsonArray.add(TipColors.WHITE.toString());
		    index++;
		}
		for(;index < RulesConstants.MAX_NUMBER_POSITION; index++){
		    jsonArray.add(TipColors.TRANSPARENT.toString());
		}
		return jsonArray;
	}

	public String getResponse(){
		return response;
	}
}
