/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Kendaraan;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class KendaraanDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertKendaraan(Kendaraan k){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO kendaraan(namaKendaraan, jenisKendaraan, merkKendaraan, hargakendaraan, jumlahKendaraan) "
                + "VALUES ('" 
                + k.getNama()+ "', '"
                + k.getJenis() + "', '"
                + k.getMerk() + "', '"
                + k.getHarga()+ "', '"
                + k.getJumlah() + "')";
        
        System.out.println("Adding Kendaraan ...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added "+result+" Kendaraan");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Kendaraan ...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public void updateKendaraan(Kendaraan k) {

        con = dbcon.makeConnection();
        
           String sql = "UPDATE kendaraan SET namaKendaraan = '" + k.getNama()+ "', "
                + "jenisKendaraan = '" + k.getJenis()+ "', "
                + "merkKendaraan = '" + k.getMerk()+ "', "
                + "hargaKendaraan = '" + k.getHarga()+ "', "
                + "jumlahKendaraan = '" + k.getJumlah()+ "'"
                + "WHERE (idKendaraan = '" + k.getId() + "')"; 
           System.out.println("Editing Kendaraan ...");
                
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Kendaraan " + k.getId());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Kendaraan ...");
            System.out.println(e);
        }

        dbcon.closeConnection();
    }
    
    public void deleteKendaraan(int id) {

        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM kendaraan WHERE idKendaraan = '" + id + "'";
        System.out.println("Deleting Kendaraan ...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Kendaraan " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Kendaraan...");
            System.out.println(e);
        }

        dbcon.closeConnection();
    }
    
    public List<Kendaraan> getListKendaraan(String query){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM kendaraan WHERE "
                + "(idKendaraan LIKE '%"+query+"%'"
                + "OR namaKendaraan LIKE '%"+query+"%'"
                + "OR jenisKendaraan LIKE '%"+query+"%'"
                + "OR merkKendaraan LIKE '%"+query+"%'"
                + "OR hargaKendaraan LIKE '%"+query+"%'"
                + "OR jumlahKendaraan LIKE '%"+query+"%')"
                ;
        System.out.println("Mengambil data kendaraan ...");
        
        List<Kendaraan> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while (rs.next()){
                    Kendaraan k = new Kendaraan(
                            rs.getInt("idKendaraan"),
                            rs.getString("namaKendaraan"),
                            rs.getString("jenisKendaraan"),
                            rs.getString("merkKendaraan"),
                            rs.getFloat("hargaKendaraan"),
                            rs.getInt("jumlahKendaraan")
                    );
                    list.add(k);
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error reading database ...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        
        return list;
    }
    
    public void updateJumlah(int id, int jumlah, String tipe){
        con = dbcon.makeConnection();
        
           String sql = "UPDATE kendaraan SET jumlahKendaraan = jumlahKendaraan "+tipe+" " +jumlah
                + " WHERE (idKendaraan = " + id + ")"; 
           System.out.println("Editing Kendaraan ...");
                
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Kendaraan " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Kendaraan ...");
            System.out.println(e);
        }

        dbcon.closeConnection();
    }
    
    public Kendaraan searchKendaraan(String nama){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM kendaraan WHERE "
                + "(namaKendaraan LIKE '"+nama+"') LIMIT 1"
                ;
        System.out.println("Mengambil data kendaraan ...");
        Kendaraan k = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs.next()){
                k = new Kendaraan(
                            rs.getInt("idKendaraan"),
                            rs.getString("namaKendaraan"),
                            rs.getString("jenisKendaraan"),
                            rs.getString("merkKendaraan"),
                            rs.getFloat("hargaKendaraan"),
                            rs.getInt("jumlahKendaraan")
                    );
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error reading database ...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        
        return k;
    }
}
