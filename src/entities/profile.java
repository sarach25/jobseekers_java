/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author user
 */
public class profile {
    private int idprofil;
    private int idmemebre;
    private int idcompetance;
    private String statut_ac;
    private String curus_ac;
    private String cursus_pro;
    private String resume;
public profile(){
    
}
    public profile(int idmemebre, int idcompetance, String statut_ac, String curus_ac, String cursus_pro, String resume) {
        this.idmemebre = idmemebre;
        this.idcompetance = idcompetance;
        this.statut_ac = statut_ac;
        this.curus_ac = curus_ac;
        this.cursus_pro = cursus_pro;
        this.resume = resume;
    }

    public int getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(int idprofil) {
        this.idprofil = idprofil;
    }

    public int getIdmemebre() {
        return idmemebre;
    }

    public void setIdmemebre(int idmemebre) {
        this.idmemebre = idmemebre;
    }

    public int getIdcompetance() {
        return idcompetance;
    }

    public void setIdcompetance(int idcompetance) {
        this.idcompetance = idcompetance;
    }

    public String getStatut_ac() {
        return statut_ac;
    }

    public void setStatut_ac(String statut_ac) {
        this.statut_ac = statut_ac;
    }

    public String getCurus_ac() {
        return curus_ac;
    }

    public void setCurus_ac(String curus_ac) {
        this.curus_ac = curus_ac;
    }

    public String getCursus_pro() {
        return cursus_pro;
    }

    public void setCursus_pro(String cursus_pro) {
        this.cursus_pro = cursus_pro;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
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
        final profile other = (profile) obj;
        if (this.idprofil != other.idprofil) {
            return false;
        }
        if (this.idmemebre != other.idmemebre) {
            return false;
        }
        if (this.idcompetance != other.idcompetance) {
            return false;
        }
        if (!Objects.equals(this.statut_ac, other.statut_ac)) {
            return false;
        }
        if (!Objects.equals(this.curus_ac, other.curus_ac)) {
            return false;
        }
        if (!Objects.equals(this.cursus_pro, other.cursus_pro)) {
            return false;
        }
        if (!Objects.equals(this.resume, other.resume)) {
            return false;
        }
        return true;
    }
    
}
