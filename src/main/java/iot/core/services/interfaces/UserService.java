package iot.core.services.interfaces;

import iot.presentation.transport.NotificationDTO;
import iot.presentation.transport.UserDTO;

import javax.websocket.Session;

public interface UserService {

	 UserDTO addUser(UserDTO user);

	 boolean removeUser(long userId);

	 boolean editUser(UserDTO user);

	 UserDTO authenticateUser(String username, String password);
	
	 UserDTO getUser(long userId);

	 void sendNotification(NotificationDTO notification);

	 void subscribeForNotifications(Session session);

	 void unsubscribeFromNotifications(Session session);

}
