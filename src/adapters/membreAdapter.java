/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import DAO.adminDAO;
import entities.membre;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class membreAdapter extends AbstractTableModel{
     List<membre> membres;
     String[] data = {"idmembre","idAdmin", "cin","nom", "prenom" ,"age" ,"pays", "sexe","mail","pwd","type membre","etat membre"};
     public membreAdapter()
     {
         membres = new adminDAO().findAll();
         
     }
     
     public String getColumnName(int column) {
      
       return data[column];
    }

    @Override
    public int getRowCount() {
        return membres.size();
    }

    @Override
    public int getColumnCount() {
         return 12;   
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
{
    case 0:
       return membres.get(rowIndex).getId_membre();
    case 1 :
            return 98765432;
    case 2 :
            return membres.get(rowIndex).getCin();
    case 3:
      return membres.get(rowIndex).getNom();
    case 4:
         return membres.get(rowIndex).getPrenom();
    case 5:
       return membres.get(rowIndex).getAge();   
    case 6:
       return membres.get(rowIndex).getPays();   
    case 7:
        return membres.get(rowIndex).getSexe();
    case 8:
        return membres.get(rowIndex).getMail();
    case 9:
       return "**********";
    case 10:
        return membres.get(rowIndex).getTypeMembre();
    case 11:
        return membres.get(rowIndex).getEtat_membre();

    default:
        return null;
} 
    }
    
}
