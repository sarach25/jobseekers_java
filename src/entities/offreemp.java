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
public class offreemp {
    private int idOffre;
    private String contenuoffre;
    private int idMembre;
    private String nomEntreprise;
    private String poste;
    private String domaine;
    
    public offreemp() {
    }
    public offreemp(int idMembre, String contenuoffre, String nomEntreprise, String poste, String domaine) {
        this.idMembre = idMembre;
         this.contenuoffre = contenuoffre;
        this.nomEntreprise = nomEntreprise;
        this.poste = poste;
        this.domaine = domaine;
       
    }
    public int getIdOffre() {
        return idOffre;
    }
    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }
 public int getIdMembre() {
        return idMembre;
    }
    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }
    public String getNomEntreprise() {
        return nomEntreprise;
    }
    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }
    public String getPoste() {
        return poste;
    }
    public void setPoste(String poste) {
        this.poste = poste;
    }
    public String getDomaine() {
        return domaine;
    }
    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
    public String getContenuoffre() {
        return contenuoffre;
    }
    public void setContenuoffre(String contenuoffre) {
        this.contenuoffre = contenuoffre;
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
        final offreemp other = (offreemp) obj;
        if (this.idOffre != other.idOffre) {
            return false;
        }
       /* if (this.idMembre != other.idMembre) {
            return false;
        }*/
        return true;
    }
    
    @Override
    public String toString() {
        return "offreemp{" + "idOffre=" + idOffre + ", nomEntreprise=" + nomEntreprise + ", poste=" + poste + ", domaine=" + domaine + ", contenuoffre=" + contenuoffre + '}';
    }
 
    
    
    
    
    
}