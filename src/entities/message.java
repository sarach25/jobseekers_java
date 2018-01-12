/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Slim Ben Elhaj
 */
public class message {

    private int idmembre;
    private int idreceveur;
    private int idMessage;
    private String contenuM;
    private String date;

    public message() {
    }

    public message(int idreceveur, String contenuM) {
        this.idreceveur = idreceveur;
        this.contenuM = contenuM;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    

    public int getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(int idmembre) {
        this.idmembre = idmembre;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getContenuM() {
        return contenuM;
    }

    public void setContenuM(String contenuM) {
        this.contenuM = contenuM;
    }

    public int getIdreceveur() {
        return idreceveur;
    }

    public void setIdreceveur(int idreceveur) {
        this.idreceveur = idreceveur;
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
        final message other = (message) obj;
        if (this.idmembre != other.idmembre) {
            return false;
        }
        if (this.idMessage != other.idMessage) {
            return false;
        }
        if (!Objects.equals(this.contenuM, other.contenuM)) {
            return false;
        }
        return true;
    }
    

   

}