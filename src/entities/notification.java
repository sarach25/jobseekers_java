/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Slim
 */
public class notification {

    private int idNotif;
    private int idmessage;
    private int idmembre;
    private String contenuNotif;
    
    public notification() {
        
    }
    public notification(String contenuNotif) {
        this.contenuNotif=contenuNotif;
    }
    public notification(int idmessage, String contenuNotif) {
        this.idmessage = idmessage;
        
        this.contenuNotif = contenuNotif;
    }

    public notification(int idNotif, int idmessage, int idmembre, String contenuNotif) {
        this.idNotif = idNotif;
        this.idmessage = idmessage;
        this.idmembre = idmembre;
        this.contenuNotif = contenuNotif;
    }
    

    public notification(int idmessage, int idmembre, String contenuNotif) {
        this.idmessage = idmessage;
        this.idmembre = idmembre;
        this.contenuNotif = contenuNotif;
    }
    public notification(int idmessage, int idmembre) {
        this.idmessage = idmessage;
        this.idmembre = idmembre;
        
    }

    public int getIdNotif() {
        return idNotif;
    }

    public void setIdNotif(int idNotif) {
        this.idNotif = idNotif;
    }

    public int getIdmessage() {
        return idmessage;
    }

    public void setIdmessage(int idmessage) {
        this.idmessage = idmessage;
    }

    public int getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(int idmembre) {
        this.idmembre = idmembre;
    }

    public String getContenuNotif() {
        return contenuNotif;
    }

    public void setContenuNotif(String contenuNotif) {
        this.contenuNotif = contenuNotif;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final notification other = (notification) obj;
        if (this.idNotif != other.idNotif) {
            return false;
        }
        if (this.idmessage != other.idmessage) {
            return false;
        }
        if (this.idmembre != other.idmembre) {
            return false;
        }
        if (!Objects.equals(this.contenuNotif, other.contenuNotif)) {
            return false;
        }
        return true;
    }
    
    

}