package com.squirrel.util.session;

public class SessionManager {


	static public enum SESSIONNAME{

	}
	
	public static String getSessionName(SESSIONNAME sessionName) {
		
		return sessionName.name(); 
	}
	
	
	
}
