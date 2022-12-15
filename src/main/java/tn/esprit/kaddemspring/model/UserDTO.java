package tn.esprit.kaddemspring.model;

import lombok.Data;

@Data
public class UserDTO {
	private String username;
	private String password;
	private TypeRole role;

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
}
