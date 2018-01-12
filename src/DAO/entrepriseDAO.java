/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.EntrepriseFrame;
import entities.entreprise;
//import interfaces.IDAOE;
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
public class entrepriseDAO  {

    private Connection connection;
    private PreparedStatement pst;

    public entrepriseDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    
    public void add(entreprise p) {
        try {
            String req = "insert into entreprise(nomEntreprise,domaine,adresse,imgEntreprise) values (?,?,?,?)";
            InputStream is = new FileInputStream(new File(EntrepriseFrame.se));

            pst = connection.prepareStatement(req);

            // pst.setInt(1,p.getId());
            pst.setString(1, p.getNomEntreprise());
            pst.setString(2, p.getDomaine());
            pst.setString(3, p.getAdresse());
            pst.setBlob(4, is);

            pst.executeUpdate();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(entrepriseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void update(entreprise p, int id) {

        try {
            String req = "update entreprise set nomEntreprise=?,domaine=?,adresse=? where id=?";

            pst = connection.prepareStatement(req);
            pst.setInt(1, p.getIdEntreprise());
            pst.setString(2, p.getDomaine());
            pst.setString(3, p.getAdresse());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(entrepriseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void removeById(int id) {

        try {
            String req = "DELETE FROM entreprise WHERE idEntreprise=?";

            pst = connection.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(entrepriseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    public List<entreprise> findAll() {

        List<entreprise> listeentreprise = new ArrayList<>();
        entreprise p;
        try {
            String req = "select `idEntreprise`,`nomEntreprise`,`domaine`,`adresse` from entreprise";
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                p = new entreprise();
                //p.setIdPub(resultat.getInt(1));
                p.setIdEntreprise(resultat.getInt(1));
                p.setNomEntreprise(resultat.getString(2));
                p.setDomaine(resultat.getString(3));
                p.setAdresse(resultat.getString(4));
                listeentreprise.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(entrepriseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeentreprise;

    }

 
    public List<entreprise> findAllMe() {

        List<entreprise> listeEnt = new ArrayList<>();

        try {
            String req = "SELECT * FROM entreprise";
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();

            entreprise p;

            while (resultat.next()) {
                p = new entreprise(resultat.getString("nomEntreprise"), resultat.getString("Domaine"),
                        resultat.getString("Adresse"), resultat.getBytes("ImgEntreprise"));

                listeEnt.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(entrepriseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeEnt;
    }

    
   /* @Override
     public List<entreprise> getItemsList()
    {
        try {
            ResultSet rs = pst.executeQuery("SELECT * FROM entreprise");

            List<entreprise> list = new ArrayList<entreprise>();

            entreprise p;

            while(rs.next())
            {
               p = new entreprise(rs.getString("nomEntreprise"),rs.getString("Domaine"),
                      rs.getString("Adresse"),rs.getBytes("ImgEntreprise"));
               
               list.add(p);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

    
    public entreprise findById(int id) {
        return null;
    }


}
