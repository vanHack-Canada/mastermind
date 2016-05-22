package com.nogluten.mastermind.user;

import java.util.HashMap;
import java.util.Map;

public class UserManagement {
	
	private static final Map<Long, User> USER_CACHE = new HashMap<>();
	
	private static UserManagement instance;
	
	private UserManagement(){ }
	
	public static UserManagement getInstance(){
		if (instance == null) {
			instance = new UserManagement();
		}
		return instance;
	}
	
	public synchronized User createNewUser(){
		User user = new User();
		Long timeNow = System.currentTimeMillis();
		user.setId(timeNow);
		USER_CACHE.put(user.getId(), user);
		return user;
	}
	
	public synchronized User getUser(final Long id){
		return USER_CACHE.get(id);
	}
	
	public synchronized void removeUser(Long id){
		USER_CACHE.remove(id);
	}
}
