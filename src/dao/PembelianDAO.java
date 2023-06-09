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
import model.Pembelian;
import model.Suplier;

/**
 * Nama : Reynold Kunarto 
 * NPM : 210711015
 * 
 * Nama : Febiola Ika Putri Wibowo
 * NPM : 210711023
 */
/**
 *
 * @author VICTUS
 */
public class PembelianDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertPembelian(Pembelian p){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO pembelian(idSuplier, idKendaraan, totalHargaBeli, jumlahSuplai, tanggalPembelian) "
                + "VALUES ('" 
                + p.getSuplier().getId()+ "', '"
                + p.getKendaraan().getId()+ "', '"
                + p.getTotalHargaBeli()+ "', '"
                + p.getJumlahSuplai()+ "', '"
                + p.getTanggalPembelian()+ "')";
        
        System.out.println("Adding Pembelian ...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added "+result+" Pembelian");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Pembelian ...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public List getListPembelian(String query){
        con = dbcon.makeConnection();
        
        String sql = "SELECT p.*, k.*, s.* FROM pembelian as p"
                + " JOIN kendaraan as k ON p.idKendaraan = k.idKendaraan"
                + " JOIN suplier as s ON p.idSuplier = s.idSuplier"
                + " WHERE (p.tanggalPembelian LIKE '%" + query + "%'"
                + " OR k.namaKendaraan LIKE '%" + query + "%'"
                + " OR k.merkKendaraan LIKE '%" + query + "%'"
                + " OR k.jenisKendaraan LIKE '%" + query + "%'"
                + " OR k.hargaKendaraan LIKE '%" + query + "%'"
                + " OR p.jumlahSuplai LIKE '%" + query + "%'"
                + " OR p.totalHargaBeli LIKE '%" + query + "%'"
                + " OR s.namaSuplier LIKE '%" + query + "%')"
                + " ORDER BY p.tanggalPembelian DESC";
        System.out.println("Mengambil data Pembelian ...");
        
        List<Pembelian> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while (rs.next()){
                    Kendaraan k = new Kendaraan(
                            rs.getInt("k.idKendaraan"),
                            rs.getString("k.namaKendaraan"),
                            rs.getString("k.jenisKendaraan"),
                            rs.getString("k.merkKendaraan"),
                            rs.getFloat("k.hargaKendaraan"),
                            rs.getInt("k.jumlahKendaraan")
                    );
                    
                    Suplier s = new Suplier(
                            rs.getInt("s.idSuplier"), 
                            rs.getString("s.namaSuplier")
                    );
                    
                    Pembelian p = new Pembelian(
                            rs.getInt("p.idPembelian"),
                            s,
                            k,
                            rs.getFloat("p.totalHargaBeli"),
                            rs.getInt("p.jumlahSuplai"),
                            rs.getString("p.tanggalPembelian").replace(".0", "")
                    );
                    
                    list.add(p);
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
}
