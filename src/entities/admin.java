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
public class admin {
    private int idadmin;
    private String mail;
    private String pwd;
    
//constructeur
    public admin() {
        
    }
    public admin(int idadmin, String mail, String pwd) {
        this.idadmin = idadmin;
        this.mail = mail;
        this.pwd = pwd;
    }
    //getters ans setters

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
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
    //equals

    @Override
    public int hashCode() {
        int hash = 5;
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
        final admin other = (admin) obj;
        if (this.idadmin != other.idadmin) {
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
    
    //toString()

    @Override
    public String toString() {
        return "admin{" + "idadmin=" + idadmin + ", mail=" + mail + ", pwd=" + pwd + '}';
    }
    
    
    
    
}