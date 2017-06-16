package iot.common;

import iot.core.entities.user.User;
import iot.presentation.transport.UserDTO;

/**
 * Created by Usera on 04/02/2017.
 */
public class UserConverter {


    public static UserDTO toUserDTO(User user){
        UserDTO result = null;

        if(user != null){
        	result = new UserDTO();
        	
            result.setPhone(user.getPhone());
            result.setUserId(user.getId());
            result.setEmail(user.getEmail());
            result.setUsername(user.getUsername());
        }
        
        return result;
    }
}
