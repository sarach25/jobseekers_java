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
public class CompetancesAff {
    private int idcompaff;
    private int idcomp;
    private int idmembre;

    public CompetancesAff() {
    }

    public CompetancesAff(int idcomp, int idmembre) {
        this.idcomp = idcomp;
        this.idmembre = idmembre;
    }

    public int getIdcompaff() {
        return idcompaff;
    }

    public void setIdcompaff(int idcompaff) {
        this.idcompaff = idcompaff;
    }

    public int getIdcomp() {
        return idcomp;
    }

    public void setIdcomp(int idcomp) {
        this.idcomp = idcomp;
    }

    public int getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(int idmembre) {
        this.idmembre = idmembre;
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
        final CompetancesAff other = (CompetancesAff) obj;
        if (this.idcompaff != other.idcompaff) {
            return false;
        }
        if (this.idcomp != other.idcomp) {
            return false;
        }
        if (this.idmembre != other.idmembre) {
            return false;
        }
        return true;
    }
    
    

   
    
    
}
