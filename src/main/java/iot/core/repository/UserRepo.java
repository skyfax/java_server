package iot.core.repository;

import iot.core.entities.user.User;

public interface UserRepo {

    public boolean isUsernameUnique(String username);

    public boolean addUser(User user);

    public boolean editUser(User user);

    public User authenticateUser(String username, String password);

    public User getUser(long userId);

    public boolean deleteUser(long userId);
    
    public User getUserByUsername(String username);

}
