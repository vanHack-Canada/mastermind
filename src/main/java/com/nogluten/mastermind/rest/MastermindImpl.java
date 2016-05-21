package com.nogluten.mastermind.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/mastermind")
public class MastermindImpl {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloword() {
		final Gson gson = new Gson();
		final Teste teste = new Teste();
		teste.setHello("hello world");
		final String json = gson.toJson(teste);
		return Response.status(Response.Status.OK).entity(json).build();
	}

}