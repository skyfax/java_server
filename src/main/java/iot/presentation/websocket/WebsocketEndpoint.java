package iot.presentation.websocket;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;

import iot.core.services.interfaces.DeviceService;

@ServerEndpoint("/actions")
public class WebsocketEndpoint {

//	ws://localhost:8080/iot/actions
//	Tomcat Server 9
	
	@Autowired
	DeviceService deviceService;
	
	@OnMessage
	public void handleMessage(String message, Session session) {
		System.out.println("Message from " + session.getId() + ": " + message);
		try {
			session.getBasicRemote().sendText(message);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@OnOpen
	public void open(Session session) {
		System.out.println("Client connected " + session.getId());
	}

	@OnClose
	public void close(Session session) {
		System.out.println("Client disconected " + session.getId());
	}

	@OnError
	public void onError(Throwable error) {
		Logger.getLogger(WebsocketEndpoint.class.getName()).log(Level.SEVERE, null, error);
	}

}
