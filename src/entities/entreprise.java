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
public class entreprise {

    private int idEntreprise;
    private String nomEntreprise;
    private String domaine;
    private String adresse;
    private byte[] image;

    public entreprise() {

    }

    public entreprise(String nomEntreprise, String domaine, String adresse, byte[] image) {
        this.nomEntreprise = nomEntreprise;
        this.domaine = domaine;
        this.adresse = adresse;
         this.image = image;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public byte[] getImage() {
        return image;
    }

    
@Override
        public int hashCode() {
        int hash = 8;
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
        final entreprise other = (entreprise) obj;
        if (this.idEntreprise != other.idEntreprise) {
            return false;
        }
        return true;
    }
    
}
