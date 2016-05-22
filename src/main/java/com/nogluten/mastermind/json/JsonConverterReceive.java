package com.nogluten.mastermind.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nogluten.mastermind.RulesConstants;
import com.nogluten.mastermind.color.COLORS;
import com.nogluten.mastermind.game.GameMode;

public class JsonConverterReceive {
	
	private JsonObject jsonObject;
	
	private String sessionId;
	
	private GameMode gameMode;
	
	private COLORS[] guess;
	
	public JsonConverterReceive(String json) {
		JsonParser jsonParser = new JsonParser();
		this.jsonObject = jsonParser.parse(json).getAsJsonObject();
		this.sessionId = this.converteSessionId();
		this.guess = this.converteGuess();
		this.gameMode = this.converteGameMode();
	}
	
	private GameMode converteGameMode() {
		return GameMode.valueOf(jsonObject.get("gameMode").getAsString());
	}

	private String converteSessionId(){
		return jsonObject.get("sessionId").getAsString();
	}
	
	private COLORS[] converteGuess(){
		JsonArray jsonArray = jsonObject.get("guess").getAsJsonArray();
		COLORS[] colors = new COLORS[RulesConstants.MAX_NUMBER_POSITION]; 
		for(int i = 0; i < jsonArray.size(); i++){
			colors[i] =  COLORS.valueOf(jsonArray.get(i).getAsString());
		}
		return colors;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	
	public COLORS[] getGuess() {
		return guess;
	}
	
	public GameMode getGameMode() {
		return gameMode;
	}
}
