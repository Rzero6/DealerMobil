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

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class CustomerDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertCustomer(Customer c){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO customer(namaCustomer, tanggalLahirCustomer, alamatCustomer) "
                + "VALUES ('" 
                + c.getNama()+ "', '"
                + c.getTanggalLahir()+ "', '"
                + c.getAlamat()+ "')";
        
        System.out.println("Adding Customer ...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added "+result+" Customer");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Customer ...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public void updateCustomer(Customer c) {

        con = dbcon.makeConnection();
        
           String sql = "UPDATE customer SET namaCustomer = '" + c.getNama()+ "', "
                + "tanggalLahirCustomer = '" + c.getTanggalLahir()+ "', "
                + "alamatCustomer = '" + c.getAlamat()+ "' "
                + "WHERE (idCustomer = '" + c.getId() + "')"; 
           System.out.println("Editing Customer ...");
                
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Customer " + c.getId());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Customer ...");
            System.out.println(e);
        }

        dbcon.closeConnection();
    }
    
    public void deleteCustomer(int id) {

        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM customer WHERE idCustomer = '" + id + "'";
        System.out.println("Deleting Customer ...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Customer " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Customer...");
            System.out.println(e);
        }

        dbcon.closeConnection();
    }
    
    public List<Customer> getListCustomer(String query){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM customer WHERE "
                + "(idCustomer LIKE '%"+query+"%'"
                + "OR namaCustomer LIKE '%"+query+"%'"
                + "OR tanggalLahirCustomer LIKE '%"+query+"%'"
                + "OR alamatCustomer LIKE '%"+query+"%')"
                ;
        System.out.println("Mengambil data customer ...");
        
        List<Customer> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while (rs.next()){
                    Customer c = new Customer(
                            rs.getInt("idCustomer"),
                            rs.getString("namaCustomer"),
                            rs.getString("tanggalLahirCustomer"),
                            rs.getString("alamatCustomer")
                    );
                    list.add(c);
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
