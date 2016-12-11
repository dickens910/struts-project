package com.atoudeft.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.atoudeft.dao.UserDAO;
import com.atoudeft.entites.User;
import com.atoudeft.jdbc.Connexion;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registration extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String username, password, password2;
	  
	@Override
	public void setSession(Map<String, Object> s) {
		// TODO Auto-generated method stub
		session = s;
	}

	public String execute()
	{
            try {
                UserDAO dao = new UserDAO(Connexion.getInstance());
                User user = new User(username,password);
                if (username==null)
                    return INPUT;
                boolean result = dao.create(user);
                if (result)
                    return SUCCESS;
                return INPUT;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }
            return INPUT;
	}

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }


        public void validate()
        {
            if (username!=null && username.indexOf('@')==-1)
                    this.addFieldError("username", "[Exemple de validation] Le username doit contenir le caractere @.");
            if (password!=null && password.length()<3)
                    this.addFieldError("password", "Le mot de passe doit avoir au moins 3 caracteres.");
            if (password2!=null && !password.equals(password2))
                    this.addFieldError("password", "Les mots de passes ne sont pas identiques.");
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
