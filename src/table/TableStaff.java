/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Staff;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class TableStaff extends AbstractTableModel{
    private List<Staff> list;
    
    public TableStaff(List<Staff> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getJabatan();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                String formattedValue = decimalFormat.format(list.get(rowIndex).getGaji());
                return formattedValue;
            case 3:
                return list.get(rowIndex).getId();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "jabatan";
            case 1:
                return "Nama";
            case 2:
                return "Gaji";
            default:
                return null;
        }
    }
}
