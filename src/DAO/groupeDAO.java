/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.GroupeFrame;
import entities.groupe;
import interfaces.IDAOG;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author bejaoui
 */
public class groupeDAO implements IDAOG<groupe>{
    private Connection connection;
    private PreparedStatement pst;
    
    public groupeDAO()
    {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(groupe p) {
        try {
            String req= "insert into groupe(nomGroupe,contenuGroupe,imGroupe) values (?,?,?)";
            InputStream is = new FileInputStream(new File(GroupeFrame.s));
            
            
            pst = connection.prepareStatement(req);
            
           // pst.setInt(1,p.getId());
            pst.setString(1, p.getNomGroupe());
            pst.setString(2, p.getContenuGroupe());
            pst.setBlob(3, is);
            
            
            
            pst.executeUpdate();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(groupeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void update(groupe p, int id) {
            
        try {
            String req="update groupe set nomGroupe=?,contenuGroupe=?,imGroupe=? where id=?";
            
            
            pst = connection.prepareStatement(req);
            pst.setInt(1,p.getIdGroupe());
            pst.setString(2, p.getContenuGroupe());
            pst.setString(3, p.getImGroupe());
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(groupeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    @Override
    public void removeById(int id) {
        
        try {
            String req="DELETE FROM groupe WHERE idGroupe=?";
            
            
            pst = connection.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();    
        } catch (SQLException ex) {
            Logger.getLogger(groupeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<groupe> findAll() {
        
            List<groupe> listegroupe = new ArrayList<> ();
            groupe p;
            try{
            String req="select `idGroupe`,`nomGroupe`,`contenuGroupe` from groupe";
            pst= connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while(resultat.next())
            {
                p = new groupe();
                //p.setIdPub(resultat.getInt(1));
                p.setIdGroupe(resultat.getInt(1));
                p.setNomGroupe(resultat.getString(2));
                p.setContenuGroupe(resultat.getString(3));
                listegroupe.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(groupeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listegroupe;    
            
    }

    @Override
    public groupe findById(int id) {
        return null;
    }
    
   
    
    
    
}