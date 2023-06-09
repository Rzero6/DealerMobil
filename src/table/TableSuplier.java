/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Suplier;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class TableSuplier extends AbstractTableModel{
    private List<Suplier> list;
    
    public TableSuplier(List<Suplier> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Nama";
            default:
                return null;
        }
    }
}
