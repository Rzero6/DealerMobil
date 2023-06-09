/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.StaffDAO;
import java.util.List;
import model.Staff;
import table.TableStaff;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class StaffControl {
    StaffDAO sDao = new StaffDAO();
    public void insertStaff(Staff s){
        sDao.insertStaff(s);
    }
    public void updateStaff(Staff s){
        sDao.updateStaff(s);
    }
    public void deleteStaff(int id){
        sDao.deleteStaff(id);
    }
    public List getListStaff(String query){
        return sDao.getListStaff(query);
    }
    public TableStaff getTableStaff(String query){
        List<Staff> list = getListStaff(query);
        TableStaff table = new TableStaff(list);
        return table;
    }
}
