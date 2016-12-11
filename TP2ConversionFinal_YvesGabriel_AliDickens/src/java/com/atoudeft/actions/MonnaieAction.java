/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atoudeft.actions;


import com.atoudeft.dao.MonnaieDAO;
import com.atoudeft.entites.Monnaie;
import com.atoudeft.jdbc.Connexion;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author usager
 */
public class MonnaieAction extends ActionSupport implements SessionAware{
    
    private Map<String, Object> session;
    private List<Monnaie> moneyList ;//= LivreDAO.getBookList();
    private Monnaie  taux ; //= new Monnaie();

    public Monnaie getTaux() {
        return taux;
    }

    public void setTaux(Monnaie taux) {
        this.taux = taux;
    }
              
    public MonnaieAction(){ 
    }
    
    public String execute() throws Exception{ 
        MonnaieDAO  dao =   new MonnaieDAO(Connexion.getInstance());
            moneyList = dao.findAll();

        return SUCCESS;}  
    @Override
    public void setSession(Map<String, Object> s) {
        session = s;    
    }

    public List<Monnaie> getMoneyList() {
		return moneyList;
	}
    
}
