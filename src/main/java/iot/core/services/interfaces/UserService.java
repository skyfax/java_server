package iot.core.services.interfaces;

import iot.presentation.transport.UserDTO;

public interface UserService {

	public UserDTO addUser(UserDTO user);

	public boolean removeUser(long userId);

	public boolean editUser(UserDTO user);

	public UserDTO authenticateUser(String username, String password);
	
	public UserDTO getUser(long userId);

}
