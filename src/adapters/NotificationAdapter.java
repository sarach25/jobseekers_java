/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Adapters;


import DAO.notificationDAO;
import entities.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Carlos
 */
public class NotificationAdapter extends AbstractTableModel{
    
    List<notification> notif;
    String data[]={"id_notif","idmessage","idmembre_rec","contenu_n"};
    
    public NotificationAdapter()
    {
        notif=new notificationDAO().findAll();
    }
    
    @Override
     public String getColumnName(int column) {
      
       return data[column];
    }

    @Override
    public int getRowCount() {
        return notif.size();
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
       return notif.get(rowIndex).getIdNotif();
    case 1:
      return notif.get(rowIndex).getIdmessage();
    case 2:
         return notif.get(rowIndex).getIdmembre();
    case 3:
        return notif.get(rowIndex).getContenuNotif();
    
    

    default:
        return null;
} 
    }
}
