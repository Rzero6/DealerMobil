/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.CustomerDAO;
import java.util.List;
import model.Customer;
import table.TableCustomer;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class CustomerControl {
    CustomerDAO cDao = new CustomerDAO();
    public void insertCustomer(Customer c){
        cDao.insertCustomer(c);
    }
    public void updateCustomer(Customer c){
        cDao.updateCustomer(c);
    }
    public void deleteCustomer(int id){
        cDao.deleteCustomer(id);
    }
    public List getListCustomer(String query){
        return cDao.getListCustomer(query);
    }
    public TableCustomer getTableCustomer(String query){
        List<Customer> list = getListCustomer(query);
        TableCustomer table = new TableCustomer(list);
        return table;
    }
}
