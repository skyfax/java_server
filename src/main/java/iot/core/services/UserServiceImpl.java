package iot.core.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iot.core.services.interfaces.UserService;
import iot.presentation.transport.UserDTO;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Override
	public UserDTO addUser(UserDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUser(long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editUser(UserDTO user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean authenticateUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDTO getUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
