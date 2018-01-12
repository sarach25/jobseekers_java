/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import DAO.groupeDAO;
import entities.groupe;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Slim
 */
public class groupeAdapter extends AbstractTableModel {

    List<groupe> groupes;
    String[] data = {"ID", "Nom", "Description", "URL"};

    public groupeAdapter() {
        groupes = new groupeDAO().findAll();
    }

    @Override
    public String getColumnName(int column) {
        return data[column];
    }

    @Override
    public int getRowCount() {
        return groupes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return groupes.get(rowIndex).getIdGroupe();
            case 1:
                return groupes.get(rowIndex).getNomGroupe();
            case 2:
                return groupes.get(rowIndex).getContenuGroupe();
            case 3:
                return groupes.get(rowIndex).getImGroupe();
            default:
                return null;
        }
    }

}
