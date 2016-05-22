package com.nogluten.mastermind.player;

import java.util.Calendar;

import com.nogluten.mastermind.color.COLORS;
import com.nogluten.mastermind.game.Game;

public class Player {
	
	private String sessionId;
	
	private COLORS[] code;
	
	private Calendar dateCreated;
	
	private String name;
	
	private String nickName;
	
	private String age;
	
	private int numberTry;
	
	private Game game;
	
	public Player(String sessionId, COLORS[] code) {
		this.sessionId = sessionId;
		this.code = code;
		this.dateCreated = Calendar.getInstance();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSessionId() {
		return sessionId;
	}
	
	public Calendar getDateCreated() {
		return dateCreated;
	}
	
	public int getNumberTry() {
		return numberTry;
	}

	public void addOneTry() {
		this.numberTry++;
	}

	public COLORS[] getCode() {
		return code;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}

}
