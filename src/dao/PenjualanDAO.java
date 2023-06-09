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
import model.Customer;
import model.Kendaraan;
import model.Penjualan;
import model.Staff;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class PenjualanDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertPenjualan(Penjualan p){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO penjualan(idKendaraan, idCustomer, idStaff, totalHarga, jenisPembayaran, tanggalPenjualan, jumlahPenjualan) "
                + "VALUES ('" 
                + p.getIdKendaraan()+ "', '"
                + p.getIdCustomer()+ "', '"
                + p.getIdStaff()+ "', '"
                + p.getTotalHarga()+ "', '"
                + p.getJenisPembayaran()+ "', '"
                + p.getTanggalPenjualan()+ "', '"
                + p.getJumlahPenjualan()+ "')";
        
        System.out.println("Adding Penjualan ...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added "+result+" Penjualan");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Penjualan ...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public List getListPenjualan(String query){
        con = dbcon.makeConnection();
        
        String sql = "SELECT p.*, k.*, c.*,s.* FROM penjualan as p"
                + " JOIN kendaraan as k ON p.idKendaraan = k.idKendaraan"
                + " JOIN customer as c ON p.idCustomer = c.idCustomer"
                + " JOIN staff as s ON p.idStaff = s.idStaff"
                + " WHERE (p.tanggalPenjualan LIKE '%" + query + "%'"
                + " OR k.namaKendaraan LIKE '%" + query + "%'"
                + " OR k.merkKendaraan LIKE '%" + query + "%'"
                + " OR k.jenisKendaraan LIKE '%" + query + "%'"
                + " OR k.hargaKendaraan LIKE '%" + query + "%'"
                + " OR p.jumlahPenjualan LIKE '%" + query + "%'"
                + " OR p.totalHarga LIKE '%" + query + "%'"
                + " OR p.tanggalPenjualan LIKE '%" + query + "%'"
                + " OR c.namaCustomer LIKE '%" + query + "%'"
                + " OR s.namaStaff LIKE '%" + query + "%')";
        System.out.println("Mengambil data Penjualan ...");
        
        List<Penjualan> list = new ArrayList();
        
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
                    
                    Customer c = new Customer(
                            rs.getInt("c.idCustomer"),
                            rs.getString("c.namaCustomer"),
                            rs.getString("c.tanggalLahirCustomer"),
                            rs.getString("c.alamatCustomer")
                    );
                    
                    Staff s = new Staff(
                            rs.getInt("s.idStaff"), 
                            rs.getString("s.namaStaff"), 
                            rs.getString("s.jabatanStaff"), 
                            rs.getFloat("s.gajiStaff")
                    );
                    Penjualan p = new Penjualan(
                            rs.getInt("p.idPenjualan"),
                            k,
                            c,
                            s,
                            rs.getFloat("p.totalHarga"),
                            rs.getString("p.jenisPembayaran"),
                            rs.getString("p.tanggalPenjualan"),
                            rs.getInt("p.jumlahPenjualan")
                            
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
