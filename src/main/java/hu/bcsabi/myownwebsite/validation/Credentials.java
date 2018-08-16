package hu.bcsabi.myownwebsite.validation;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Az aktuális felhasználó hitelesítő adatait megvalósító osztály.
 */
@Named
@SessionScoped
public class Credentials implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Boolean loggedIn = false;
	
	public Credentials() {}
	
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

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
}