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
import model.Suplier;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class SuplierDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertSuplier(Suplier s){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO suplier(namaSuplier) "
                + "VALUES ('" 
                + s.getNama()+ "')";
        
        System.out.println("Adding Suplier ...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added "+result+" Suplier");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Suplier ...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public void updateSuplier(Suplier s) {

        con = dbcon.makeConnection();
        
           String sql = "UPDATE suplier SET namaSuplier = '" + s.getNama()+ "'"
                + " WHERE (idSuplier = '" + s.getId() + "')"; 
           System.out.println("Editing Suplier ...");
                
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Suplier " + s.getId());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Suplier ...");
            System.out.println(e);
        }

        dbcon.closeConnection();
    }
    
    public void deleteSuplier(int id) {

        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM suplier WHERE idSuplier = '" + id + "'";
        System.out.println("Deleting Suplier ...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Suplier " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Suplier...");
            System.out.println(e);
        }

        dbcon.closeConnection();
    }
    
    public List<Suplier> getListSuplier(String query){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM suplier WHERE "
                + "(idSuplier LIKE '%"+query+"%'"
                + "OR namaSuplier LIKE '%"+query+"%')"
                ;
        System.out.println("Mengambil data suplier ...");
        
        List<Suplier> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while (rs.next()){
                    Suplier s = new Suplier(
                            rs.getInt("idSuplier"),
                            rs.getString("namaSuplier")
                    );
                    list.add(s);
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
    
    public Suplier searchSuplier(String nama){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM suplier WHERE "
                + "(namaSuplier LIKE '"+nama+"') LIMIT 1"
                ;
        System.out.println("Mengambil data suplier ...");
        Suplier s = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs.next()){
                s = new Suplier(
                            rs.getInt("idSuplier"),
                            rs.getString("namaSuplier")
                    );
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error reading database ...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        
        return s;
    }
}
