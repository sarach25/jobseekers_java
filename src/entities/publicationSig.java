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
public class publicationSig {
    private int idpubsing;
    private int idpub;
    private int idmembre;
    private String date;
    private String raison;

    public publicationSig(int idpub, String date, String raison) {
        this.idpub = idpub;
        
        this.date = date;
        this.raison = raison;
    }

    public int getIdpubsing() {
        return idpubsing;
    }

    public void setIdpubsing(int idpubsing) {
        this.idpubsing = idpubsing;
    }

    public int getIdpub() {
        return idpub;
    }

    public void setIdpub(int idpub) {
        this.idpub = idpub;
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

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
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
        final publicationSig other = (publicationSig) obj;
        if (this.idpubsing != other.idpubsing) {
            return false;
        }
        if (this.idpub != other.idpub) {
            return false;
        }
        if (this.idmembre != other.idmembre) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.raison, other.raison)) {
            return false;
        }
        return true;
    }

   
    
    
    
    
    
    
    
}
