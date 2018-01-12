/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.util.Objects;
/**
 *
 * @author bejaoui
 */
public class commentaire {
    private int idPub;
    private int idCommentaire;
    private String contenuC;
    private String dateCommentaire;
    
    public commentaire()
    {
        
    }

    public commentaire(int idPub, String contenuC, String dateCommentaire) {
        this.idPub = idPub;
        //this.idCommentaire = idCommentaire;
        this.contenuC = contenuC;
        this.dateCommentaire = dateCommentaire;
    }
    

    public commentaire(  String contenuC, String dateCommentaire) {
        
        
        this.contenuC = contenuC;
        this.dateCommentaire = dateCommentaire;
    }

    public int getIdPub() {
        return idPub;
    }

    public void setIdPub(int idPub) {
        this.idPub = idPub;
    }

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public String getContenuC() {
        return contenuC;
    }

    public void setContenuC(String contenuC) {
        this.contenuC = contenuC;
    }

    public String getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(String dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    @Override
    public String toString() {
        return "commentaire{" + "idCommentaire=" + idCommentaire + ", contenuC=" + contenuC + ", dateCommentaire=" + dateCommentaire + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final commentaire other = (commentaire) obj;
        if (this.idCommentaire != other.idCommentaire) {
            return false;
        }
        return true;
    }
    
}