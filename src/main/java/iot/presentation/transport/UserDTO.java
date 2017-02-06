package iot.presentation.transport;

import iot.core.entities.user.User;
import org.springframework.hateoas.ResourceSupport;

public class UserDTO extends ResourceSupport {

    private long id;
    private String username;
    private String password;
    private String email;
    private long phone;

    public long getUserId() {
        return id;
    }

    public void setUserId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public User toUser() {
        User user = new User();

        user.setEmail(email);
        user.setId(id);
        user.setPhone(phone);
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }

}
