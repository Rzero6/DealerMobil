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
import model.Staff;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class StaffDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertStaff(Staff s){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO staff(namaStaff, jabatanStaff, gajiStaff) "
                + "VALUES ('" 
                + s.getNama()+ "', '"
                + s.getJabatan()+ "', '"
                + s.getGaji()+ "')";
        
        System.out.println("Adding Staff ...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added "+result+" Staff");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Staff ...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public void updateStaff(Staff s) {

        con = dbcon.makeConnection();
        
           String sql = "UPDATE staff SET namaStaff = '" + s.getNama()+ "', "
                + "jabatanStaff = '" + s.getJabatan()+ "', "
                + "gajiStaff = '" + s.getGaji()+ "' "
                + "WHERE (idStaff = '" + s.getId() + "')"; 
           System.out.println("Editing Staff ...");
                
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Staff " + s.getId());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Staff ...");
            System.out.println(e);
        }

        dbcon.closeConnection();
    }
    
    public void deleteStaff(int id) {

        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM staff WHERE idStaff = '" + id + "'";
        System.out.println("Deleting Staff ...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Staff " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Staff...");
            System.out.println(e);
        }

        dbcon.closeConnection();
    }
    
    public List<Staff> getListStaff(String query){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM staff WHERE "
                + "(idStaff LIKE '%"+query+"%'"
                + "OR namaStaff LIKE '%"+query+"%'"
                + "OR jabatanStaff LIKE '%"+query+"%'"
                + "OR gajiStaff LIKE '%"+query+"%')"
                ;
        System.out.println("Mengambil data staff ...");
        
        List<Staff> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while (rs.next()){
                    Staff s = new Staff(
                            rs.getInt("idStaff"),
                            rs.getString("namaStaff"),
                            rs.getString("jabatanStaff"),
                            rs.getFloat("gajiStaff")
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
}
