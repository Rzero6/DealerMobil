/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package table;

import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Penjualan;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class TablePenjualan extends AbstractTableModel{
    private List<Penjualan> list;
    
    public TablePenjualan(List<Penjualan> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        String formattedValue = "";
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getTanggalPenjualan();
            case 1:
                return list.get(rowIndex).getKendaraan().getNama();
            case 2:
                return list.get(rowIndex).getKendaraan().getMerk();
            case 3:
                return list.get(rowIndex).getKendaraan().getJenis();
            case 4:
                formattedValue = decimalFormat.format(list.get(rowIndex).getKendaraan().getHarga());
                return formattedValue;
            case 5:
                return list.get(rowIndex).getJumlahPenjualan();
            case 6:
                formattedValue = decimalFormat.format(list.get(rowIndex).getTotalHarga());
                return formattedValue;
            case 7:
                return list.get(rowIndex).getCustomer().getNama();
            case 8:
                return list.get(rowIndex).getStaff().getNama();
            case 9:
                return list.get(rowIndex).getIdPenjualan();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Tanggal";
            case 1:
                return "Nama";
            case 2:
                return "Merk";
            case 3: 
                return "Jenis";
            case 4:
                return "Harga";
            case 5:
                return "Jumlah";
            case 6:
                return "Total";
            case 7:
                return "Customer";
            case 8:
                return "Staff";
            default:
                return null;
        }
    }
}
