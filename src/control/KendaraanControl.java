/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import table.TableKendaraan;
import dao.KendaraanDAO;
import java.util.List;
import model.Kendaraan;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class KendaraanControl {
    KendaraanDAO kDao = new KendaraanDAO();
    public void insertKendaraan(Kendaraan k){
        kDao.insertKendaraan(k);
    }
    public void updateKendaraan(Kendaraan k){
        kDao.updateKendaraan(k);
    }
    public void updateJumlahKendaraan(int id, int jumlah, String tipe){
        kDao.updateJumlah(id, jumlah, tipe);
    }
    public void deleteKendaraan(int id){
        kDao.deleteKendaraan(id);
    }
    public List getListKendaraan(String query){
        return kDao.getListKendaraan(query);
    }
    public TableKendaraan getTableKendaraan(String query){
        List<Kendaraan> list = getListKendaraan(query);
        TableKendaraan table = new TableKendaraan(list);
        return table;
    }
    public Kendaraan searchKendaraan(String nama){
        return kDao.searchKendaraan(nama);
    }
}
