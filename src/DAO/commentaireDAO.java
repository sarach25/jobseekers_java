/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import entities.*;
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
public class commentaireDAO implements IDAO_comm<commentaire> {
    private Connection connection;
    private PreparedStatement pst;
    
    public commentaireDAO()
    {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(commentaire p) {
        try {
            String req= "insert into commentaire(contenuC,dateCommentaire) values (?,?)";
            pst = connection.prepareStatement(req);
            
            
            pst.setString(1, p.getContenuC());
            pst.setString(2, p.getDateCommentaire());
            
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(commentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(commentaire p, int idCommentaire) {
        try {
            String req="update commentaire set contenuC=?,dateCommenatire=? where idCommentaire=?";
            
            
            pst = connection.prepareStatement(req);
            pst.setInt(1,p.getIdCommentaire());
            pst.setString(2, p.getContenuC());
            pst.setString(3, p.getDateCommentaire());
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(commentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int idCommentaire) {
        try {
            String req="DELETE FROM commentaire WHERE idCommentaire=?";
            
            
            pst = connection.prepareStatement(req);
            pst.setInt(1, idCommentaire);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(commentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<commentaire> findAll() {
        
            List<commentaire> listecommentaire = new ArrayList<> ();
            commentaire p;
        try{
            
            String req="select `IDCOMMENTAIRE`,`CONTENUC`,`DATECOMMENTAIRE` from commentaire";
            pst= connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while(resultat.next())
            {
                p = new commentaire();
                //p.setIdPub(resultat.getInt(1));
                p.setIdCommentaire(resultat.getInt(1));
                p.setContenuC(resultat.getString(2));
                p.setDateCommentaire(resultat.getString(3));
                listecommentaire.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(commentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listecommentaire;
    }

    @Override
    public commentaire findById(int idCommentaire) {
        return null;
    }
    
    

    
}