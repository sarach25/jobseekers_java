/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.CompetancesAff;
import entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author user
 */
public class CompetancesDAO {
    
     private Connection connection;
    private PreparedStatement pst;
    
    public CompetancesDAO() {

        connection = DataSource.getInstance().getConnection();

    }
    
     public void add(membre m, CompetancesAff c) {
        try {
            String req = "insert into competanceaf ( idcompetance, idmembre ) values (?,?)";

            pst = connection.prepareStatement(req);
            
            pst.setInt(1,c.getIdcomp());
            pst.setInt(2,m.getId_membre());
            
            

            
            
            

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(messageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     
    public Competances findCompetanceByname(String nomcompetance) {
 Competances r = new Competances();
       String requete = "select * from competance where nom_competance = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, nomcompetance);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                r.setIdcomp(resultat.getInt(1));
                r.setNomcompetance(resultat.getString(2));
                
                
             
            }
            return r;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }    
    }
    
    
    
     

}
