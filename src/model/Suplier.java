/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 
 */
/**
 *
 * @author VICTUS
 */
public class Suplier {
    private int id;
    private String nama;

    public Suplier(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Suplier(String nama) {
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public String toString(){
        return nama;
    }
}
