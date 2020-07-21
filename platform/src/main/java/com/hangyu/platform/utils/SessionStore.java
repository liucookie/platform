package com.hangyu.platform.utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SessionStore {
	    private static Map<String, HttpSession> map = new HashMap<String, HttpSession>();
	    public static synchronized void addSession(HttpSession session) {
	        if (session != null) {
	            map.put(session.getId(), session);
	        }
	    }

	    public static synchronized void delSession(HttpSession session) {
	        if (session != null) {
	            map.remove(session.getId());
	        }
	    }

	    public static synchronized HttpSession getSession(String sessionId) {
	        if (sessionId == null) {
				return null;
			}
	        return map.get(sessionId);
	    }
}
