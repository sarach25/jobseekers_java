/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import entities.offreemp;
import interfaces.*;
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
public class offreempDAO  implements IDAOOFFRE<offreemp> {
    private Connection connection;
    private PreparedStatement pst;
    public offreempDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    @Override
    public void add(offreemp t) {
          try {
        String req = "insert into offre_emp (idOffre,contenuoffre,nomEntreprise,poste,domaine) values (?,?,?,?,?)";
 
            pst = connection.prepareStatement(req);
        
            pst.setInt(1, t.getIdOffre());
            pst.setString(2, t.getContenuoffre());
            pst.setString(3, t.getNomEntreprise());
            pst.setString(4, t.getPoste());
            pst.setString(5, t.getDomaine());
            
            
            pst.executeUpdate();
         } catch (SQLException ex) {
            Logger.getLogger(offreempDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void update(offreemp t, int idOffre) {
          try {
       String req = "update offre_emp set idOffre=?,contenuoffre=?,nomEntreprise=?,poste=?,domaine=?";
   
            pst = connection.prepareStatement(req);
        
            pst.setInt(1, t.getIdOffre());
            pst.setString(2, t.getContenuoffre());
             pst.setString(3, t.getNomEntreprise());
            pst.setString(4, t.getPoste());
            pst.setString(5, t.getDomaine());
            
            
            pst.executeUpdate();
         } catch (SQLException ex) {
            Logger.getLogger(offreempDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void removeById(int idOffre) {
          try {
        String req = "DELETE FROM message WHERE idOffre=?";
      
            pst = connection.prepareStatement(req);
     
            pst.setInt(1, idOffre);
            pst.executeUpdate();
      } catch (SQLException ex) {
            Logger.getLogger(offreempDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<offreemp> findAll() {
          List<offreemp> listeoffre = new ArrayList<>();
        offreemp t;
         try {
            String req = "SELECT * FROM offre_emp";
       
            pst = connection.prepareStatement(req);
       
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                t = new offreemp();
                t.setIdOffre(resultat.getInt(1));
                t.setContenuoffre(resultat.getString(2));
               listeoffre.add(t);
            }
         } catch (SQLException ex) {
            Logger.getLogger(offreempDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeoffre;
        
   
    }
    @Override
    public offreemp findById(int id) {
        return null;
  
    }
    public List<offreemp> findOffre(String poste) {
     List<offreemp> listeoffre = new ArrayList<>();
        offreemp p = new offreemp();

        String requete = "select * from offre_emp where poste= ? or domaine=?  or nomEntreprise=?  or contenuoffre=? ";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, poste);
            ps.setString(2, poste);
            ps.setString(3,poste);
            ps.setString(4, poste);

            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
              //  p.setIdb(resultat.getString(0));

                //p.setIdOffre(resultat.getInt(1));
                p.setContenuoffre(resultat.getString(6));
                p.setNomEntreprise(resultat.getString(3));
                p.setPoste(resultat.getString(4));
                p.setDomaine(resultat.getString(5));
                listeoffre.add(p);
                
            }return listeoffre;
            

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }
    }
 
    
}