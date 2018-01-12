/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import DAO.entrepriseDAO;
import entities.entreprise;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Slim
 */
public class entrepriseAdapter extends AbstractTableModel {

    List<entreprise> entreprises;
    String[] data = {"ID", "Nom", "Domaine", "Adresse"};

    public entrepriseAdapter() {
        entreprises = new entrepriseDAO().findAll();
    }

    @Override
    public String getColumnName(int column) {
        return data[column];
    }

    @Override
    public int getRowCount() {
        return entreprises.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return entreprises.get(rowIndex).getIdEntreprise();
            case 1:
                return entreprises.get(rowIndex).getNomEntreprise();
            case 2:
                return entreprises.get(rowIndex).getDomaine();
            case 3:
                return entreprises.get(rowIndex).getAdresse();
            default:
                return null;
        }
    }

}
