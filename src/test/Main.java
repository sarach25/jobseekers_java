/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.*;
import entities.*;

/**
 *
 * @author bejaoui
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //membre m1 = new membre(142345676, "malek", "bejaoui", "lbera7 ", "tunis","homme", "malek.bejaoui@esprit.tn","12345678", "url", "premium");
        //membre m2 = new membre(142345, "mohamed", "bejaoui", "2015-10-10", "tunis","homme", "malek.bejaoui@esprit.tn","12345688", "url", "premium");
        //message msg=new message(142345678, "helloworld");
        //groupe grp =new groupe("esprit", "txt", "desktop/imgfile");
       
        //messageDAO mdao=new messageDAO();
        //membreDAO pdao=new membreDAO();
        //pdao.add(m2);
        //groupeDAO grpdao= new groupeDAO();
        //grpdao.add(grp);
        //pdao.addGroup(m2, grp);*/
        
        
        //publication pb3 =new publication( "12/12/2016", "statut", "hello samedi", "desktop/imgfile");
        commentaire com =new commentaire(14,"aymen bnjr dd ", "12/12/2016");
        publicationSig sg=new publicationSig(13,"12/12/2016", "klam zayed");
        
        //publicationDAO pbdao=new publicationDAO();
        //pbdao.add(pb3);
        membreDAO pdao=new membreDAO();
       // commentaireDAO mdao=new commentaireDAO();
        //pdao.add(m2);
        //pdao.addPub(m2, pb2);
        
        //pdao.ajouterCommentaire(m2,com);
       // pdao.signalerpub(m2, sg);
       //pdao.addcontact(m2, c);
        //pdao.add(m2);
       //pdao.add(m1);
       //m1.setId_membre(0);
       //m2.setId_membre(0);
       //pdao.addcontact(m1,m2);
        //offreemp ofem =new offreemp(142345676, "2ija taw tefhem","esprit", "chawech", "9hawi");
        //pdao.addOffre(m2, ofem);
        message msg=new message(142345610,"fadiiiiiiit");
        
       // pdao.envoimsg(m2, msg);
        
        //pdao.findById(12);
        
        

        
        
        
        
       

        
       
        
    }
    
}
