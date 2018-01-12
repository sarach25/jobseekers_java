

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
import javax.swing.ImageIcon;
import utils.DataSource;

/**
 *
 * @author bejaoui
 */

public class publicationDAO {

    private Connection connection;
    private PreparedStatement pst;

    public publicationDAO() {

        connection = DataSource.getInstance().getConnection();

    }

    
    public void add(publication p) {
        try {
            String req = "insert into publication (contenu,date,typepub,urlimg,etatpub) values (?,?,?,?,?)";

            pst = connection.prepareStatement(req);

           
            pst.setString(1, p.getContenu());
            pst.setString(2, p.getDate());
            pst.setString(3, p.getTypepub());
            
            pst.setString(4, p.getUrlimg());
            pst.setString(5, p.getEtatpub());
            
         /*   pst.setString(2, p.getTypepub());
            pst.setString(3, p.getContenu());
            pst.setString(4, p.getUrlimg());*/

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(publicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public void update(publication p, int idPub) {
        try {
            String req = "UPDATE `publication` SET `DATE`=?,`typepub`=?,`contenu`=?,`urlimg`=? WHERE idpub=?";

            pst = connection.prepareStatement(req);
            pst.setString(1, p.getDate());
            pst.setString(2, p.getTypepub());
            pst.setString(3, p.getContenu());
            pst.setString(4, p.getUrlimg());
            
            pst.setInt(5, idPub);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(publicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void removeById(int idPub) {
        try {
            String req = "DELETE FROM publication WHERE idPub=?";

            pst = connection.prepareStatement(req);
            pst.setInt(1, idPub);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(publicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public List<publication> findAllPub() {
        List<publication> listepublications = new ArrayList<>();
        publication p;
        try {
            String req = "select * from publication";
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {

                p = new publication();
                p.setIdPub(resultat.getInt(1));
                p.setDate(resultat.getString(2));
                listepublications.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(publicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listepublications;
    }

    
    public publication findById(int idPub) {
        return null;
    }
    
    public String afficher()
    {
        String s;
        publication p=new publication() ;
        try {
            String req = "select * from publication where idpublication=1";
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            
           // p =new publication();
            p.setContenu(resultat.getString(1));
                
            //p.setContenu(resultat.getString());
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(publicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p.getContenu();
        
    }
    
    

}
