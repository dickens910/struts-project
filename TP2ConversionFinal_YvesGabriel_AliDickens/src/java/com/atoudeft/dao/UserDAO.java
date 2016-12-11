package com.atoudeft.dao;

import com.atoudeft.DA.DAO;
import com.atoudeft.entites.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserDAO extends DAO<User>{
    
    public UserDAO(Connection c) {
        super(c);
    }
    @Override
    public boolean create(User x) { // sa rajoute mais sa rajoute des cases vides a revoir 
       String req = "INSERT INTO user (`username` , `password`) "
                + "VALUES ('" + x.getUsername() + "','" + x.getPassword() + "')";

        //System.out.println("REQUETE "+req);

        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } 
        catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return false;  
    }        
    @Override
    public boolean delete(User x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM user WHERE username='" + x.getUsername() + "'");
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    public User read(String id) {
        // TODO Auto-generated method stub
        PreparedStatement stm = null;
        try {
//            Statement stm = cnx.createStatement();
//            ResultSet r = stm.executeQuery("SELECT * FROM user WHERE username = '" + id + "'");
            //Avec requête paramétrée :
            stm = cnx.prepareStatement("SELECT * FROM user WHERE username = ?");
            stm.setString(1,id);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                //User c = new User(r.getString("username"),r.getString("password"));
                User c = new User();
                c.setUsername(r.getString("username"));
                c.setPassword(r.getString("password"));
                r.close();
                stm.close();
                return c;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public boolean update(User x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE user SET password = '" + x.getPassword() + "'"
                    + " WHERE username = '" + x.getUsername() + "'";
            //System.out.println("REQUETE "+req);
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        List<User> liste = new LinkedList<User>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM user");
            while (r.next()) {
                User c = new User(r.getString("username"),
                        r.getString("password"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
    public boolean findUser(User u) {
        // TODO Auto-generated method stub
        boolean status = false;
        try {
            Statement stm = cnx.createStatement();
             String sql = "SELECT username FROM user WHERE";
                sql+=" username = ? AND password = ?";
            PreparedStatement ps = cnx.prepareStatement(sql); 
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ResultSet r = ps.executeQuery();
            status = r.next();
            r.close();
            stm.close();
        } catch (SQLException exp) {
            return false;
        }
        return status;
    }
        

}
