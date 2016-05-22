package com.nogluten.mastermind.player;

import java.util.HashMap;
import java.util.Map;

import com.nogluten.mastermind.MasterMindCore;

public class PlayerManagement {
	
	private static final Map<String, Player> USER_CACHE = new HashMap<>();
	
	private static PlayerManagement instance;
	
	private PlayerManagement(){ }
	
	public static PlayerManagement getInstance(){
		if (instance == null) {
			instance = new PlayerManagement();
		}
		return instance;
	}
	
	public synchronized Player createNewUser(String sessionId){
		Player user = new Player(sessionId, MasterMindCore.createRandomCode());
		USER_CACHE.put(user.getSessionId(), user);
		return user;
	}
	
	public synchronized Player getUser(final Long id){
		return USER_CACHE.get(id);
	}
	
	public synchronized void removeUser(Long id){
		USER_CACHE.remove(id);
	}
}
