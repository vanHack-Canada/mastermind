package com.nogluten.mastermind.json;

import com.google.gson.JsonArray;
import com.nogluten.mastermind.RulesConstants;
import com.nogluten.mastermind.tip.Tip;
import com.nogluten.mastermind.tip.TipColors;

public abstract class JsonAbstractConverterResponse {

	protected String response;
	
	protected JsonArray createTipResponse(Tip tip) {
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
	
	public String getResponse() {
		return response;
	}
	
}
