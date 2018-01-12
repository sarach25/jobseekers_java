/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.*;
import interfaces.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Slim
 */
public class notificationDAO implements IDAOnot {

    private Connection connection;
    private PreparedStatement pst;

    public notificationDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(notification n) {
        try {
            String req = "insert into notification (idNotif, contenuNotif) values (?,?)";
            
            pst = connection.prepareStatement(req);

            pst.setInt(1, n.getIdNotif());
            pst.setString(2, n.getContenuNotif());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(notificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(notification n, int idNotif) {
        try {
            String req = "update notification set idNotif=?,contenuNotif=?";
            
            pst = connection.prepareStatement(req);
            pst.setInt(1, n.getIdNotif());
            pst.setString(2, n.getContenuNotif());
        } catch (SQLException ex) {
            Logger.getLogger(notificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int idNotif) {
        try {
            String req = "DELETE FROM notification WHERE idNotif=?";
            
            pst = connection.prepareStatement(req);
            pst.setInt(1, idNotif);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(notificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List findAll() {
        List<notification> listenotifications = new ArrayList<>();
        notification n;
        try {

            String req = "select id_notif, idmessage,idmembre_rec,contenu_n from notification";
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                n = new notification();
                n.setIdNotif(resultat.getInt(1));
                n.setContenuNotif(resultat.getString(2));
                listenotifications.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(membreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listenotifications;
    }

    @Override
    public notification findById(int idNotif) {
        return null;
    }

}