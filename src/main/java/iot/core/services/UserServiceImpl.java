package iot.core.services;

import iot.presentation.transport.NotificationDTO;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iot.common.UserConverter;
import iot.core.entities.role.Role;
import iot.core.entities.user.User;
import iot.core.repository.RoleRepo;
import iot.core.repository.UserRepo;
import iot.core.services.interfaces.UserService;
import iot.presentation.transport.UserDTO;

import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.util.HashMap;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final long CLIENT_ROLE_ID = 1;

    private final UserRepo userRepository;

    private final RoleRepo roleRepository;

    HashMap<Long, Session> activeSessionMap;
    HashMap<Session, Long> removeSessionMap;

    @Autowired
    public UserServiceImpl(UserRepo userRepository, RoleRepo roleRepository) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        activeSessionMap = new HashMap<>();
        removeSessionMap = new HashMap<>();
    }

    @Override
    public UserDTO addUser(UserDTO user) {
        User userToInsert = user.toUser();
        User result = null;

        if (userRepository.isUsernameUnique(userToInsert.getUsername())) {
            Role role = roleRepository.getRoleById(CLIENT_ROLE_ID);
            userToInsert.setRole(role);
            userRepository.addUser(userToInsert);
            result = userRepository.getUserByUsername(userToInsert.getUsername());
        }

        return UserConverter.toUserDTO(result);
    }

    @Override
    public boolean removeUser(long userId) {
        return userRepository.deleteUser(userId);
    }

    @Override
    public boolean editUser(UserDTO user) {
        User usr = userRepository.getUser(user.getUserId());

        if (!"".equals(user.getEmail())) {
            usr.setEmail(user.getEmail());
        }

        if (!"".equals(user.getPhone())) {
            usr.setPhone(user.getPhone());
        }
        if (!"".equals(user.getPassword())) {
            usr.setPassword(user.getPassword());
        }

        return userRepository.editUser(usr);
    }

    @Override
    public UserDTO authenticateUser(String username, String password) {
        return UserConverter.toUserDTO(userRepository.authenticateUser(username, password));
    }

    @Override
    public UserDTO getUser(long userId) {
        User user = userRepository.getUser(userId);
        return UserConverter.toUserDTO(user);
    }

    @Override
    public void sendNotification(NotificationDTO notification) {
        Long userId = notification.getUserId();

        if (activeSessionMap.containsKey(userId)) {
            Session session = activeSessionMap.get(userId);
            try {
                if (session.isOpen()) {
                    session.getBasicRemote().sendText(notification.convertToJson());
                }
            } catch (IOException e) {
                try {
                    session.close();
                } catch (IOException e1) {
                    System.out.println("Error during closing a notification session.");
                }
                activeSessionMap.remove(userId);
                removeSessionMap.remove(session);
            }
        }
    }

    @Override
    public void subscribeForNotifications(Session session) {

    }

    @Override
    public void unsubscribeFromNotifications(Session session) {

    }

}
