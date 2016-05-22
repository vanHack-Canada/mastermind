package com.nogluten.mastermind.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.nogluten.mastermind.user.User;
import com.nogluten.mastermind.user.UserManagement;

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
		User user = UserManagement.getInstance().createNewUser();
		return Response.status(Response.Status.OK).entity(createJsonResponse(user)).build();
	}
	
	private String createJsonResponse(User user){
		final Gson gson = new Gson();
		final UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		final String json = gson.toJson(userResponse);
		return json;
	}
	
}