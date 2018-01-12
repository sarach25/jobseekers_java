/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import GUI.EntrepriseFrame;
import GUI.GroupeFrame;
import GUI.RegisterFrame;
import entities.*;
import interfaces.IDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

//import java.sql.Date;
/**
 *
 * @author bejaoui
 */
public class membreDAO implements IDAO<membre>{
    private Connection connection;
    private PreparedStatement pst;
    
    
    
    List<membre> lst = new ArrayList<membre>();
    
        public membreDAO()
    {
        //initialiser la connection;
        connection = DataSource.getInstance().getConnection();
    }
        
        public boolean exist (membre m)
        {
            boolean b=false;
            try
            {
                ResultSet r = pst.executeQuery(" Select * from membre where idmembre='"+m.getId_membre()+"'and pwd= '"+m.getPwd()+"'");
                b=r.next();
                
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            return b;
        }

    @Override
    public void add(membre p) {
        try {
            String req="insert into membre(cin,nom,prenom,age,pays,sexe,mail,pwd,imgUrl,idadmin) values (?,?,?,?,?,?,?,?,?,?)";
           InputStream is = new FileInputStream(new File(RegisterFrame.s));
           
                   
            
            pst = connection.prepareStatement(req);
            pst.setInt(1, p.getCin());
            pst.setString(2, p.getNom());
            pst.setString(3, p.getPrenom());
            pst.setString(4, p.getAge());
            pst.setString(5, p.getPays());
            pst.setString(6, p.getSexe());
            pst.setString(7, p.getMail());
            
            String password=p.getPwd();
            MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	
            String pwd=hexString.toString();
            
            pst.setString(8, pwd);
            }
            pst.setBlob(9,is);
            
            pst.setInt(10,123456);
            
            
            
            
            pst.executeUpdate();
        } catch (SQLException | NoSuchAlgorithmException | FileNotFoundException ex) {
            Logger.getLogger(membreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(membre p, int idmembre) {
        try {
            String req="update membre set nom=?,prenom=?,age=?where idmembre=?";
            
            
            pst = connection.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            
            //pst.setInt(3, p.getAge());
            
            
            pst.setInt(3, idmembre);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(membreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int idmembre) {
        try {
            String req="DELETE FROM membre WHERE idmembre=?";
            
            
            pst = connection.prepareStatement(req);
            pst.setInt(1, idmembre);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(membreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<membre> findAll() {
        List<membre> listemembres = new ArrayList<> ();
            membre p;
        try {
           
            String req="select nom,prenom,age,pays,sexe,mail,imgUrl,typeMembre,etatmembre from membre";
            pst= connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while(resultat.next())
            {
                p = new membre();
                //p.setId_membre(resultat.getInt(1));
                p.setNom(resultat.getString(1));
                p.setPrenom(resultat.getString(2));
                p.setAge(resultat.getString(2));
                p.setPays(resultat.getString(3));
                p.setSexe(resultat.getString(4));
                
                p.setMail(resultat.getString(5));
               //p.setPwd(resultat.getString(8));
                p.setImgUrl(resultat.getString(6));
                p.setTypeMembre(resultat.getString(7));
                p.setEtat_membre(resultat.getString(8));
                
                
                listemembres.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(membreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listemembres;
    }

    
    /*public membre findById(int id) {
      //membreDAO mdao = new membreDAO;
      
    }*/
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

    public membre findinputById(int id) {
membre r = new membre();
        String requete = "select * from membre where idmembre = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                
                r.setNom(resultat.getString(3));
                r.setPrenom(resultat.getString(4));
                
                r.setMail(resultat.getString(8));
                
                
             
            }
            return r;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du user " + ex.getMessage());
            return null;
        }    
    }
   public membre findObjectById(int id) {
membre r = new membre();
        String requete = "select * from membre where idmembre = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1, id);
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
    

public membre findObjectByLoginPassword(String mail,String pwd) {
        boolean exist=false;
        membre r = new membre();
        String requete = "select * from membre where mail = ? and pwd= ?";
        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, mail);
            pst.setString(2, pwd);
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
/*
    @Override
    public void envoimsg(membre m, message msg) {
        messageDAO mg = new messageDAO();
        List lm = mg.findAll();
        message x = new message();
        x = (message) lm.get(lm.size() - 1);
        
        
        try {
            String req = "insert into message (idmembre,idreceveur,contenuM) values (?,?,?)";
            
            //String req3="select count (*) from message";
            
            pst = connection.prepareStatement(req);

            pst.setInt(1, m.getId_membre());
            pst.setInt(2, msg.getIdreceveur());
            pst.setString(3, msg.getContenuM());
            pst.executeUpdate();
            
            //pst = connection.prepareStatement(req3);
            //ResultSet resultat = pst.executeQuery();
            //int last=resultat.getInt(1);
            String req2 = "INSERT INTO `notification`( `idmessage`, `idmembre_rec`, `contenu_n`) VALUES(?,?,?)";
            pst = connection.prepareStatement(req2);
            pst.setInt(1,x.getIdMessage()+1);
            pst.setInt(2,msg.getIdreceveur());
            pst.setString(3,"message");
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(messageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
    
    
    */
    
    
    
   
    @Override
    public void envoimsg(membre m, message msg) {
        try {
            String req = "insert into message (idmembre,idreceveur,contenuM) values (?,?,?)";

            pst = connection.prepareStatement(req);

            pst.setInt(1, m.getId_membre());
            pst.setInt(2, msg.getIdreceveur());
            pst.setString(3, msg.getContenuM());
            

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(messageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
  
   
     
    public void createnotif(message m, notification n) {
        try {
            String req = "INSERT INTO `notification`( `idmessage`, `idmembre_rec`, `contenu_n`) VALUES(?,?,?)";
          
             pst = connection.prepareStatement(req);
            pst.setInt(1,m.getIdMessage());
            pst.setInt(2,m.getIdreceveur());
            pst.setString(3,n.getContenuNotif());
            
            
            
             pst.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(membreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/*
    @Override
    public void addGroup(membre m, groupe p) {
        try {
            String req = "insert into groupe (idmembre,nomgroupe,contenu,urlimg) values (?,?,?,?)";

            pst = connection.prepareStatement(req);

            pst.setInt(1, m.getId_membre());
            pst.setString(2, p.getNomGroupe());
            pst.setString(3, p.getContenu());
            pst.setString(4, p.getUrlImg());
            

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(messageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    @Override
    public void addPub(membre m, publication p){
         try {
            String req = "insert into publication (idmembre,date,typepub,contenu,urlimg) values (?,?,?,?,?)";

            pst = connection.prepareStatement(req);

            pst.setInt(1, m.getId_membre());
            pst.setString(2, p.getDate());
            pst.setString(3, p.getTypepub());
            pst.setString(4, p.getContenu());
            pst.setString(5, p.getUrlimg());
            

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(messageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void ajouterCommentaire(membre m,commentaire c)
    {
        try {
            String req = "INSERT INTO `commentaire`(`idmembre`, `idpublication`, `CONTENUC`, `DATECOMMENTAIRE`) VALUES (?,?,?,?)";
            pst = connection.prepareStatement(req);
            
            //pst.setInt(0, 0);
            pst.setInt(1, m.getId_membre());
            pst.setInt(2,c.getIdPub());
            pst.setString(3,c.getContenuC());
            pst.setString(4,c.getDateCommentaire());
            
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(commentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    @Override
    public void signalerpub(membre m, publicationSig p) {
          String req = "insert into signale (idmembre,idpub,datesign,raison) values (?,?,?,?)";

        try {
            pst = connection.prepareStatement(req);
            
            pst.setInt(1, m.getId_membre());
            pst.setInt(2, p.getIdpub());
            pst.setString(3,p.getDate());
            pst.setString(4, p.getRaison());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(publicationsigDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void addcontact(membre m1,membre m2)
    {
        try {
            String req = "insert into membre_contact (idmembre,idmembre_ami) values (?,?)";
            String req2 = "insert into membre_contact (idmembre,idmembre_ami) values (?,?)";
            
            
             pst = connection.prepareStatement(req);
            pst.setInt(1,m1.getId_membre());
            pst.setInt(2,m2.getId_membre());
             pst.executeUpdate();
             
             pst = connection.prepareStatement(req2);
            pst.setInt(2,m1.getId_membre());
            pst.setInt(1,m2.getId_membre());
             pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(membreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public void addOffre(membre m, offreemp p){
         try {
            String req = "INSERT INTO `offre_emp`( `IDMEMBRE`, `NOMENTREPRISE`, `POSTE`, `DOMAINE`, `CONTENUOFFRE`) VALUES(?,?,?,?,?)";
          
             pst = connection.prepareStatement(req);
            pst.setInt(1,m.getId_membre());
            pst.setString(2,p.getNomEntreprise());
            pst.setString(3,p.getPoste());
            pst.setString(4,p.getDomaine());
            pst.setString(5,p.getContenuoffre());
            
             pst.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(membreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<membre> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public  boolean isValidEmailAddress(String mail) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(mail);
           return m.matches();
    }
    
    public void addEntreprise(membre m, entreprise p) {
        try {
            String req = "insert into entreprise (nomEntreprise,domaine,adresse,ImgEntreprise) values (?,?,?,?)";
            InputStream is = new FileInputStream(new File(EntrepriseFrame.se));
            
            pst = connection.prepareStatement(req);
            
            pst.setString(1, p.getNomEntreprise());
            pst.setString(2, p.getDomaine());
            pst.setString(3, p.getAdresse());
            pst.setBlob(4, is);
            

            pst.executeUpdate();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(entrepriseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void addGroup(membre m, groupe p) {
        try {
            String req = "insert into groupe (nomGroupe,contenuGroupe,ImGroupe) values (?,?,?)";
            InputStream is = new FileInputStream(new File(GroupeFrame.s));
            
            pst = connection.prepareStatement(req);
            
            pst.setString(1, p.getNomGroupe());
            pst.setString(2, p.getContenuGroupe());
            pst.setBlob(3, is);
            

            pst.executeUpdate();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(messageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<offreemp> findAlloffre() {
  
     List<offreemp> listeemp = new ArrayList<> ();
            offreemp m;
        try {
           
            String req="select * from offre_emp";
            pst= connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery();
            while(resultat.next())
            {
                
                m = new offreemp();
                 m.setNomEntreprise(resultat.getString(3));
                m.setPoste(resultat.getString(4));
                m.setDomaine(resultat.getString(5));
                m.setContenuoffre(resultat.getString(6));
               
                
                
               
                
                listeemp.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(membreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeemp;}
}



  