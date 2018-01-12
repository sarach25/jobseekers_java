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
public class Competances {
    private int idcomp;
    private String nomcompetance;

    public Competances() {
    }

    public Competances(int idcomp, String nomcompetance) {
        this.idcomp = idcomp;
        this.nomcompetance = nomcompetance;
    }

    public Competances(String nomcompetance) {
        this.nomcompetance = nomcompetance;
    }

    public int getIdcomp() {
        return idcomp;
    }

    public void setIdcomp(int idcomp) {
        this.idcomp = idcomp;
    }

    public String getNomcompetance() {
        return nomcompetance;
    }

    public void setNomcompetance(String nomcompetance) {
        this.nomcompetance = nomcompetance;
    }

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
        final Competances other = (Competances) obj;
        if (this.idcomp != other.idcomp) {
            return false;
        }
        if (!Objects.equals(this.nomcompetance, other.nomcompetance)) {
            return false;
        }
        return true;
    }

       
}
