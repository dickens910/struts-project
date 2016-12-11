/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atoudeft.dao;


import com.atoudeft.entites.Monnaie;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.atoudeft.DA.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 *
 * @author usager
 */
public class MonnaieDAO extends DAO<Monnaie> {
    //private static List<Monnaie> moneyList = new LinkedList<>();
        public MonnaieDAO(Connection cnx) {
                super(cnx);
            }
     //   public static List<Monnaie> getMoneyList() {
	//moneyList.add( new Monnaie("yen", 5));
               
       //     return moneyList;   
	//}
        
    public  List<Monnaie> findAll (){
        List<Monnaie> moneyList = new LinkedList<>();
        try {
            Statement stm = cnx.createStatement(); 
                        String query = "SELECT * FROM taux";
                        ResultSet r = stm.executeQuery(query);
                        while (r.next())
			{
				Monnaie m = new Monnaie(r.getString("monnaie"),
                                                r.getFloat("valeur")
						);
                                moneyList.add(m);    

			}
			r.close();
			stm.close();
                 }
        catch (SQLException exp)
		{
		}  
        return moneyList;
    }

    @Override
    public boolean create(Monnaie x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean update(Monnaie x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Monnaie x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Monnaie read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
