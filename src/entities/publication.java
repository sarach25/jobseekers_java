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
public class publication {

    private int idPub;
    private int idmembre;
    private  String date;
    private String typepub;
    private String contenu;
    private String urlimg;
    private String etatpub;
public publication(){
    
}

    public publication( int idmembre, String date, String typepub, String contenu, String urlimg, String etatpub) {
        
        this.idmembre = idmembre;
        this.date = date;
        this.typepub = typepub;
        this.contenu = contenu;
        this.urlimg = urlimg;
        this.etatpub = etatpub;
    }

    public int getIdPub() {
        return idPub;
    }

    public void setIdPub(int idPub) {
        this.idPub = idPub;
    }

    public int getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(int idmembre) {
        this.idmembre = idmembre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTypepub() {
        return typepub;
    }

    public void setTypepub(String typepub) {
        this.typepub = typepub;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

    public String getEtatpub() {
        return etatpub;
    }

    public void setEtatpub(String etatpub) {
        this.etatpub = etatpub;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final publication other = (publication) obj;
        if (this.idPub != other.idPub) {
            return false;
        }
        if (this.idmembre != other.idmembre) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.typepub, other.typepub)) {
            return false;
        }
        if (!Objects.equals(this.contenu, other.contenu)) {
            return false;
        }
        if (!Objects.equals(this.urlimg, other.urlimg)) {
            return false;
        }
        if (!Objects.equals(this.etatpub, other.etatpub)) {
            return false;
        }
        return true;
    }
    

    
    
    
    
    
    
    
    
    



}