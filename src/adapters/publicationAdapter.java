/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import DAO.*;
import entities.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class publicationAdapter extends AbstractTableModel{
     List<publication> pubs;
     String[] data = {"date","contenu","image"};
     public publicationAdapter()
     {
         pubs = new publicationDAO().findAllPub();
         
     }
     
     @Override
     public String getColumnName(int column) {
      
       return data[column];
    }

    @Override
    public int getRowCount() {
        return pubs.size();
    }

    @Override
    public int getColumnCount() {
         return 3;   
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
{
    case 0:
       return pubs.get(rowIndex).getDate();
    case 1:
      return pubs.get(rowIndex).getContenu();
    case 2:
         return pubs.get(rowIndex).getUrlimg();
    
    

    default:
        return null;
} 
    }
    
}
