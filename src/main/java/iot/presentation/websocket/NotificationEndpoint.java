package iot.presentation.websocket;

import iot.core.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Shyzzle on 11/07/2017.
 */
@ServerEndpoint("/notifications")
public class NotificationEndpoint {

    @Autowired
    UserService userServiceService;

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
        Logger.getLogger(DeviceEndpoint.class.getName()).log(Level.SEVERE, null, error);
    }

}
