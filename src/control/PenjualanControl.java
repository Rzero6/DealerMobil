/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.PenjualanDAO;
import java.util.List;
import model.Penjualan;
import table.TablePenjualan;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class PenjualanControl {
    PenjualanDAO pDao = new PenjualanDAO();
    public void insertPenjualan(Penjualan p){
        pDao.insertPenjualan(p);
    }
    public List getListPenjualan(String query){
        return pDao.getListPenjualan(query);
    }
    public TablePenjualan getTablePenjualan(String query){
        List<Penjualan> list = getListPenjualan(query);
        TablePenjualan table = new TablePenjualan(list);
        return table;
    }
}
