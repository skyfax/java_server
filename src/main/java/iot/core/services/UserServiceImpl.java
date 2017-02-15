package iot.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iot.common.UserConverter;
import iot.core.entities.user.User;
import iot.core.repository.UserRepo;
import iot.core.services.interfaces.UserService;
import iot.presentation.transport.UserDTO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepository;

	@Override
	public UserDTO addUser(UserDTO user) {
		User userToInsert = user.toUser();
		User result = null;

		if (userRepository.isUsernameUnique(userToInsert.getUsername())) {
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

}
