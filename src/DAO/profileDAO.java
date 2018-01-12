/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import entities.*;
import interfaces.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
import java.util.Date;
/**
 *
 * @author user
 */
public class profileDAO {
    private Connection connection;
    private PreparedStatement pst;
    
    List<membre> lst = new ArrayList<membre>();
    
    
    
    public profileDAO()
    {
        //initialiser la connection;
        connection = DataSource.getInstance().getConnection();
    }
     /*public boolean exist (profile p)
        {
            boolean b=false;
            try
            {
                ResultSet r = pst.executeQuery(" Select * from profile where idmembre='"+p.getIdmemebre()+"'and pwd= '"+m.getPwd()+"'");
                b=r.next();
                
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            return b;
        }*/
    
    public void add(profile p,int idmembre) {
        try {
            String req="update membre set statut_ac=?,cursus_ac=?,cursus_pro=?,resume=? where idmembre=?";
           
            
            pst = connection.prepareStatement(req);
            pst.setString(1, p.getStatut_ac());
            pst.setString(2, p.getCurus_ac());
            pst.setString(3, p.getCursus_pro());
            pst.setString(4, p.getResume());
            pst.setInt(5, idmembre);
            
            
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(membreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public membre findObjectByMail(String mail) {
membre r = new membre();
        String requete = "select * from membre where mail = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, mail);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                r.setId_membre(resultat.getInt(1));
                r.setNom(resultat.getString(2));
                r.setPrenom(resultat.getString(3));
                //r.setDateNaissance(resultat.getDate(4));
                r.setPays(resultat.getString(4));
                r.setSexe(resultat.getString(5));
                r.setMail(resultat.getString(6));
                r.setPwd(resultat.getString(7));
                r.setImgUrl(resultat.getString(8));
                r.setTypeMembre(resultat.getString(9));
                
             
            }
            return r;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }    
    }
}
