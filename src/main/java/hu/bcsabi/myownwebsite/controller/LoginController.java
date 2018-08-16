package hu.bcsabi.myownwebsite.controller;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.bcsabi.myownwebsite.dao.UserDAO;
import hu.bcsabi.myownwebsite.management.EntityManagement;
import hu.bcsabi.myownwebsite.validation.Credentials;

import java.io.Serializable;

/**
 * A bejelentkezést vezérlő osztály.
 */
@Named("loginController")
@SessionScoped
public class LoginController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject Credentials credentials;
	
	public LoginController() {}
	
	/**
	 * Bejelentkezés a weboldalra. 
	 */
	public String login() {
		new EntityManagement().createConnection("myownwebsite");
		UserDAO userDAO = new UserDAO();
		if(userDAO.userIsValid(credentials)) {
			credentials.setLoggedIn(true);
			return "welcome";
		}
		
		return "error";
	}

}