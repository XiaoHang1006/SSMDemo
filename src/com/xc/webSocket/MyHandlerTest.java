package com.xc.webSocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class MyHandlerTest implements WebSocketHandler {
	public static List<WebSocketSession> list = new ArrayList<>();

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) {
		if (list.contains(session))
			list.remove(session);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws IOException {
		if (!list.contains(session))
			list.add(session);
		session.sendMessage(new TextMessage("hello"));
		// SendInfo(session);
	}

	public void SendInfo(WebSocketSession session) {
		while (true) {
			final WebSocketSession webSocketSession = session;
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					try {
						System.out.println("这里被执行了");
						webSocketSession.sendMessage(new TextMessage("hello"));
					} catch (IOException e) {
						System.out.println(e);
						e.printStackTrace();
					}
				}
			}, 1000 * 10);
		}
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws IOException {
		// if(message.getPayloadLength() <= 0)
		// return;
		//
		// String msg = (String) message.getPayload();
		// for(int i=0;i<list.size();i++)
		// {
		// if(!session.equals(list.get(i)))
		// list.get(i).sendMessage(new TextMessage(msg));
		// }

	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable arg1) {
	}

	@Override
	public boolean supportsPartialMessages() {
		return true;
	}

}
