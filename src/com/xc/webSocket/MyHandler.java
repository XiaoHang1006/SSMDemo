package com.xc.webSocket;

import java.util.HashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class MyHandler implements WebSocketHandler {
	public static HashMap<Integer, Object> sessionMap = new HashMap<>();

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) throws Exception {

	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		int userid = (Integer) session.getAttributes().get("userID");
		System.out.println("这里被链接："+userid);
		if (sessionMap.get(userid) == null)
			sessionMap.put(userid, session);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> arg1) throws Exception {

	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable arg1) throws Exception {

	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

}
