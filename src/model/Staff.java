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
public class Staff {
    private int id;
    private String nama, jabatan;
    private float gaji;

    public Staff(int id, String nama, String jabatan, float gaji) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
        this.gaji = gaji;
    }

    public Staff(String nama, String jabatan, float gaji) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.gaji = gaji;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public float getGaji() {
        return gaji;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public void setGaji(float gaji) {
        this.gaji = gaji;
    }
    public String toString(){
        return nama;
    }
}
