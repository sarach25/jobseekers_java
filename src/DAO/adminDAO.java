/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.*;
import entities.message;
import entities.publication;
import interfaces.IDAOADMIN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author bejaoui
 */
public class adminDAO implements IDAOADMIN<membre>{
    private Connection connection;
    private PreparedStatement pst;
    
    public adminDAO()
    {
        //initialiser la connection;
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void update(membre t, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bloquermembre( int idmembre) {
        try
        {
            String req="update membre set etatmembre='bloqué' where idmembre=?";
            pst = connection.prepareStatement(req);
            pst.setInt(1, idmembre);
            pst.executeUpdate();
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(adminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimermsg(message msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
       public void supprimerpub(int idpub) {
         try
        {
            String req="update publication set etatpub='bloqué' where idpub=?";
            pst = connection.prepareStatement(req);
            pst.setInt(1, idpub);
            pst.executeUpdate();
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(adminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public List<membre> findAll() {
       List<membre> listeMembres = new ArrayList<> ();
            membre m;
        try {
           
            String req="select * from membre";
            pst= connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while(resultat.next())
            {
                m = new membre();
                m.setId_membre(resultat.getInt(1));
                m.setCin(resultat.getInt(3));
                m.setNom(resultat.getString(4));
                m.setPrenom(resultat.getString(5));
                m.setAge(resultat.getString(6));
                m.setPays(resultat.getString(7));
                m.setSexe(resultat.getString(8));
                m.setMail(resultat.getString(9));
                m.setPwd(resultat.getString(10));
                
                m.setTypeMembre(resultat.getString(12));
                m.setEtat_membre(resultat.getString(13));
                
                listeMembres.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(membreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeMembres;
    }
    
    
    
    public List<publication> findAllPub() {
       List<publication> listePubs = new ArrayList<> ();
            publication m;
        try {
           
            String req="select * from publication";
            pst= connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while(resultat.next())
            {
                m = new publication();
                 m.setIdPub(resultat.getInt(1));
                m.setIdmembre(resultat.getInt(2));
                m.setDate(resultat.getString(3));
                m.setTypepub(resultat.getString(4));
                m.setContenu(resultat.getString(5));
                m.setEtatpub(resultat.getString(6));
                
                
               
                
                listePubs.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(membreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listePubs;
    }

    @Override
    public membre findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerpub() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public admin findObjectByLoginPassword(String mail,String pwd) {
        boolean exist=false;
        admin r = new admin();
        String requete = "select * from admin where mail = ? and pwd= ?";
        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, mail);
            pst.setString(2, pwd);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                r.setIdadmin(resultat.getInt(1));
                r.setMail(resultat.getString(6));
                r.setPwd(resultat.getString(7));
                exist=true;
             
            }
            if(exist){
                return r;
            }
    return null;
    } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }    }
    
    
    
    
}