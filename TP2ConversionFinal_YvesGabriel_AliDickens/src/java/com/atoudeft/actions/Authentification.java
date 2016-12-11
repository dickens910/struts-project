package com.atoudeft.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.atoudeft.dao.UserDAO;
import com.atoudeft.entites.User;
import com.atoudeft.jdbc.Connexion;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;

public class Authentification extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String username, password;
        //private User user;
	  
	@Override
	public void setSession(Map<String, Object> s) {
		// TODO Auto-generated method stub
		session = s;
	}

	public String login() throws ClassNotFoundException
	{
                UserDAO dao = new UserDAO(Connexion.getInstance());
                User user = new User();
                user.setPassword(password);
                user.setUsername(username);
                boolean result = dao.findUser(user);
                if(result) //a revoir cette condition ou le DAO always true
		{   
                    
                    session.put("connecte", true);
                    session.put("username", user.getUsername());
                    return SUCCESS;
		}
		return INPUT;
	}
	
	public String logout()
	{
		session.remove("connecte");
		session.clear();
		return SUCCESS;
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
	
}
