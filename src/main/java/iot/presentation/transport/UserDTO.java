package iot.presentation.transport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import iot.core.entities.user.User;

public class UserDTO {

	private long id;
	private String username;
	private String password;
	private String email;
	private long phone;

//	@JsonCreator
//	public UserDTO(@JsonProperty("username") String username, @JsonProperty("password") String password,
//			@JsonProperty("email") String email, @JsonProperty("phone") Long phone) {
//		this.username = username;
//		this.password = password;
//		this.email = email;
//		this.phone = phone;
//	}

	@JsonCreator
	public UserDTO(@JsonProperty("id") Long id, @JsonProperty("username") String username, @JsonProperty("password") String password,
			@JsonProperty("email") String email, @JsonProperty("phone") Long phone) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public UserDTO() {
	}

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
		user.setId(id > 0 ? id : null);
		user.setPhone(phone);
		user.setUsername(username);
		user.setPassword(password);

		return user;
	}

}
