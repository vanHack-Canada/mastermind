package com.nogluten.mastermind.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.nogluten.mastermind.json.JsonConverterReceive;
import com.nogluten.mastermind.player.Player;
import com.nogluten.mastermind.player.PlayerManagement;
import com.nogluten.mastermind.response.UserResponse;

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
	@Produces(MediaType.APPLICATION_JSON)
	public Response initGameSingle(){
		Player user = PlayerManagement.getInstance().createNewUser();
		return Response.status(Response.Status.OK).entity(createJsonResponse(user)).build();
	}
	
	@POST
	@Path("/executeGuess/{guess}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes
    public Response executeGuess(@PathParam("guess") String guess){
		JsonConverterReceive jsonConverterReceive = new JsonConverterReceive(guess);
		return null;
	}
	
	private String createJsonResponse(Player user){
		final Gson gson = new Gson();
		final UserResponse userResponse = new UserResponse();
		final String json = gson.toJson(userResponse);
		return json;
	}
	
}