/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import entities.message;
import interfaces.IDAOMSG;
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
public class messageDAO implements IDAOMSG<message> {

    private Connection connection;
    private PreparedStatement pst;

    public messageDAO() {

        connection = DataSource.getInstance().getConnection();

    }

    @Override
    public void add(message t) {
        try {
            String req = "insert into message (idMessage, contenuM ) values (?,?,?)";

            pst = connection.prepareStatement(req);

            pst.setInt(1,t.getIdMessage());
            pst.setString(2, t.getContenuM());
            

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(messageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(message t, int idMessage) {
        try {
            String req = "update message set idMessage=?,contenuM=?";

            pst = connection.prepareStatement(req);
            pst.setInt(1, t.getIdMessage());
            pst.setString(2, t.getContenuM());

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(messageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int idMessage) {
        try {
            String req = "DELETE FROM message WHERE idMessage=?";

            pst = connection.prepareStatement(req);
            pst.setInt(1, idMessage);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(messageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<message> findAll() {
        List<message> listemessages = new ArrayList<>();
        message t;
        try {
            String req = "select * from message";
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {

                t = new message();
                t.setIdMessage(resultat.getInt(1));
                t.setContenuM(resultat.getString(2));
                listemessages.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(messageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listemessages;
    }

    @Override
    public message findById(int idMessage) {
        return null;
    }
    
    
     public message findmessagebyContenu(String contenuM) {
message r = new message();
        String requete = "select idmessage from message where contenum = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, contenuM);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                r.setIdMessage(resultat.getInt(1));
                
                
             
            }
            return r;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }    
    }

   
    
    


}