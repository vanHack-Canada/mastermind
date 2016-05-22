package com.nogluten.mastermind.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.nogluten.mastermind.game.GameManagement;
import com.nogluten.mastermind.json.JsonConverterReceive;
import com.nogluten.mastermind.player.Player;
import com.nogluten.mastermind.player.PlayerManagement;

@Path("/mastermind")
public class MastermindImpl {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloword() {
		final Gson gson = new Gson();
		final String json = gson.toJson("hello Word");
		return Response.status(Response.Status.OK).entity(json).build();
	}
	
	@GET
	@Path("/initGame/{guess}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes
	public Response initGame(@PathParam("guess") String guess){
		JsonConverterReceive jsonConverterReceive = new JsonConverterReceive(guess);
		Player player = PlayerManagement.getInstance().createNewUser(jsonConverterReceive.getSessionId());
		String jsonResponse = GameManagement.getInstance().createNewGame(player, jsonConverterReceive.getGameMode());
		return Response.status(Response.Status.OK).entity(jsonResponse).build();
	}
	
	@POST
	@Path("/executeGuess/{guess}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes
    public Response executeGuess(@PathParam("guess") String guess){
		JsonConverterReceive jsonConverterReceive = new JsonConverterReceive(guess);
		Player player = PlayerManagement.getInstance().getUser(jsonConverterReceive.getSessionId());
		String jsonResponse = GameManagement.getInstance().executeGuess(jsonConverterReceive.getGuess(), player);
		return Response.status(Response.Status.OK).entity(jsonResponse).build();
	}

}