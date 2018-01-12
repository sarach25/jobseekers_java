/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author bejaoui
 */
public class membre {
    private int id_membre;
    private int cin;
    private String nom;
    private String prenom;
    private String age;
    private String pays;
    private String sexe;
    private String mail;
    private String pwd;
    private String imgUrl;
    private String typeMembre;
    private String etat_membre;
   
    

public membre(){

}

    public membre(int cin, String nom, String prenom, String age, String pays, String sexe, String mail, String pwd, String imgUrl, String typeMembre, String etat_membre) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.pays = pays;
        this.sexe = sexe;
        this.mail = mail;
        this.pwd = pwd;
        this.imgUrl = imgUrl;
        this.typeMembre = typeMembre;
        this.etat_membre = etat_membre;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }
    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin= cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTypeMembre() {
        return typeMembre;
    }

    public void setTypeMembre(String typeMembre) {
        this.typeMembre = typeMembre;
    }

    public String getEtat_membre() {
        return etat_membre;
    }

    public void setEtat_membre(String etat_membre) {
        this.etat_membre = etat_membre;
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
        final membre other = (membre) obj;
        if (this.id_membre != other.id_membre) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (!Objects.equals(this.pwd, other.pwd)) {
            return false;
        }
        return true;
    }

   

    


    

}