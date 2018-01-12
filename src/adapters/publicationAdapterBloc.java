/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import DAO.adminDAO;
import entities.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class publicationAdapterBloc extends AbstractTableModel{
     List<publication> pubs;
     String[] data = {"idpub","idmembre", "date", "typepub" ,"contenu","etatpub"};
     public publicationAdapterBloc ()
     {
         pubs = new adminDAO().findAllPub();
         
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
         return 6;   
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
{
    case 0:
       return pubs.get(rowIndex).getIdPub();
    case 1 :
            return pubs.get(rowIndex).getIdmembre();
    case 2:
      return pubs.get(rowIndex).getDate();
    case 3:
         return pubs.get(rowIndex).getTypepub();
    case 4:
         return pubs.get(rowIndex).getContenu();
    case 5 :
        return pubs.get(rowIndex).getEtatpub();
    

    default:
        return null;
} 
    }
    
}
