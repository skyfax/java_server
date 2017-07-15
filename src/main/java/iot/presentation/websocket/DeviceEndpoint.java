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

import iot.core.services.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import iot.core.services.interfaces.DeviceService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


@ServerEndpoint("/actions")
public class DeviceEndpoint {

//	ws://localhost:8080/iot/actions
//	Tomcat Server 9


    private DeviceService deviceService;

    public DeviceEndpoint(){
        deviceService = DeviceServiceImpl.getInstance();
    }

    @OnMessage
    public void handleMessage(String message, Session session) {
        System.out.println("Message from " + session.getId() + ": " + message);
        deviceService.parseMessageFromDevice(message, session);
    }

    @OnOpen
    public void open(Session session) {
        System.out.println("Client connected " + session.getId());
        deviceService.putDeviceInPreAuthenticationList(session);
    }

    @OnClose
    public void close(Session session) {
        System.out.println("Client disconnected " + session.getId());
        deviceService.removeDeviceFromActiveConnections(session);
    }

    @OnError
    public void onError(Throwable error) {
        Logger.getLogger(DeviceEndpoint.class.getName()).log(Level.SEVERE, null, error);
    }


}
