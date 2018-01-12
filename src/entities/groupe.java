/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author bejaoui
 */
public class groupe {
    private int idGroupe;
    private String nomGroupe;
    private String contenuGroupe;
    private String imGroupe;
    
    public groupe()
    {
        
    }

    public groupe(String nomGroupe, String contenuGroupe, String imGroupe) {
      //  this.id = id;
        this.nomGroupe = nomGroupe;
        this.contenuGroupe = contenuGroupe;
        this.imGroupe = imGroupe;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getContenuGroupe() {
        return contenuGroupe;
    }

    public void setContenuGroupe(String contenuGroupe) {
        this.contenuGroupe = contenuGroupe;
    }

    public String getImGroupe() {
        return imGroupe;
    }

    public void setImGroupe(String imGroupe) {
        this.imGroupe = imGroupe;
    }

    @Override
    public String toString() {
        return "groupe{" + "id=" + idGroupe + ", nomGroupe=" + nomGroupe + ", contenu=" + contenuGroupe + ", Image=" + imGroupe + '}';
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
        final groupe other = (groupe) obj;
        if (this.idGroupe != other.idGroupe) {
            return false;
        }
        return true;
    }
    
}