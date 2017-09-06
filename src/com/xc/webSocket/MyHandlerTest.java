package com.xc.webSocket;

import java.util.HashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class MyHandlerTest implements WebSocketHandler {
	public static HashMap<Integer, Object> sessionMap = new HashMap<>();

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) {
		System.out.println("关闭状态: " + arg1.getReason());
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session){
		int userid = (Integer) session.getAttributes().get("userID");
		System.out.println("这里被链接："+userid);
		if (sessionMap.get(userid) == null)
			sessionMap.put(userid, session);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> arg1) {
			System.out.println("这里被执行了");
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable arg1) {
		System.out.println("handleTransportError");
	}

	@Override
	public boolean supportsPartialMessages() {
		System.out.println("supportsPartialMessages");
		return true;
	}

}
