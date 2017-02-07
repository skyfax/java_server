package iot.core.repository.impl;





import iot.core.entities.user.User;
import iot.core.repository.UserRepo;

/**
 * Created by Usera on 04/02/2017.
 */
public class UserRepositoryImpl implements UserRepo {
	
//	@Autowired
//	EntityManager entityManager;
	
    @Override
    public boolean isUsernameUnique(String username) {
//    	Criteria criteria = entityManager.getCriteriaBuilder().
    	
        return false;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean editUser(User user) {
        return false;
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        return false;
    }

    @Override
    public User getUser(long userId) {
        return null;
    }

    @Override
    public boolean deleteUser(long userId) {
        return false;
    }
}
