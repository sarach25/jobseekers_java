/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import DAO.adminDAO;
import DAO.membreDAO;
import entities.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */



public class offreAdapter extends AbstractTableModel{
     List<offreemp> pubs;
     String[] data = {"Nom Entreprise","Poste", "Domaine", "Contenu Offre"};
     public offreAdapter ()
     {
         pubs = new membreDAO().findAlloffre();
         
     }
     
     public String getColumnName(int column) {
      
       return data[column];
    }

    @Override
    public int getRowCount() {
        return pubs.size();
    }

    @Override
    public int getColumnCount() {
         return 4;   
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
{
    case 0:
       return pubs.get(rowIndex).getNomEntreprise();
    case 1 :
            return pubs.get(rowIndex).getPoste();
    case 2:
      return pubs.get(rowIndex).getDomaine();
    case 3:
         return pubs.get(rowIndex).getContenuoffre();

    

    default:
        return null;
} 
    }
       
}
