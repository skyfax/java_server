import iot.core.repository.UserRepo;
import iot.core.services.interfaces.UserService;
import iot.presentation.transport.UserDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Shyzzle on 12/07/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DeviceServiceTest {

    @Configuration
    static class AccountServiceTestContextConfiguration {
        @Bean
        public UserService userService() {
            return Mockito.mock(UserService.class);
        }

        @Bean
        public UserRepo userRepo() {
            return Mockito.mock(UserRepo.class);
        }
    }

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;

    @Test
    public void testRegistration() {
        UserDTO user = new UserDTO();
        user.setEmail("aaa@aaa"); user.setPassword("123");
        user.setPhone(5234543); user.setUsername("aaa");
        UserDTO insertedUser = userService.addUser(user);
        Assert.assertEquals("Error", user.getUsername(), insertedUser.getUsername());
    }

  @Test
    public void testLogin() {
        UserDTO user = userService.authenticateUser("aaa", "123");
        Assert.assertNotNull(user);
    }

    @Test
    public void removeUser(){
        UserDTO user = userService.authenticateUser("aaa", "123");
        long id = user.getUserId();
        userService.removeUser(id);
        UserDTO userDTO = userService.getUser(id);
        Assert.assertNull(userDTO);
    }



}
